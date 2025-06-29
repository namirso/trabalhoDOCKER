package br.ufsm.csi.trabalhopoow1spring.dao;

import br.ufsm.csi.trabalhopoow1spring.model.Permissao;
import br.ufsm.csi.trabalhopoow1spring.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PermissaoDAO {

    public String alterarPermissao(Permissao permissao, Usuario usuario) {
        try {
            Connection conn = ConectarBancoDados.conectarBancoPostgres();
            PreparedStatement stmt = conn.prepareStatement(
                    "UPDATE usuario_permissao SET idusuario = ?, idpermissao = ? WHERE idup = ?"
            );

            stmt.setInt(1, usuario.getId());
            stmt.setInt(2, permissao.getId());

            stmt.execute();
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao alterar usuario");
        }

        return "Usuario alterado com sucesso";
    }
}
