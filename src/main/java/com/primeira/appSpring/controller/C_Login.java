package com.primeira.appSpring.controller;

import com.primeira.appSpring.model.M_Usuario;
import com.primeira.appSpring.service.S_Contato;
import com.primeira.appSpring.service.S_Login;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Login {
    private final S_Contato s_contato;
    private final S_Login s_login;

    public C_Login(S_Contato s_contato, S_Login s_login) {
        this.s_contato = s_contato;
        this.s_login = s_login;
    }

    @GetMapping("/")
    public String getLogin(HttpSession session, Model model) {
        M_Usuario m_usuario = (M_Usuario) session.getAttribute("usuario");

        // Se o usuário já estiver logado, exibe a lista de contatos
        if (m_usuario != null) {
            model.addAttribute("contatos", s_contato.listarContatos());
            return "home/home";
        }

        return "index"; // Página de login
    }

    @PostMapping("/")
    public String postLogin(@RequestParam("usuario") String usuario,
                            @RequestParam("senha") String senha,
                            HttpSession session, Model model) {
        M_Usuario m_usuario = s_login.validaLogin(usuario, senha);

        if (m_usuario != null) {
            session.setAttribute("usuario", m_usuario);
            return "redirect:/"; // Redireciona para a Home com os contatos
        }

        model.addAttribute("erro", "Usuário ou senha inválidos!");
        return "index";
    }

    @GetMapping("/logout")
    @ResponseBody
    public boolean getLogout(HttpSession session){
        session.setAttribute("usuario",null);
        return true;
    }
}
