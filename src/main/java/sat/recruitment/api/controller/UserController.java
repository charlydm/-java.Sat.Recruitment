package sat.recruitment.api.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sat.recruitment.api.dto.UserRequestDto;
import sat.recruitment.api.dto.UserResponseDto;
import sat.recruitment.api.service.UserService;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping("/create-user")
	public ResponseEntity<UserResponseDto> create(@RequestBody @Valid UserRequestDto userRequest){
		return new ResponseEntity<>(service.createUser(userRequest), HttpStatus.CREATED);
	}
}
