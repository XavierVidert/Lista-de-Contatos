package com.primeira.appSpring.controller;

import com.primeira.appSpring.model.M_Usuario;
import com.primeira.appSpring.service.S_Login;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Login {

    // Método GET para mostrar o formulário de login
    @GetMapping("/")
    public String getLogin(HttpSession session, Model model) {
        // Verifica se já há um usuário na sessão, redirecionando para a página principal
        if (session.getAttribute("usuario") != null) {
            return "redirect:/home"; // Se o usuário já estiver logado, vai para a página inicial
        }
        return "index"; // Caso contrário, exibe o formulário de login
    }

    // Método POST para processar o login
    @PostMapping("/")
    public String postLogin(@RequestParam("usuario") String usuario,
                            @RequestParam("senha") String senha,
                            HttpSession session, Model model) {

        // Verifica se as credenciais são válidas
        M_Usuario m_usuario = S_Login.validaLogin(usuario, senha);

        // Se o login for válido, salva na sessão
        if (m_usuario != null) {
            session.setAttribute("usuario", m_usuario);
            return "redirect:/home"; // Redireciona para a página inicial após o login bem-sucedido
        }

        // Caso as credenciais sejam inválidas, retorna à página de login com uma mensagem de erro
        model.addAttribute("erro", "Usuário ou senha inválidos!");
        return "index"; // Redireciona de volta para a página de login
    }

    // Método GET para fazer o logout do usuário
    @GetMapping("/logout")
    public String getLogout(HttpSession session) {
        session.invalidate(); // Invalida a sessão do usuário, removendo todos os dados
        return "redirect:/"; // Redireciona para a página inicial (login)
    }
}
