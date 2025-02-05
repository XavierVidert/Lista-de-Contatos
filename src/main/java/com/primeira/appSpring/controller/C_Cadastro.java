package com.primeira.appSpring.controller;

import com.primeira.appSpring.model.M_Usuario;
import com.primeira.appSpring.service.S_Cadastro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Cadastro {

    private final S_Cadastro s_cadastro;

    @Autowired
    public C_Cadastro(S_Cadastro s_cadastro) {
        this.s_cadastro = s_cadastro;
    }

    @GetMapping("/cadastro")
    public String getCadastro() {
        return "cadastro/cadastro";
    }



    @PostMapping("/cadastro")
    public String postCadastro(@RequestParam("usuario") String usuario,
                               @RequestParam("apelido") String apelido,
                               @RequestParam("telefone") String telefone,
                               @RequestParam("senha") String senha,
                               @RequestParam("conf_senha") String conf_senha,
                               Model model) {

        M_Usuario m_usuario = s_cadastro.cadastrarUsuario(usuario, apelido, telefone, senha, conf_senha);

        if (m_usuario != null) {
            model.addAttribute("mensagem", "Usuário cadastrado com sucesso!");
            return "redirect:/";
        }

        model.addAttribute("erro", "Erro ao cadastrar o usuário!");
        return "cadastro/cadastro";
    }
}
