package sat.recruitment.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;
import sat.recruitment.api.entity.User;
import sat.recruitment.api.enums.UserType;
import sat.recruitment.api.repository.UserRepository;
import sat.recruitment.api.service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@InjectMocks
	private UserRepository repository;
	
	@InjectMocks
	private UserService service;
	
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
	public void whenCallCalculeMoneyNormalUserTo50() {
		User user = User.build("Carlos", 
				"charlydmoreno@gmail.com", 
				"Peru 2464",
				"+5491154762313", 
				UserType.Normal, 
				Double.valueOf(50));
		
		User usertype = user.getType();
		usertype.calculateMoney();
		
		assertEquals(usertype.getMoney(), Double.valueOf(90));
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
	
	@Test
	public void findAllUserOk() {
		var result = repository.findAllUser();
		assertNotNull(result);
	}
	
	@Test
	public void userIsDuplicated() {
		String  result = "";
		User user = User.build("Carlos", 
				"charlydmoreno@gmail.com", 
				"Peru 2464",
				"+5491154762313", 
				UserType.Premium, 
				Double.valueOf(100));
		
		List<User> allUser = repository.findAllUser();
		try {
			service.isDuplicated(user, allUser);
		} catch (ResponseStatusException ex){
			result = ex.getReason();
		}
		
		assertEquals(result, "User is duplicated");

	}

}
