package com.example.futergoal.controller.abstracts;

import com.example.futergoal.dto.DtoTitle;

public interface TitleController {

	public DtoTitle saveTitle(DtoTitle dtoTitle);
	public void deleteTitle(Long id);
}
