package sat.recruitment.api.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import sat.recruitment.api.dto.UserRequestDto;
import sat.recruitment.api.dto.UserResponseDto;
import sat.recruitment.api.entity.User;
import sat.recruitment.api.mapper.IUserMapper;
import sat.recruitment.api.repository.UserRepository;

@Service
public class UserService {
	
	private final IUserMapper mapper;
	
	@Autowired
	private UserRepository repository;
	
	UserService(IUserMapper mapper){
		this.mapper = mapper;
	}
	
	public UserResponseDto createUser(UserRequestDto userRequestDto) {
		User user = mapper.toDomain(userRequestDto);
		isDuplicated(user);
		
		User usertype = user.getType();
		usertype.calculateMoney();
		
		User userResponse = repository.save(usertype);
		
		return mapper.toDomain(userResponse);
	}
	
	public void isDuplicated(User user) {
		List<User> allUsers = repository.findAllUser();
		Optional<User> isDuplicated = allUsers.stream()
				.filter(u -> (u.getEmail().equals(user.getEmail()) || u.getPhone().equals(user.getPhone()))
						|| (u.getName().equals(user.getName()) && u.getAddress().equals(user.getAddress())))
				.findFirst();
		if (isDuplicated.isPresent())
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User is duplicated");
	}
}
