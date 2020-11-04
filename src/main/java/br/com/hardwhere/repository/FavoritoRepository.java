package br.com.hardwhere.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.hardwhere.entity.Favorito;

@Repository
public interface FavoritoRepository extends JpaRepository<Favorito, Integer> {

	@Query(value = "SELECT f.id AS id, "
			+ "	f.idUsuario AS usuario, "
			+ "	f.idPeca AS peca, "
			+ "	p.tipo, "
			+ "	p.modelo, "
			+ "	p.marca, "
			+ "	p.fabricante "
			+ "FROM favorito AS f "
			+ "LEFT JOIN peca AS p "
			+ "ON f.idPeca = p.id "
			+ "WHERE f.idUsuario = :idUsuario"
			, nativeQuery = true)
	List<Favorito> findFavoritos(@Param("idUsuario") Integer idUsuario);
	
}
