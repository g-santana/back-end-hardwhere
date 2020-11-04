package br.com.hardwhere.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.hardwhere.entity.Peca;

@Repository
public interface PecaRepository extends JpaRepository<Peca, Integer> {

	/*@Query(value = ""
			, nativeQuery = true)
	List<Peca> searchPecas(@Param("termos") List<String> termos);
	*/
}
