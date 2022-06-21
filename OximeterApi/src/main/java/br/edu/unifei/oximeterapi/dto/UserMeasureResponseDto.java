package br.edu.unifei.oximeterapi.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserMeasureResponseDto {
	
	@NotBlank
	private Integer bpm;
	
	@NotBlank
	private Integer spo2;
	
}
