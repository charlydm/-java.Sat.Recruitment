package sat.recruitment.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sat.recruitment.api.enums.UserType;

@Getter
@Setter
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserResponseDto {
	public String name;
	public String email;
	public String address;
	public String phone;
	public UserType userType;
	public Double money;
}
