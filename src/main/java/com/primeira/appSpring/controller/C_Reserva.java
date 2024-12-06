package com.primeira.appSpring.controller;

import com.primeira.appSpring.service.S_Reserva;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class C_Reserva {

    @Autowired
    public C_Reserva(S_Reserva r_reserva) {
        this.s_reserva = s_reserva;
    }
    @PostMapping("/reservar")
    @ResponseBody
    public boolean reservar(@RequestParam("checkin") String checkin,
                           @RequestParam("checkout") String checkout,
                           @RequestParam("quarto") long quarto,
                           HttpSession session){
        return false;
    }
}
