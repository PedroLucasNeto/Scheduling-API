package br.com.AlanaRetratosAgendamentos.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity(name = "tb_user")
public class User {

	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

}
