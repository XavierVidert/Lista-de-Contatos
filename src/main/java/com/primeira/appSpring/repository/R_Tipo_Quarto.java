package com.primeira.appSpring.repository;

import com.primeira.appSpring.model.M_Tipo_Quarto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Tipo_Quarto extends JpaRepository<M_Tipo_Quarto,Long> {
}
