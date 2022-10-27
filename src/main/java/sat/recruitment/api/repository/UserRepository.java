package sat.recruitment.api.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import sat.recruitment.api.entity.User;
import sat.recruitment.api.enums.UserType;

@Repository
public class UserRepository implements IUserRepository {
	
	private final String PATH = "..\\java.Sat.Recruitment\\src\\main\\java\\sat\\recruitment\\api\\file\\users.txt";

	@Override
	public User save(User user) {
		writerFile(user.toString());
		return user;
	}
	
	@Override
	public List<User> findAllUser() {
		return readerFile();
	}
	
	private List<User> readerFile() {
		List<User> usersList = new ArrayList<User>();
		try {
			BufferedReader br = new BufferedReader(new FileReader(getFile()));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				String[] line = strLine.split(",");
				User user = User.build(line[0], line[1], line[2], line[3], UserType.valueOf(line[4]),
						Double.valueOf(line[5]));
				usersList.add(user);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return usersList;
	}
	
	private void writerFile(String contentsUser) {
		try {
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(getFile(), true)));
	        bw.write("\r\n" + contentsUser);
	        bw.flush();
	        bw.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	private File getFile() {
		File file = new File(PATH);
		return file;
	}
}
