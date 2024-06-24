package com.ft.Spesa.service;

import java.util.List;
import java.util.Optional;

import com.ft.Spesa.model.Spesa;

public interface SpesaService {
	
	public void saveSpesa(Spesa s);
	public List <Spesa> getAllOrdered();
	public Optional <Spesa> findById(Integer spesaId);
	public List <Spesa> getAll();

}
