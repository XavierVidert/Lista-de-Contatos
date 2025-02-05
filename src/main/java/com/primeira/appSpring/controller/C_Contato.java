package com.primeira.appSpring.controller;

import com.primeira.appSpring.model.M_Usuario;
import com.primeira.appSpring.service.S_Contato;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class C_Contato {

    private final S_Contato s_contato;

    public C_Contato(S_Contato s_contato) {
        this.s_contato = s_contato;
    }

    @GetMapping("/adicionarContato")
    public String getCadastro() {
        return "novocontato/adicionarContato";
    }

    @PostMapping("/adicionarContato")
    public String postCadastro(@RequestParam("usuario") String usuario,
                               @RequestParam("apelido") String apelido,
                               @RequestParam("telefone") String telefone,
                               @RequestParam("email") String email,
                               Model model) {

        //M_Usuario m_usuario = s_contato.(usuario, apelido, telefone, senha, conf_senha);
//
//        if (m_usuario != null) {
//            model.addAttribute("mensagem", "Usuário cadastrado com sucesso!");
//            return "redirect:/";
//        }
        return null;
    }


    @GetMapping("/excluir")
    public String excluirContato(@RequestParam("id") Long id, RedirectAttributes redirectAttributes) {
        if (s_contato.excluirContato(id)) {
            redirectAttributes.addFlashAttribute("mensagem", "Contato excluído com sucesso!");
        } else {
            redirectAttributes.addFlashAttribute("mensagem", "Erro ao excluir contato!");
        }
        return "redirect:/";
    }
}
