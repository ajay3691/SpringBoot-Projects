package com.task.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.task.entity.Users;
import com.task.payload.UserDto;
import com.task.repository.UserRepository;
import com.task.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired 
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDto createUser(UserDto userDto) {
		// Convert UserDto to Users entity and save it
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
		Users user = userDtoToEntity(userDto);	

		// Return the saved user object as UserDto
		Users savedUser = userRepository.save(user); 
		return entityToUserDto(savedUser);  //Entity.users__Dto.user__savedUser

	}

	private Users userDtoToEntity(UserDto userDto) {
		Users users = new Users();
		users.setName(userDto.getName());
		users.setEmail(userDto.getEmail());
		users.setPassword(userDto.getPassword());
		return users;
	}

	private UserDto entityToUserDto(Users savedUsers) {
		UserDto userDto = new UserDto();
		userDto.setId(savedUsers.getId());
		userDto.setName(savedUsers.getName());
		userDto.setEmail(savedUsers.getEmail());
		userDto.setPassword(savedUsers.getPassword());
		return userDto;
	}
}
