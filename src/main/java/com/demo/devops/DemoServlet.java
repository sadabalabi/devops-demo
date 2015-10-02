package com.demo.devops;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8844621048865280926L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String respMessage = null;
		String flag = request.getParameter("flag");
		try {

			if (flag.equalsIgnoreCase("1")) {
				System.out.println("---" + "Create");
				respMessage = createUser(request);
			} else if (flag.equalsIgnoreCase("2")) {
				System.out.println("---" + "find");
				respMessage = findUser(request);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		forward(request, response, "/result.jsp", respMessage);

	}

	void forward(HttpServletRequest request, HttpServletResponse response,
			String redirectUrl, String respMessage) throws IOException,
			ServletException {
		RequestDispatcher rd;
		request.setAttribute("result", respMessage);
		rd = getServletContext().getRequestDispatcher(redirectUrl);
		rd.forward(request, response);
	}

	String createUser(HttpServletRequest request) {
		DemoService demoService = new DemoService();
		UserVO user = new UserVO(request.getParameter("name"),
				request.getParameter("address"),
				request.getParameter("state"), request.getParameter("country"));
		demoService.createUser(user);
		
			return "User " + user.getName() + " created successfully";
		
		
	}

	String findUser(HttpServletRequest request) {
		UserVO user = new UserVO();
		DemoService demoService = new DemoService();
		user.setName(request.getParameter("name"));
		user.setState(request.getParameter("state"));
		UserVO responseUser = demoService.findUser(user);
		if(responseUser == null){
			System.out.println( " NO Result found");
			return  "No User Found ";
		}
		return "Retrieve User Details: \n " + responseUser.toString();
	}
}
