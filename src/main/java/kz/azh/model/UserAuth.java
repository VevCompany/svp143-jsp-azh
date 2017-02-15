package kz.azh.model;

import java.util.ArrayList;

public class UserAuth {
	
	public UserAuth() {
		

		ArrayList<User> users = new ArrayList<User>();		
		for(int i = 0; i < 10; i++) {
			users.add(new User("login" + i,"password" + i));
		}
	}
	
	public static boolean login(String login, String password){		
			return true;
		}

}
