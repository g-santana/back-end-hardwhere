package br.com.hardwhere.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "avaliacao")
public class Avaliacao {

	@Id
	@Column
	@GeneratedValue
	private Integer id;
	
	@Column
	private String texto;
	
	@Column
	private double nota;
	
	@JoinColumn(name = "idPeca")
	@OneToOne(fetch = FetchType.LAZY)
	private Peca peca;

	@JoinColumn(name = "idUsuario")
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;	
}
