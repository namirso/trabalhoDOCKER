package br.ufsm.csi.trabalhopoow1spring.service;

import br.ufsm.csi.trabalhopoow1spring.model.Usuario;

public class LoginService {

    public boolean autenticar(String email, String senha) {

        UsuarioService usuarioService = new UsuarioService();
        Usuario usuario = usuarioService.buscar(email);

        return senha.equals(usuario.getSenha());

    }

}
