package com.example.futergoal.service.abstracts;

import com.example.futergoal.dto.DtoTitle;

public interface TitleService {

	public DtoTitle saveTitle(DtoTitle dtoTitle);
	public void deleteTitle(Long id);
	
}
