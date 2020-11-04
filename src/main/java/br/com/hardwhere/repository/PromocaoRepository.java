package br.com.hardwhere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hardwhere.entity.Promocao;

@Repository
public interface PromocaoRepository extends JpaRepository<Promocao, Integer> {

}
