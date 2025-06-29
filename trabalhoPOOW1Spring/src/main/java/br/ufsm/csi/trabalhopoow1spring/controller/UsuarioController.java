package br.ufsm.csi.trabalhopoow1spring.controller;

import br.ufsm.csi.trabalhopoow1spring.model.Usuario;
import br.ufsm.csi.trabalhopoow1spring.service.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", new UsuarioService().listar());
        model.addAttribute("usuario", new Usuario());

        return "pages/usuarios";
    }

    @PostMapping
    public String criarUsuario(Usuario usuario, RedirectAttributes attributes) {
        String retorno = new UsuarioService().inserir(usuario);
        attributes.addFlashAttribute("mensagem", retorno);

        return "redirect:/usuarios";
    }

    @GetMapping("/excluir/{usuarioId}")
    public String excluir(@PathVariable int usuarioId, RedirectAttributes attributes) {
        String retorno = new UsuarioService().excluir(usuarioId);
        attributes.addFlashAttribute("mensagem", retorno);
        return "redirect:/usuarios";
    }

}
