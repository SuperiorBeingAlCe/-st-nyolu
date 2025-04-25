package com.example.futergoal.controller.abstracts;

import java.util.List;

import com.example.futergoal.dto.DtoUser;
import com.example.futergoal.dto.DtoUserIU;


public interface UserController {
	
	public DtoUser saveUser(DtoUserIU dtoUserIU);

	
public List<DtoUser> getAllUsers();
	
	public DtoUser getUserById(Long id);
	
	public void deleteUser(Long id);
	
	public DtoUser updateUser(Long id, DtoUserIU dtoUserIU);	
	
	public DtoUser updateUserRole(Long id, DtoUserIU dtoUserIU);
	public DtoUser getAllUserTitle(Long id);
}
