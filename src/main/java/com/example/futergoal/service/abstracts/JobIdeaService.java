package com.example.futergoal.service.abstracts;

import java.util.List;

import com.example.futergoal.dto.DtoJobIdea;
import com.example.futergoal.dto.DtoJobIdeaIU;

public interface JobIdeaService {

	public DtoJobIdea saveJobIdea(DtoJobIdeaIU dtoJobIdeaIU);
	
	public List<DtoJobIdea> getAllJobIdea();
	
	public DtoJobIdea getJobIdeaBy(Long id);
	
	public void deleteJobIdea(Long id);
	
	public DtoJobIdea updateJobIdea(Long id, DtoJobIdeaIU dtoJobIdeaIU);
	
	
}
