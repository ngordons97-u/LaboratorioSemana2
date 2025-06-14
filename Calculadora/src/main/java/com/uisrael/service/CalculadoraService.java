package com.uisrael.service;

import java.util.List;

import com.uisrael.entity.Calculadora;

public interface CalculadoraService {
	List<Calculadora> obtenerInversion();
	Calculadora obtenerPorId(Integer id);
	Calculadora crearInversion(Calculadora calculadora);
	//Calculadora actualizarInversion(Integer id, Calculadora cliente);
	//void eliminarInversion(Integer id);
	Long contarClientes();
	
	double obtenerTasa(int n);

    String categorizarCliente(double capital, int n);

    double calcularMontoFinal(double capitalInicial, double tasa, int numeroPeriodos, int tiempo);
	
}
