package beans;
import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable{
	private int id;
	private String taskText;
	private String deadline;
	private Date fstDate;
	private Date lstdate;
	private int completeFlg;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTask() {
		return taskText;
	}
	public String getDeadline() {
		return deadline;
	}
	public void setTaskText(String taskText) {
		this.taskText = taskText;
	}
	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}
	public Date getFstDate() {
		return fstDate;
	}
	public void setFstDate(Date fstDate) {
		this.fstDate = fstDate;
	}
	public Date getLstdate() {
		return lstdate;
	}
	public void setLstdate(Date lstdate) {
		this.lstdate = lstdate;
	}
	public int getCompleteFlg() {
		return completeFlg;
	}
	public void setCompleteFlg(int completeFlg) {
		this.completeFlg = completeFlg;
	}
}
