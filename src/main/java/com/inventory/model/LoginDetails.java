package com.inventory.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class LoginDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long loginId;
	private String name;
	private String userName;
	private String password;
	private Integer isEnabled;
	private LocalDateTime updatedDate;
	private String role;
}