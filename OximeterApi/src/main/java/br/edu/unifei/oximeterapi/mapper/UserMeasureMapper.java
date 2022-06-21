package br.edu.unifei.oximeterapi.mapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.edu.unifei.oximeterapi.dto.UserMeasureDto;
import br.edu.unifei.oximeterapi.dto.UserMeasureResponseDto;
import br.edu.unifei.oximeterapi.model.Oximeter;
import br.edu.unifei.oximeterapi.model.UserMeasure;

@Component
public class UserMeasureMapper {
	
	public UserMeasure userMeasureDtoToUserMeasure(UserMeasureDto userMeasureDto) {
		var userMeasure = new UserMeasure();
		var oximeter = new Oximeter();
		
		oximeter.setOximeterId(userMeasureDto.getOximeterId());
		userMeasure.setBpm(userMeasureDto.getBpm());
		userMeasure.setSpo2(userMeasureDto.getSpo2());
		userMeasure.setOximeter(oximeter);
		LocalDateTime rightNow = LocalDateTime.now();
		userMeasure.setMeasureDate(rightNow);
		return userMeasure;
	}
	
	public List<UserMeasureResponseDto> userMeasureListToUserMeasureResponseDto(List<UserMeasure> userMeasureList) {
		List<UserMeasureResponseDto> userMeasureResponseDtoList = new ArrayList<>();
		
		for (UserMeasure userMeasure : userMeasureList) {
			var userResponseDto = new UserMeasureResponseDto();
			userResponseDto.setBpm(userMeasure.getBpm());
			userResponseDto.setSpo2(userMeasure.getSpo2());
			userMeasureResponseDtoList.add(userResponseDto);
		}
		return userMeasureResponseDtoList;
	}
}
