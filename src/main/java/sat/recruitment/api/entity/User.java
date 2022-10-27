package sat.recruitment.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sat.recruitment.api.enums.UserType;

@Getter
@Setter
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class User {
	public String name;
	public String email;
	public String address;
	public String phone;
	public UserType userType;
	public Double money;
	public void calculateMoney() {}
	
	public User getType(){
		User user = new User();
		switch (userType){
			case Normal :
				user = new NormalUser(name, email, address, phone, userType, money);
			break;
			case SuperUser :
				user = new SuperUser(name, email, address, phone, userType, money);
			break;
			case Premium :
				user = new PremiumUser(name, email, address, phone, userType, money);
			break;
			default: break;
		}
        return user;
    }

	@Override
	public String toString() {
		return name + "," + email + "," + address + "," + phone + "," + userType + "," + money;
	}
	
	
}
