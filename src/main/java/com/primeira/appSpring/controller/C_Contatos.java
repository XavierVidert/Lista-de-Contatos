package com.primeira.appSpring.controller;



import com.primeira.appSpring.service.S_Contato;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/")
public class C_Contatos {

    @Autowired
    private S_Contato contatoService;

    @GetMapping
    public String exibirHome(Model model) {
        model.addAttribute("contatos", contatoService.listarContatos());
        return "home"; // Nome da sua página inicial (home.html)
    }

    @GetMapping("/excluir")
    public String excluirContato(@RequestParam("id") Long id, Model model) {
        contatoService.excluirContato(id);
        model.addAttribute("mensagem", "Contato excluído com sucesso!");
        return "redirect:/"; // Redireciona para a Home com a lista atualizada
    }
}
