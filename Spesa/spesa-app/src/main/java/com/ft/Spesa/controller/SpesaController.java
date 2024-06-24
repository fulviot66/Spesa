package com.ft.Spesa.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ft.Spesa.model.Spesa;
import com.ft.Spesa.service.SpesaService;

@Controller
public class SpesaController {

	@Autowired
	private SpesaService spesaService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		List <Spesa> listaSpesa = spesaService.getAllOrdered();
		mav.addObject("listaSpesa", listaSpesa);
		mav.addObject("spesa", new Spesa());
		return mav;
	}
	
	@RequestMapping (value = "/", method = RequestMethod.POST)
	public ModelAndView add(Spesa spesa, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();
		spesaService.saveSpesa(spesa);
		mav.setViewName("home");
		List <Spesa> listaSpesa = spesaService.getAllOrdered();
		mav.addObject("listaSpesa", listaSpesa);
		mav.addObject("spesa", new Spesa());
		return mav;
	}
	
	@RequestMapping (value = "/edit/{spesaId}", method = RequestMethod.GET)
	public ModelAndView update(@PathVariable Integer spesaId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("spesa", spesaService.findById(spesaId));
		mav.setViewName("edit_spesa");
		return mav;
	}
	
	@RequestMapping (value = "/edit", method = RequestMethod.POST)
	public ModelAndView do_update(Spesa s, BindingResult bindingResult) {
		spesaService.saveSpesa(s);
		return new ModelAndView("redirect:/");
	}
	
	// Riepilogo Spesa da fare
	@RequestMapping (value = "/summary", method = RequestMethod.GET)
	public ModelAndView summary() throws IndexOutOfBoundsException{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("summary");
		List <Spesa> listaSpesa  = spesaService.getAll();
		
		// Nuova lista da popolare
		List <Spesa> spesaDaFare = new ArrayList <Spesa> ();
		// Scorro la listaSpesa per ridurla a solo gli articoli da comprare
		Integer size = listaSpesa.size();
			for (int i=0; i<size;) {
				//Intercetta spunta=FALSE
				//Integer id = listaSpesa.get(i).getId();
				//String articolo = listaSpesa.get(i).getArticolo();
				Boolean spunta = listaSpesa.get(i).getSpunta();
				
				if (spunta == false) {
					//System.out.println("i:"+ i +" id:" + id + " articolo:" + articolo + " spunta:" + spunta);
					spesaDaFare.add(listaSpesa.get(i));
				}	
				
				// Salta all'articolo successivo
				i++;				
			}
		mav.addObject("spesaDaFare", spesaDaFare);
		return mav;
	}
}

