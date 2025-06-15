package com.uisrael.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import com.uisrael.entity.Calculadora;
import com.uisrael.repository.CalculadoraRepository;
import com.uisrael.service.CalculadoraService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/calculadora")
public class CalculadoraController {

	@Autowired
	private CalculadoraService calculadoraService;
	@Autowired
	private CalculadoraRepository repo;
	
	
	 @GetMapping("/resultados")
	    public String verResultados(Model model) {
	        model.addAttribute("simulaciones", repo.findAll());
	        return "listar";
	    }
	
	@GetMapping("/nueva")
	public String mostrarFormularioNuevaInversion(Model model) {
		
		model.addAttribute("calculadora", new Calculadora());
		return "formulario";
	}
	 @PostMapping("/nueva")
	    public String procesarFormulario(@Valid @ModelAttribute Calculadora calculadora,BindingResult bindingResult, Model model) {
		 
		 if (bindingResult.hasErrors()) {
			 return "formulario";
		 }

	        double tasa = calculadoraService.obtenerTasa(calculadora.getPeriodo());
	        calculadora.setTasa(tasa);

	        double monto = calculadoraService.calcularMontoFinal(
	        		calculadora.getCapital(),
	                tasa,
	                calculadora.getPeriodo(),
	                calculadora.getTiempo()
	        );
	        calculadora.setMonto(monto);
	        calculadora.setInteres(monto - calculadora.getCapital());

	        calculadora.setCategoria(calculadoraService.categorizarCliente(
	        		calculadora.getCapital(),
	        		calculadora.getPeriodo()
	        ));
	        System.out.println("Guardando inversión: " + calculadora.getNombres() + ", monto: " + calculadora.getMonto());
	        repo.save(calculadora);

	        return "redirect:/calculadora/resultados";
	    }
	
}