package com.primeira.appSpring.service;

import com.primeira.appSpring.model.M_Locacao;
import com.primeira.appSpring.model.M_Usuario;
import com.primeira.appSpring.repository.R_Locacao;
import com.primeira.appSpring.repository.R_Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class S_Home {
    @Autowired
    private R_Locacao r_locacao;

    public S_Home(R_Usuario r_usuario){
        this.r_locacao = r_locacao;
    }

    public List<M_Locacao> getLocacaoEmCurso(Long id_usuario){
        return r_locacao.getLocacaoEmCurso(id_usuario);
    }
}
