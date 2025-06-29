package br.ufsm.csi.trabalhopoow1spring.controller;

import br.ufsm.csi.trabalhopoow1spring.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class LoginController {

    @GetMapping
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    public String login(Model model, String email, String senha) {
        if((new LoginService().autenticar(email,senha))){
            return "redirect:/menu";
        } else {
            model.addAttribute("msg","Email ou senha incorretos");
            return "index";
        }
    }

    @GetMapping("/menu")
    public String menu() {
        return "pages/menu";
    }
}
