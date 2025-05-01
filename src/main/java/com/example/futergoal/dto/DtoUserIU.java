package com.example.futergoal.dto;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoUserIU {

	@NotBlank(message = "kullanıcı adı boş bırakılamaz")
	@Size(min = 5, max = 20)
	@NotNull
	private String userName;

	
	@NotNull
	@Size(min = 5, max = 10)
	private String firstName;

	
	@NotNull
	@Size(min = 5, max = 10)
	private String lastName;

	@NotNull
	private Long titleId;

	@NotNull
	private Long cityId;

	@NotBlank
	@NotNull
	@Email
	private String email;

	@NotBlank
	@NotNull
	@Size(min = 8, message = "Şifre en az 8 karakter olmalıdır")
	private String password;

	
	
	@Size(min = 5, max = 50)
	private String signature;

	
	@Size(min = 5, max = 300)
	private String detail;

	@NotNull
	@NotBlank
	private Integer points;

	@NotNull
	@NotBlank
	private Integer maxPoints;

	@NotNull
	@NotBlank
	private Integer level;

	@NotNull
	@NotBlank
	private String roleName;
	
	private List<DtoTitle> titles = new ArrayList<>();
	
}

