package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.ErrorMessage;
import beans.Task;
import service.TaskService;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HomeServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		List<Task> tasks = new TaskService().findAll();
		ErrorMessage errorMessage = new ErrorMessage();
		
		if(tasks.size() == 0) {
			String errMsg = "データベースにタスクがありません。";
			errorMessage.setErrorMessage(errMsg);
		} 
			request.setAttribute("errorMessage", errorMessage);
			request.setAttribute("tasks",tasks);
			RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/lib/Home.jsp");
			dispatcher.forward(request, response);
			return;
	}
}
