package com.primeira.appSpring.service;

import com.primeira.appSpring.model.M_Locacao;
import com.primeira.appSpring.model.M_Quarto;
import com.primeira.appSpring.repository.R_Locacao;
import com.primeira.appSpring.repository.R_Quarto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class S_Reserva {
    @Autowired
    private R_Locacao r_locacao;
    @Autowired
    private R_Quarto r_quarto;

    public M_Locacao realizarReserva(String checkin, String checkout, long quarto,long usuario){
        M_Quarto m_quarto =  this.r_quarto.findById(quarto).orElse(null);

        M_Locacao m_locacao = new M_Locacao();
        m_locacao.setCheckIn(LocalDateTime.parse(
                LocalDateTime.parse
        ));
        m_locacao.setCheckOut(LocalDateTime.parse(checkout));


        return null;
    }
}
