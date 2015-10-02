package com.demo.devops;

public class DemoService{

	public void createUser(UserVO user) {
		DemoDAO demoDAO = new DemoDAO();
		demoDAO.createUser(user);
		
	}

	public UserVO findUser(UserVO user) {
		DemoDAO demoDAO = new DemoDAO();
		UserVO resUser =  demoDAO.findUser(user);
		if(resUser == null){
			System.out.println( " NO Result found");
		}
		return resUser;
	}
	
}
