package com.primeira.appSpring.service;

import com.primeira.appSpring.model.M_Contato;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class S_Contato {

    private List<M_Contato> contatos = new ArrayList<>();
    private Long currentId = 1L;

    public void salvarContato(String nome, String apelido, String email, String telefone) {
        M_Contato novoContato = new M_Contato();
        novoContato.setId_contato(currentId++);
        novoContato.setNome(nome);
        novoContato.setApelido(apelido);
        novoContato.setEmail(email);
        novoContato.setTelefone(telefone);
        contatos.add(novoContato);
    }

    // Lista todos os contatos
    public List<M_Contato> listarContatos() {
        return contatos;
    }

    // Exclui um contato pelo ID
    public boolean excluirContato(Long id) {
        Optional<M_Contato> contato = contatos.stream()
                .filter(c -> c.getId_contato().equals(id))
                .findFirst();

        if (contato.isPresent()) {
            contatos.remove(contato.get());
            return true;
        }
        return false;
    }
}
