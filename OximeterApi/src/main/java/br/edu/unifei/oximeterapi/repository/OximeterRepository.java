package br.edu.unifei.oximeterapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.unifei.oximeterapi.model.Oximeter;

@Repository
public interface OximeterRepository extends JpaRepository<Oximeter, Long>{
	
	Oximeter findBySerialNumber(Long serialNumber);
	
}
