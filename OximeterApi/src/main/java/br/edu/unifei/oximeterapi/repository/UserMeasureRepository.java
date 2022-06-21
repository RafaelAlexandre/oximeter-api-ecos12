package br.edu.unifei.oximeterapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unifei.oximeterapi.model.UserMeasure;

@Repository
public interface UserMeasureRepository extends JpaRepository<UserMeasure, Long> {

	List<UserMeasure> findFirst10ByOximeterOximeterIdOrderByMeasureDateDesc(Long oximeterId);
	
}
