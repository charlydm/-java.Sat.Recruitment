package sat.recruitment.api.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sat.recruitment.api.enums.UserType;

@Getter
@Setter
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequestDto {
	@NotNull(message = "The name is required")
	public String name;
	@NotNull(message = "The email is required")
	public String email;
	@NotNull(message = "The address is required")
	public String address;
	@NotNull(message = "The phone is required")
	public String phone;
	public UserType userType;
	public Double money;
}
