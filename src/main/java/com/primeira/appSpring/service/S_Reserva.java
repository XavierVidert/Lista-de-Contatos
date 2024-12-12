package com.primeira.appSpring.service;

import com.primeira.appSpring.model.M_Locacao;
import com.primeira.appSpring.model.M_Quarto;
import com.primeira.appSpring.model.M_Quarto;
import com.primeira.appSpring.model.M_Resposta;
import com.primeira.appSpring.repository.R_Locacao;
import com.primeira.appSpring.repository.R_Quarto;
import com.primeira.appSpring.repository.R_Quarto;
import com.sun.jdi.event.ExceptionEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class S_Reserva {
    @Autowired
    private R_Locacao r_locacao;
    @Autowired
    private R_Quarto r_quartos;

    public M_Resposta realizarReserva(String checkin,
                                      String checkout,
                                      Long quarto,
                                      Long usuario){
        String mensagem = "";
        boolean podeSalvar = true;
        LocalDateTime entrada = null;
        LocalDateTime saida = null;

        try {
            entrada = LocalDateTime.parse(LocalDate.parse(checkin).atTime(14, 0, 0).toString());
        }catch (Exception e){
            podeSalvar = false;
            mensagem += "A data de CheckIn informada não é valida!";
        }

        try {
            saida = LocalDateTime.parse(LocalDate.parse(checkout).atTime(10, 0, 0).toString());
        } catch (Exception e){
            podeSalvar = false;
            mensagem += "A data de CheckOut informada não é valida!";
        }

        if((entrada != null || saida != null) && entrada.isAfter(saida)){
            podeSalvar = false;
            mensagem += "A data de CheckIn não pode ser maior que a data de CheckOut";
        }

        M_Locacao m_locacao = this.r_locacao.quartoEstaLocado(quarto, entrada, saida);
        if(m_locacao != null){
            podeSalvar = false;
            mensagem += "O quarto que você escolheu já está ocupado, por favor selecione outro!!!";
        }

        M_Quarto m_quartos = this.r_quartos.findById(quarto).orElse(null);
        if(m_quartos == null){
            podeSalvar = false;
            mensagem += "O quarto escolhido é invalido, por favor selcione outro!!!";
        }

        if(podeSalvar) {
            try {
                m_locacao = new M_Locacao();
                m_locacao.setCheckIn(entrada);
                m_locacao.setCheckOut(saida);
                m_locacao.setIdUsuario(usuario);
                m_locacao.setIdQuarto(quarto);
                m_locacao.setPreco(m_quartos.getPreco());
                Random rand = new Random();
                m_locacao.setSenha(String.valueOf(rand.nextInt(1000, 10000)));
                r_locacao.save(m_locacao);
                mensagem = "Reserva realizada com sucesso!";
            }catch (Exception e){
                podeSalvar = false;
                mensagem += "Erro ao cadastrar a reserva, falha na comunicação com a base de dados, tente novamente!!!";
            }
        }

        return new M_Resposta(podeSalvar, mensagem);
    }
}
