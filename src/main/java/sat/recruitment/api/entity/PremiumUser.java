package sat.recruitment.api.entity;

import sat.recruitment.api.enums.UserType;

public class PremiumUser extends User {

	public PremiumUser(String name, String email, String address, String phone, UserType userType, Double money) {
		super();
		setName(name);
		setEmail(email);
		setAddress(address);
		setPhone(phone);
		setUserType(userType);
		setMoney(money);
	}
	
	public void calculateMoney() {
		if (money > 100){
			Double gif = Double.valueOf(money) * 2;
			money += gif;
        }
	}

}
