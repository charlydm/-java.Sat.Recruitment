package sat.recruitment.api.entity;

import sat.recruitment.api.enums.UserType;

public class SuperUser extends User {

	public SuperUser(String name, String email, String address, String phone, UserType userType, Double money) {
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
            var percentage = Double.valueOf(0.20);
            var gif = money * percentage;
            money += gif;
        }
	}

}
