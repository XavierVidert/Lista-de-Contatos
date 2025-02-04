package com.primeira.appSpring.repository;

import com.primeira.appSpring.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface R_Contato extends JpaRepository<Contato, Long> {

}
