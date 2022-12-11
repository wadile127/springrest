package com.sprngtest.springrest.entities;



import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CourseEntity {
	@Id
	private Long id;
	private String title;
	private String description;
}
