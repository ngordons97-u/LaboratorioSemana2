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
		return null;
	}

	@Override
	public Calculadora obtenerPorId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Calculadora crearInversion(Calculadora calculadora) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long contarClientes() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
