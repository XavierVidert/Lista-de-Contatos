package com.primeira.appSpring.repository;

import com.primeira.appSpring.model.M_Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface R_Contato extends JpaRepository<M_Contato, Long> {

    @Query(value = "SELECT * FROM listadecontatos.contatos WHERE id_usuario = :id_usuario", nativeQuery = true)
    List<M_Contato> findByUsuarioId(@Param("id_usuario") Long idUsuario);
}
