package com.uisrael.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uisrael.entity.Calculadora;
import com.uisrael.repository.CalculadoraRepository;
import com.uisrael.service.CalculadoraService;

@Service
public class CalculadoraServiceImpl implements CalculadoraService {

	@Autowired
	private CalculadoraRepository calculadoraRepository;
	
	@Override
	public List<Calculadora> obtenerInversion() {
		// TODO Auto-generated method stub
		
		return calculadoraRepository.findAll();
		
	}

	@Override
	public Calculadora obtenerPorId(Integer id) {
		// TODO Auto-generated method stub
		return calculadoraRepository.findById(id).orElse(null);
		
	}

	@Override
	public Calculadora crearInversion(Calculadora calculadora) {
		// TODO Auto-generated method stub
		return calculadoraRepository.save(calculadora);
		
	}

	@Override
	public Long contarClientes() {
		// TODO Auto-generated method stub
		return calculadoraRepository.count();
	
	}

	@Override
	public double obtenerTasa(int n) {
		// TODO Auto-generated method stub
		return switch (n) {
        case 2 -> 0.05;  // Semestral
        case 4 -> 0.07;  // Trimestral
        case 12 -> 0.11; // Mensual
        default -> 0.0;
    };
	}

	@Override
	public String categorizarCliente(double capital, int n) {
		// TODO Auto-generated method stub
		if (n == 12 || n==4 || n==2 ) {
			if (capital >= 100 && capital <= 500) {
                return "Categoría 3";
            } else if (capital >= 501 && capital <= 1000) {
                return "Categoría 2";
            } else if (capital > 1000) {
                return "Categoría 1";
            }
        }
        return "Sin categoría";
	}

	@Override
	public double calcularMontoFinal(double capitalInicial, double tasa, int numeroPeriodos, int tiempo) {
		// TODO Auto-generated method stub
        return capitalInicial * Math.pow(1 + tasa / numeroPeriodos, numeroPeriodos * tiempo);

	}
	

	
}
