package br.com.hardwhere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.hardwhere.entity.Loja;

@Repository
public interface LojaRepository extends JpaRepository<Loja, Integer> {

}
