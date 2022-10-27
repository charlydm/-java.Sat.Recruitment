package sat.recruitment.api.mapper;

import sat.recruitment.api.dto.UserRequestDto;
import sat.recruitment.api.dto.UserResponseDto;
import sat.recruitment.api.entity.User;

public interface IUserMapper {
	User toDomain(UserRequestDto userRequest);
	UserResponseDto toDomain(User userResponse);
}
