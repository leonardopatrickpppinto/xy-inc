package br.com.xyinc.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.xyinc.model.Points;

public interface ReferencesRepository
		extends CrudRepository<Points, Long> {
	/* 
	 * Developer: Leonardo Patrick
	 * Reference: https://www.educamaisbrasil.com.br/enem/matematica/distancia-entre-dois-pontos
	 * 
	 * @param X value coordinate X
	 * @param Y value coordinate Y
	 * @param M value max distance
	 * @return: Distance between two points
	 * 
	 */
	
	
	@Query("SELECT c FROM "
			+ " Points c "
			+ " WHERE "
			+ " SQRT(POWER(c.x - :X ,2)  + POWER(c.y - :Y , 2)) < :M ")
	
	List<Points> findAllReferences(
				 @Param("X") long x
				,@Param("Y") long y
				,@Param("M") Double m);
}