package br.edu.unifei.oximeterapi.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.unifei.oximeterapi.model.UserMeasure;
import br.edu.unifei.oximeterapi.repository.UserMeasureRepository;

@Service
public class UserMeasureService {

	@Autowired
	UserMeasureRepository userMeasureRepository;
	
	@Transactional
	public UserMeasure save(UserMeasure userMeasure) {
		return userMeasureRepository.save(userMeasure);
	}
	
	public List<UserMeasure> getByOximeterId(Long oximeterId) {
		return userMeasureRepository.findFirst10ByOximeterOximeterIdOrderByMeasureDateDesc(oximeterId);
	}
	
}
