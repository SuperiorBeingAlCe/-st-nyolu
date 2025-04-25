package com.example.futergoal.service.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.futergoal.dto.DtoTitle;
import com.example.futergoal.dto.DtoUser;
import com.example.futergoal.dto.DtoUserIU;
import com.example.futergoal.entities.City;
import com.example.futergoal.entities.Role;
import com.example.futergoal.entities.Title;
import com.example.futergoal.entities.User;
import com.example.futergoal.exception.BaseException;
import com.example.futergoal.exception.ErrorMessage;
import com.example.futergoal.exception.MessageType;
import com.example.futergoal.repository.CityRepository;
import com.example.futergoal.repository.RoleRepository;
import com.example.futergoal.repository.TitleRepository;
import com.example.futergoal.repository.UserRepository;
import com.example.futergoal.service.abstracts.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final TitleRepository titleRepository;
    private final CityRepository cityRepository;
    private final RoleRepository roleRepository;
	
	@Autowired
    public UserServiceImpl(PasswordEncoder passwordEncoder, 
                           UserRepository userRepository,
                           TitleRepository titleRepository, 
                           CityRepository cityRepository, 
                           RoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.titleRepository = titleRepository;
        this.cityRepository = cityRepository;
        this.roleRepository = roleRepository;
    }


	@Override
	public DtoUser saveUser(DtoUserIU dtoUserIU) {
		DtoUser response = new DtoUser();
		User user = new User();

		Optional<City> city = cityRepository.findById(dtoUserIU.getCityId());

		Optional<Title> title = titleRepository.findById(dtoUserIU.getTitleId());

		if (city.isPresent() ) {
			user.setCity(city.get());
		
		} else {
			throw new BaseException(new ErrorMessage(MessageType.NO_CITY_EXIST, null));
		}
		 Title defaultTitle = titleRepository.findByName("beginner")
		            .orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_TITLE_EXIST, null)));
		    user.setTitle(defaultTitle);
		
		Role defaultRole = roleRepository.findByName("USER")
				.orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_ROLE_EXIST, null)));
		user.setRole(defaultRole);
		
		 user.setPassword(passwordEncoder.encode(dtoUserIU.getPassword()));

		BeanUtils.copyProperties(dtoUserIU, user);

		User dtoUser = userRepository.save(user);

		BeanUtils.copyProperties(dtoUser, response);
		return response;

	}

	@Override
	public List<DtoUser> getAllUsers() {
		List<DtoUser> dtoList = new ArrayList<>();

		List<User> userList = userRepository.findAll();

		for (User user : userList) {
			DtoUser dto = new DtoUser();
			BeanUtils.copyProperties(user, dto);
			dtoList.add(dto);
		}

		return dtoList;
	}

	@Override
	public DtoUser getUserById(Long id) {
		DtoUser dto = new DtoUser();
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			User dbUser = optional.get();

			BeanUtils.copyProperties(dbUser, dto);
		}
		return dto;
	}

	@Override
	public void deleteUser(Long id) {
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {

			userRepository.delete(optional.get());
		}
		throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
	}

	@Override
	public DtoUser updateUser(Long id, DtoUserIU dtoUserIU) {
		DtoUser dto = new DtoUser();
		Optional<User> optional = userRepository.findById(id);
		if (optional.isPresent()) {
			User dbUser = optional.get();

			Optional<City> city = cityRepository.findById(dtoUserIU.getCityId());
			Optional<Title> title = titleRepository.findById(dtoUserIU.getTitleId());

			if (city.isPresent() ) {
				dbUser.setCity(city.get());
			
			} else {
				throw new BaseException(new ErrorMessage(MessageType.NO_CITY_EXIST, null));
			}
			if(title.isPresent()) {
				dbUser.setTitle(title.get());
			}else {
				throw new BaseException(new ErrorMessage(MessageType.NO_TITLE_EXIST, null));
			}

			if (dtoUserIU.getUserName() != null) {
				dbUser.setUserName(dtoUserIU.getUserName());
			}

			if (dtoUserIU.getFirstName() != null) {
				dbUser.setFirstName(dtoUserIU.getFirstName());
			}

			if (dtoUserIU.getLastName() != null) {
				dbUser.setLastName(dtoUserIU.getLastName());
			}

			if (dtoUserIU.getSignature() != null) {
				dbUser.setSignature(dtoUserIU.getSignature());
			}

			if (dtoUserIU.getDetail() != null) {
				dbUser.setDetail(dtoUserIU.getDetail());
			}

			if (dtoUserIU.getPoints() != null) {
				dbUser.setPoints(dtoUserIU.getPoints());
			}

			if (dtoUserIU.getLevel() != null) {
				dbUser.setLevel(dtoUserIU.getLevel());
			}
			
			if (dtoUserIU.getPassword() != null) {
	            dbUser.setPassword(passwordEncoder.encode(dtoUserIU.getPassword()));
	        }

			User updatedStudent = userRepository.save(dbUser);
			BeanUtils.copyProperties(updatedStudent, dto);
			return dto;
		}
		throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
	}

	@Override
	public DtoUser updateUserRole(Long id, DtoUserIU dtoUserIU) {
		User user = userRepository.findById(id).orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString())));

		Role newRole = roleRepository.findByName(dtoUserIU.getRoleName())
				.orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_ROLE_EXIST, null)));

		user.setRole(newRole);

		User updatedUser = userRepository.save(user);

		DtoUser dtoUser = new DtoUser();
		BeanUtils.copyProperties(updatedUser, dtoUser);
		return dtoUser;
	}

	@Override
	public DtoUser updateUserLevel(Long id) {
		User user = userRepository.findById(id).orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString())));

		user.setLevel(user.getLevel() + 1);
		User updatedUser = userRepository.save(user);
		DtoUser dtoUser = new DtoUser();
		BeanUtils.copyProperties(updatedUser, dtoUser);
		return dtoUser;
	}

	@Override
	public DtoUser updateUserPoints(Long id, Integer newPoints) {
		User user = userRepository.findById(id).orElseThrow(() -> new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString())));

		if (newPoints >= user.getMaxPoint()) {
			user.setPoints(0);
			user.setMaxPoint(user.getMaxPoint() + 25);

			updateUserLevel(id);
		}
		user.setPoints(user.getPoints() + newPoints);

		User updatedUser = userRepository.save(user);

		DtoUser dtoUser = new DtoUser();
		BeanUtils.copyProperties(updatedUser, dtoUser);

		return dtoUser;
	}

	@Override
	public DtoUser getAllUserTitle(Long id) {
		DtoUser dtoUser = new DtoUser();
		Optional<User> optional = userRepository.findById(id);
		
		if (optional.isEmpty()) {
			throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString())); 
		}
		User dbUser = optional.get();
		
		
		
		List<Title> dbTitles = optional.get().getTitles();
		
		BeanUtils.copyProperties(dbUser, dtoUser);
		
		if(dbTitles !=null && !dbTitles.isEmpty() ) {
			for (Title title : dbTitles) {
				DtoTitle dtoTitle = new DtoTitle();
				
				BeanUtils.copyProperties(title, dtoTitle);
				
				dtoUser.getTitles().add(dtoTitle);
			}
			
		}
		
		
		return dtoUser;
	}
}
