package com.primeira.appSpring.controller;

import com.primeira.appSpring.model.M_Usuario;
import com.primeira.appSpring.service.S_Cadastro;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Cadastro {
    @GetMapping("/cadastro")
    public String getCadastro(){
        return "cadastro/cadastro";
    }

    @PostMapping("/cadastro")
    public String postCadastro(@RequestParam("usuario") String usuario,
                               @RequestParam("apelido") String apelido,
                               @RequestParam("senha") String senha,
                               @RequestParam("conf_senha") String conf_senha){
        M_Usuario m_usuario = S_Cadastro.cadastrarUsuario(usuario, apelido, senha, conf_senha);
        if(m_usuario != null){
            return "index";
        }
        return "cadastro/cadastro";
    }
}
