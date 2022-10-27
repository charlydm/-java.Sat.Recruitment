package sat.recruitment.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import sat.recruitment.api.entity.User;
import sat.recruitment.api.enums.UserType;

public class UserServiceTest {
	
	@Test
	public void whenCallCalculeMoneyNormalUser() {
		User user = User.build("Carlos", 
				"charlydmoreno@gmail.com", 
				"Peru 2464",
				"+5491154762313", 
				UserType.Normal, 
				Double.valueOf(101));
		
		User usertype = user.getType();
		usertype.calculateMoney();
		
		assertEquals(usertype.getMoney(), Double.valueOf(113.12));
	}
	
	@Test
	public void whenCallCalculeMoneySuperUser() {
		User user = User.build("Carlos", 
				"charlydmoreno@gmail.com", 
				"Peru 2464",
				"+5491154762313", 
				UserType.SuperUser, 
				Double.valueOf(101));
		
		User usertype = user.getType();
		usertype.calculateMoney();
		
		assertEquals(usertype.getMoney(), Double.valueOf(121.2));
	}
	
	@Test
	public void whenCallCalculeMoneyPremiumUser() {
		User user = User.build("Carlos", 
				"charlydmoreno@gmail.com", 
				"Peru 2464",
				"+5491154762313", 
				UserType.Premium, 
				Double.valueOf(101));
		
		User usertype = user.getType();
		usertype.calculateMoney();
		
		assertEquals(usertype.getMoney(), Double.valueOf(303));
	}
	
	@Test
	public void shoulCreateNormalUser() {
		User user = User.build("Carlos", 
				"charlydmoreno@gmail.com", 
				"Peru 2464",
				"+5491154762313", 
				UserType.Normal, 
				Double.valueOf(101));
		
		User usertype = user.getType();
		
		assertEquals(usertype.getUserType(), UserType.Normal);
	}
	
	@Test
	public void shoulCreateSuperUser() {
		User user = User.build("Carlos", 
				"charlydmoreno@gmail.com", 
				"Peru 2464",
				"+5491154762313", 
				UserType.SuperUser, 
				Double.valueOf(101));
		
		User usertype = user.getType();
		
		assertEquals(usertype.getUserType(), UserType.SuperUser);
	}
	
	@Test
	public void shoulCreatePremiumUser() {
		User user = User.build("Carlos", 
				"charlydmoreno@gmail.com", 
				"Peru 2464",
				"+5491154762313", 
				UserType.Premium, 
				Double.valueOf(101));
		
		User usertype = user.getType();
		
		assertEquals(usertype.getUserType(), UserType.Premium);
	}

}
