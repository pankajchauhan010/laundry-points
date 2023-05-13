package com.necture.laundryPoints.dto;

import java.util.UUID;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClothDto {
	
	private UUID id;

	@NotBlank(message = "Cloth name is mandatory")
	@Size(min = 3)
	private String clothName;

	@Min(value = 0)
	private Double price;
	
}
