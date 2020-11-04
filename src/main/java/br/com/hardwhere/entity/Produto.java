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
@Table(name = "produto")
public class Produto {

	@Id
	@Column
	@GeneratedValue
	private Integer id;
	
	@Column
	private double preco;
	
	@Column
	private String url;
	
	@JoinColumn(name = "idPeca")
	@OneToOne(fetch = FetchType.LAZY)
	private Peca peca;
	
	@JoinColumn(name = "idLoja")
	@OneToOne(fetch = FetchType.LAZY)
	private Loja loja;
}
