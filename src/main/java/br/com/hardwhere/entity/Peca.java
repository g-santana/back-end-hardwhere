package br.com.hardwhere.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "peca")
public class Peca {
	
	@Id
	@Column
	@GeneratedValue
	private Integer id;
	
	@Column
	private String tipo; 
	
	@Column
	private String modelo;
	
	@Column
	private String marca;
	
	@Column
	private String fabricante;
}
