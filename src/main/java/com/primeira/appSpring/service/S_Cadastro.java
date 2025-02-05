package com.primeira.appSpring.service;

import com.primeira.appSpring.model.M_Usuario;
import com.primeira.appSpring.repository.R_Usuario;
import org.springframework.stereotype.Service;

@Service
public class S_Cadastro {
    private static R_Usuario r_usuario;

    public S_Cadastro(R_Usuario r_usuario) {
        this.r_usuario = r_usuario;
    }

    public static M_Usuario cadastrarUsuario(String usuario,
                                      String apelido,
                                      String telefone,
                                      String senha,
                                      String conf_senha){
        boolean podeSalvar = true;

        if (senha == null || !senha.trim().equals(conf_senha)){
            podeSalvar = false;
        }
        if(usuario.trim().equals("") || usuario == null){
            podeSalvar = false;
        }
        if(apelido.trim().equals("") || apelido == null){
            podeSalvar = false;
        }

        if(podeSalvar){
            M_Usuario m_usuario = new M_Usuario();
            m_usuario.setUsuario(usuario);
            m_usuario.setApelido(apelido);
            m_usuario.setSenha(senha);
            return r_usuario.save(m_usuario);
        }
        return null;
    }
}
