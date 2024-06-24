package com.ft.Spesa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ft.Spesa.model.Spesa;

@Repository ("spesaRepository")
public interface SpesaRepository extends JpaRepository<Spesa, Integer>{

}
