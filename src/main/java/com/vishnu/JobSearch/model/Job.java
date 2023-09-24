package com.vishnu.JobSearch.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Job {
	@Id
	private Long id;
	@NotBlank
	private String title;

	@NotBlank
	private String description;

	private String location;

	@Min(value = 20000)
	private Double salary;

	@Email
	private String companyEmail;

	private String companyName;

	private String employerName;

	@Enumerated(EnumType.STRING)
	private Type jobType;

	private LocalDate appliedDate;
}
