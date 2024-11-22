package com.primeira.appSpring.repository;

import com.primeira.appSpring.model.M_Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface R_Quarto extends JpaRepository<M_Quarto, Long> {
    @Query(value = "select quarto.* " +
            "from quarto " +
            "left outer join locacao " +
            "on quarto.id = locacao.id_quarto " +
            "and (cast(:checkin as timestamp) between locacao.check_in and locacao.check_out " +
            "or cast(:checkout as timestamp) between locacao.check_in and locacao.check_out " +
            "or locacao.check_in between cast(:checkin as timestamp) and cast(:checkout as timestamp)) " +
            "where locacao.id is null", nativeQuery = true)
    List<M_Quarto> getQuartosDisponiveisPeriodo(@Param("checkin") String checkIn,
                                               @Param("checkout") String checkOut);
}
