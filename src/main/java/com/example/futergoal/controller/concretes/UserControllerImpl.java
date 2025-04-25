package com.example.futergoal.controller.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.futergoal.controller.abstracts.UserController;
import com.example.futergoal.dto.DtoUser;
import com.example.futergoal.dto.DtoUserIU;
import com.example.futergoal.service.abstracts.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rest/api/user")
public class UserControllerImpl implements UserController {

	@Autowired
	private UserService userService;

	@PostMapping(path = "/save")
	@Override
	public DtoUser saveUser(@RequestBody @Valid DtoUserIU dtoUserIU) {

		return userService.saveUser(dtoUserIU);
	}

	@GetMapping(path = "/list")
	@Override
	public List<DtoUser> getAllUsers() {

		return userService.getAllUsers();
	}

	@GetMapping(path = "/list/{id}")
	@Override
	public DtoUser getUserById(@PathVariable(name = "id") Long id) {

		return userService.getUserById(id);
	}

	@DeleteMapping(path = "/delete/{id}")
	@Override
	public void deleteUser(@PathVariable(name = "id") Long id) {
		userService.deleteUser(id);
	}

	@PutMapping(path = "/update/{id}")
	@Override
	public DtoUser updateUser(@PathVariable(name = "id") Long id, @RequestBody DtoUserIU dtoUserIU) {

		return userService.updateUser(id, dtoUserIU);
	}

	@PutMapping("/updateRole/{id}")
	@Override
	public DtoUser updateUserRole(@PathVariable(name = "id") Long id, @RequestBody DtoUserIU dtoUserIU) {

		return userService.updateUserRole(id, dtoUserIU);
	}

	
	@GetMapping(path = "/{id}")
	@Override
	public DtoUser getAllUserTitle(@PathVariable(name = "id") Long id) {
		
		
		
		return userService.getAllUserTitle(id);
	}

}
