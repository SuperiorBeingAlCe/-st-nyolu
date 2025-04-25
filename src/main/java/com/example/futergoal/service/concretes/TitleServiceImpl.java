package com.example.futergoal.service.concretes;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.futergoal.dto.DtoTitle;
import com.example.futergoal.entities.Title;
import com.example.futergoal.repository.TitleRepository;
import com.example.futergoal.service.abstracts.TitleService;

@Service 
public class TitleServiceImpl implements TitleService{

	@Autowired
	private TitleRepository titleRepository;
	
	@Override
	public DtoTitle saveTitle(DtoTitle dtoTitle) {
		DtoTitle response = new DtoTitle();
		Title title = new Title();
		
		BeanUtils.copyProperties(dtoTitle, title);
		Title dto = titleRepository.save(title);
		
		BeanUtils.copyProperties(dto, response);
		return response;
	}

	@Override
	public void deleteTitle(Long id) {
		Optional<Title> optional = titleRepository.findById(id);
		if(optional.isPresent()) {
			titleRepository.delete(optional.get());
		}
	}

}
