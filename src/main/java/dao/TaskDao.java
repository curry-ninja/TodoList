package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Task;

public class TaskDao {
	public List<Task> selectAll() throws SQLException {
		
		//戻り値用リスト
		List<Task> taskList = new ArrayList<>(); 
		//
		PreparedStatement ps = null;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/todolist","root","orenonaha01");
			//SQL送信
			String sql = "SELECT * FROM Task;";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			//resurtの整理
			while(rs.next()) {
				//taskインスタンスを作成する
				Task task = new Task();
				
				//taskインスタンスに要素をぶち込んでいく
				task.setId(rs.getInt("id"));
				task.setTaskText(rs.getString("task"));
				task.setDeadline(rs.getString("deadline"));
				task.setFstDate(rs.getDate("FST_DAY"));
				task.setLstdate(rs.getDate("LST_DAY"));
				task.setCompleteFlg(rs.getInt("COMPLETE_FLG"));
				
				//taskを追加する
				taskList.add(task);
			}
			//戻り値の設定
			return taskList;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			taskList = null;
			return taskList;
		} finally {
//			ps.close();
		}
	}
	
	public void insertTask(Connection con, Task task) throws SQLException {
		
		PreparedStatement ps = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO task (");
			sql.append("	task    ,");
			sql.append("	deadline,");
			sql.append("	FST_DAY ,");
			sql.append("	LST_DAY");
			sql.append(") VALUES (");
			sql.append("	? ,");
			sql.append("	? ,");
			sql.append("	CURRENT_TIMESTAMP ,");
			sql.append("	CURRENT_TIMESTAMP");
			sql.append(");");

			ps = con.prepareStatement(sql.toString());
			
			ps.setString(1, task.getTask());
	        Date sqlDate= Date.valueOf(task.getDeadline());
			ps.setDate(2, sqlDate);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw e;
		}finally {
			ps.close();
		}
	}
	
	public void deleteTask(Connection con, int id) throws SQLException {
		PreparedStatement ps = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("DELETE FROM task");
			sql.append("	WHERE id =");
			sql.append("	? ");
			sql.append(";");

			ps = con.prepareStatement(sql.toString());
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw e;
		}finally {
			ps.close();
		}
	}
	
	public void completeTask(Connection con, int id) throws SQLException {
		PreparedStatement ps = null;
		try {
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE task");
			sql.append(" SET COMPLETE_FLG = 1,");
			sql.append(" 	 LST_DAY = CURRENT_TIMESTAMP");
			sql.append(" WHERE id = ? ");
			sql.append(";");

			ps = con.prepareStatement(sql.toString());
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw e;
		}finally {
			ps.close();
		}
	}

}
