package br.com.hardwhere.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "promocao")
public class Promocao {

	@Id
	@Column
	@GeneratedValue
	private Integer id;
	
	@Column
	private double porcentagemDesconto;
	
	@Column
	private String dataInicio;
	
	@Column
	private String dataFim;
	
	@JoinColumn(name = "idProduto")
	@OneToOne(fetch = FetchType.LAZY)
	private Produto produto;
}
