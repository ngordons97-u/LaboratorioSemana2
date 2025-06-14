package com.uisrael.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.uisrael.entity.Calculadora;
import com.uisrael.service.CalculadoraService;

@Controller
@RequestMapping("/inversion")
public class CalculadoraController {

	@Autowired
	private CalculadoraService calculadoraService;
	
	@GetMapping
	public String listarInversiones(Model model) {
		
		List<Calculadora> calculadora = calculadoraService.obtenerInversion();
		model.addAttribute("listarInversiones",calculadora);
		return "listar";
		
	}
	@PostMapping("/nueva")
	public String guardarNuevaInversion(@ModelAttribute Calculadora calculadora) {
	calculadoraService.crearInversion(calculadora);
	return "redirect:/inversiones";
		
	}
}
