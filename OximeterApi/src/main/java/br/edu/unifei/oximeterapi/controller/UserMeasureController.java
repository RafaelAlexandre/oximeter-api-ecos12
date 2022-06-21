package br.edu.unifei.oximeterapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.unifei.oximeterapi.dto.UserMeasureDto;
import br.edu.unifei.oximeterapi.dto.UserMeasureResponseDto;
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
	public ResponseEntity<UserMeasure> postMeasure(@RequestBody UserMeasureDto userMeasureDto) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(userMeasureService.save(userMeasureMapper.userMeasureDtoToUserMeasure(userMeasureDto)));
	}

	@GetMapping("/getLastTen/{oximeterId}")
	public ResponseEntity<List<UserMeasureResponseDto>> getLastTenMeasure(@PathVariable Long oximeterId) {
		return ResponseEntity.status(HttpStatus.OK).body(userMeasureMapper
				.userMeasureListToUserMeasureResponseDto(userMeasureService.getByOximeterId(oximeterId)));
	}
}
