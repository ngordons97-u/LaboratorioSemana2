package com.uisrael.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
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
	@NotBlank(message = "* El campo nombre no puede estar vacío.")
	@Pattern(regexp = "^[a-zA-ZáéíóúÁÉÍÓÚñÑüÜ\\s]+$", message = "* El campo nombre solo puede contener letras y espacios.")
	private String nombres;
	@NotBlank(message = "* La cédula no puede estar vacía.")
    @Pattern(regexp = "^[0-9]{10}$", message = "* La campo cédula debe contener exactamente 10 dígitos numéricos.")
	private String cedula;
	@NotBlank(message = "* El campoe mail no puede estar vacío.")
    @Email(message = "* Por favor, ingresa un formato de correo electrónico válido.")
	private String email;
	@NotBlank(message = "* El campo celular no puede estar vacío.")
    @Pattern(regexp = "^[0-9]{10}$", message = "* El campo celular debe contener exactamente 10 dígitos numéricos.")
	private String celular;
	@Min(value = 100, message = "* El campo capital inicial debe ser igual o mayor a 100 USD.")
	private double capital;
	@Nonnull
	private int periodo;
	@Min(value = 1, message = "* El campo tiempo debe ser igual o mayor a 1 año.")
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