package sat.recruitment.api.entity;

import sat.recruitment.api.enums.UserType;

public class NormalUser extends User{

	public NormalUser(String name, String email, String address, String phone, UserType userType, Double money) {
		super();
		setName(name);
		setEmail(email);
		setAddress(address);
		setPhone(phone);
		setUserType(userType);
		setMoney(money);
	}
	
	public void calculateMoney() {
		if (money > 100 || (money < 100 && money > 10)){
			Double percentage = ((money < 100 && money > 10)) ? Double.valueOf(0.8) : Double.valueOf(0.12);
			Double gif = money * percentage;
			money += gif;
        }
	}
}
