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
import com.uisrael.repository.CalculadoraRepository;
import com.uisrael.service.CalculadoraService;

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
	
	/*
	@GetMapping
	public String listarInversiones(Model model) {
		
		List<Calculadora> calculadora = calculadoraService.obtenerInversion();
		model.addAttribute("simulacion", new Calculadora());
		//model.addAttribute("listarInversiones",calculadora);
		return "listar";
		
	}
	*/
	/*
	@PostMapping("/nueva")
	public String guardarNuevaInversion(@ModelAttribute Calculadora calculadora) {
	calculadoraService.crearInversion(calculadora);
	return "redirect:/inversiones";
		
	}
	*/
	
	@GetMapping("/nueva")
	public String mostrarFormularioNuevaInversion(Model model) {
		
		model.addAttribute("calculadora", new Calculadora());
		//model.addAttribute("accion","/calculadora/nueva");
		return "formulario";
	}
	 @PostMapping("/nueva")
	    public String procesarFormulario(@ModelAttribute Calculadora calculadora, Model model) {

	        if (calculadora.getCapital() < 100) {
	            model.addAttribute("error", "El capital inicial debe ser mayor a 100 USD.");
	            return "formulario";
	        }

	        // Obtener tasa de interés según número de periodos
	        double tasa = calculadoraService.obtenerTasa(calculadora.getPeriodo());
	        calculadora.setTasa(tasa);

	        // Calcular monto final
	        double monto = calculadoraService.calcularMontoFinal(
	        		calculadora.getCapital(),
	                tasa,
	                calculadora.getPeriodo(),
	                calculadora.getTiempo()
	        );
	        calculadora.setMonto(monto);
	        calculadora.setInteres(monto - calculadora.getCapital());

	        // Categorizar cliente
	        calculadora.setCategoria(calculadoraService.categorizarCliente(
	        		calculadora.getCapital(),
	        		calculadora.getPeriodo()
	        ));
	        System.out.println("Guardando inversión: " + calculadora.getNombres() + ", monto: " + calculadora.getMonto());
	        // Guardar en base de datos
	        repo.save(calculadora);

	        return "redirect:/calculadora/resultados";
	    }
	
	
	
}
