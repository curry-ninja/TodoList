package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Task;
import dao.TaskDao;

public class TaskService {
	public List<Task> findAll() {
		
		List<Task> taskList = new ArrayList<>();
		
		try {
			TaskDao taskDao = new TaskDao();
			taskList = taskDao.selectAll();
			return taskList;

		} catch (SQLException e) {
			System.out.println(e);
			taskList = null;
			return taskList;
		} catch (Error e) {
			throw e;
		}
	}
	
	public void insertTask(Task task) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/todolist","root","orenonaha01");
			new TaskDao().insertTask(con, task);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteTask(int id) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/todolist","root","orenonaha01");
			new TaskDao().deleteTask(con,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void completeTask(int id) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/todolist","root","orenonaha01");
			new TaskDao().completeTask(con,id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
