package com.example.futergoal.controller.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.futergoal.controller.abstracts.TitleController;
import com.example.futergoal.dto.DtoTitle;
import com.example.futergoal.service.abstracts.TitleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/title")
public class TitleControllerImpl implements TitleController{
	@Autowired
	private TitleService titleService;

	@PostMapping(path = "/save")
	@Override
	public DtoTitle saveTitle(@RequestBody @Valid DtoTitle dtoTitle) {
		
		return titleService.saveTitle(dtoTitle);
	}

	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteTitle(@PathVariable(name = "id") Long id) {
		titleService.deleteTitle(id);
		
	}

}
