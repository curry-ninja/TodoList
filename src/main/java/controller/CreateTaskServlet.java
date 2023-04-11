package controller;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/CreateTaskServlet")
public class CreateTaskServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String errMsg = "";
		String taskText = request.getParameter("task");
		String deadline = request.getParameter("deadline");		
		
		if(taskText == "" || deadline == "") {
			errMsg = "入力されていない項目があります";
			ErrorMessage errorMessage = new ErrorMessage();
			List<Task> tasks = new ArrayList<>();
			errorMessage.setErrorMessage(errMsg);
			
			request.setAttribute("errorMessage", errorMessage);
			request.setAttribute("tasks", tasks);
			RequestDispatcher dispatcher = request.getRequestDispatcher("./WEB-INF/lib/Home.jsp");
			dispatcher.forward(request,response);
			return;
		}
		
		//挿入するタスクを設定
		Task task = new Task();
		task.setTaskText(taskText);
		task.setDeadline(deadline);
		
		//タスクの挿入
		new TaskService().insertTask(task);
		
		//top画面に帰る
		response.sendRedirect("./HomeServlet");
	}
}
