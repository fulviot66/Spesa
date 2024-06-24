package com.ft.Spesa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import com.ft.Spesa.model.Spesa;
import com.ft.Spesa.repository.SpesaRepository;

@Service ("spesaService")
public class SpesaServiceImpl implements SpesaService {
	
	@Autowired
	private SpesaRepository spesaRepository;
	
	@Override
	public void saveSpesa(Spesa s) {
		spesaRepository.save(s);
	}
	
	
	// Estrae e ordina alfabeticamente per Articolo
	@Override
	public List <Spesa> getAllOrdered() {
		return spesaRepository.findAll(Sort.by(Order.by("articolo")));

	}
	
	@Override
	public Optional <Spesa> findById(Integer spesaId) {
		return spesaRepository.findById(spesaId);
		
	}
		
	@Override
	public List <Spesa> getAll() {
		return spesaRepository.findAll();
		
	}

}
