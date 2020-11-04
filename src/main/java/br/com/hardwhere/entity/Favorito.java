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
@Table(name = "favorito")
public class Favorito {
	
	@Id
	@Column
	@GeneratedValue
	private Integer id;
	
	@JoinColumn(name = "id_usuario")
	@ManyToOne(fetch = FetchType.LAZY)
	private Usuario usuario;
	
	@JoinColumn(name = "id_peca")
	@OneToOne(fetch = FetchType.LAZY)
	private Peca peca;
}
