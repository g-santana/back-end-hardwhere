package br.com.hardwhere.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@Column
	@GeneratedValue
	private Integer id;
	
	@Column
	private String email; 
	
	@Column
	@JsonIgnore
	private String senha;
	
	@Column
	private String nome;
	
	@JsonIgnore
	@Column(name = "is_admin")
	private Integer isAdmin;
}
