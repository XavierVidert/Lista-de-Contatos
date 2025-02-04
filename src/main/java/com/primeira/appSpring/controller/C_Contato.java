package com.primeira.appSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_Contato {

    @GetMapping("/adicionarContato")
    public String getAdicionarContato() {
        return "novocontato/adicionarContato";
    }

    @PostMapping("/adicionarContato")
    public String postAdicionarContato(@RequestParam("nome") String nome,
                                       @RequestParam("apelido") String apelido,
                                       @RequestParam("email") String email,
                                       @RequestParam("telefone") String telefone,
                                       Model model) {
        // Aqui você pode salvar os dados no banco ou processar como quiser
        model.addAttribute("mensagem", "Contato adicionado com sucesso!");
        return "novocontato/adicionarContato";
    }
}
