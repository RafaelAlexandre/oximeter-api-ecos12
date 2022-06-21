package br.edu.unifei.oximeterapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unifei.oximeterapi.dto.UserMeasureDto;
import br.edu.unifei.oximeterapi.mapper.UserMeasureMapper;
import br.edu.unifei.oximeterapi.model.UserMeasure;
import br.edu.unifei.oximeterapi.service.UserMeasureService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/measures")
public class UserMeasureController {
	
	@Autowired
	UserMeasureService userMeasureService;
	
	@Autowired
	UserMeasureMapper userMeasureMapper;
	
	@PostMapping(path = "/saveMeasure")
	public ResponseEntity<Object> getLastTenMeasures(@RequestBody UserMeasureDto userMeasureDto) {
		UserMeasure userMeasure = userMeasureMapper.userMeasureDtoToUserMeasure(userMeasureDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(userMeasureService.save(userMeasure));
	}
	
}	
