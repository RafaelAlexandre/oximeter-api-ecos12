package br.edu.unifei.oximeterapi.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import br.edu.unifei.oximeterapi.dto.UserMeasureDto;
import br.edu.unifei.oximeterapi.model.Oximeter;
import br.edu.unifei.oximeterapi.model.UserMeasure;

@Component
public class UserMeasureMapper {
	
	public UserMeasure userMeasureDtoToUserMeasure(UserMeasureDto userMeasureDto) {
		var userMeasure = new UserMeasure();
		var oximeter = new Oximeter();
		
		oximeter.setOximeterId(1L);
		userMeasure.setBpm(userMeasureDto.getBpm());
		userMeasure.setSpo2(userMeasureDto.getSpo2());
		userMeasure.setOximeter(oximeter);
		LocalDateTime rightNow = LocalDateTime.now();
		userMeasure.setMeasureDate(rightNow);
		return userMeasure;
	}
}
