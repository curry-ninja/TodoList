package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.TaskService;

@WebServlet("/CompleteTaskServlet")
public class UpdateTaskServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int taskId = Integer.parseInt(request.getParameter("id").toString());
	 	new TaskService().completeTask(taskId);
		response.sendRedirect("./HomeServlet");
	}
}
