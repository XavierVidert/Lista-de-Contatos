package com.primeira.appSpring.service;

import com.primeira.appSpring.entity.Contato;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class S_Contato {

    private List<Contato> contatos = new ArrayList<>();
    private Long currentId = 1L;

    // Adiciona um contato à lista
    public void salvarContato(String nome, String apelido, String email, String telefone) {
        Contato novoContato = new Contato(currentId++, nome, apelido, email, telefone);
        contatos.add(novoContato);
    }

    // Lista todos os contatos
    public List<Contato> listarContatos() {
        return contatos;
    }

    // Exclui um contato pelo ID
    public boolean excluirContato(Long id) {
        Optional<Contato> contato = contatos.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();

        if (contato.isPresent()) {
            contatos.remove(contato.get());
            return true;
        }
        return false;
    }
}
