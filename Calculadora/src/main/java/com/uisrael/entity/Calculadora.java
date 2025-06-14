package com.uisrael.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="tbl_inversion")
@AllArgsConstructor
@NoArgsConstructor

public class Calculadora {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Nonnull
	private String nombres;
	@Nonnull
	private String cedula;
	@Nonnull
	private String email;
	@Nonnull
	private String celular;
	@Nonnull
	private double capital;
	@Nonnull
	private int periodo;
	@Nonnull
	private int tiempo;
	@Nonnull
	private double tasa;
	@Nonnull
	private double monto;
	@Nonnull
	private double interes;
	@Nonnull
	private String categoria;
	
}
