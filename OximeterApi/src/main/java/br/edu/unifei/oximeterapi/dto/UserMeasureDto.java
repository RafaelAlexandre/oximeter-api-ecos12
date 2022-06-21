package br.edu.unifei.oximeterapi.dto;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserMeasureDto {
	
	@NotBlank
	private Integer bpm;
	
	@NotBlank
	private Integer spo2;

	@NotBlank
	private Long oximeterId;

}
