package br.com.xyinc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.xyinc.model.Points;

public interface PointsRepository
		extends JpaRepository<Points, String> {
	
	List<Points> findByName(String name);
}
