package com.example.futergoal.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoUser {

	private String userName;

	private String title;
	private String city;
	private String signature;

	private Integer points;
	private Integer level;
	private String roleName;
	private List<DtoTitle> titles = new ArrayList<>();
}
