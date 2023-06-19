package multicapmpus.kb3.kb3project.entity;


public class Budget {
	private int bd_no;
	private String bd_name;
	private int bd_goal;
	private String bd_content;
	private String bd_start;
	private String bd_end;
	private int bd_goalnow;
	private int user_no;
	
	
	
	public String getBd_start() {
		return bd_start;
	}
	public void setBd_start(String bd_start) {
		this.bd_start = bd_start;
	}
	public String getBd_end() {
		return bd_end;
	}
	public void setBd_end(String bd_end) {
		this.bd_end = bd_end;
	}
	public int getBd_no() {
		return bd_no;
	}
	public void setBd_no(int bd_no) {
		this.bd_no = bd_no;
	}
	public String getBd_name() {
		return bd_name;
	}
	public void setBd_name(String bd_name) {
		this.bd_name = bd_name;
	}
	public int getBd_goal() {
		return bd_goal;
	}
	public void setBd_goal(int bd_goal) {
		this.bd_goal = bd_goal;
	}
	public String getBd_content() {
		return bd_content;
	}
	public void setBd_content(String bd_content) {
		this.bd_content = bd_content;
	}

	public int getBd_goalnow() {
		return bd_goalnow;
	}
	public void setBd_goalnow(int bd_goalnow) {
		this.bd_goalnow = bd_goalnow;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	@Override
	public String toString() {
		return "Budget [bd_no=" + bd_no + ", bd_name=" + bd_name + ", bd_goal=" + bd_goal + ", bd_content=" + bd_content
				+ ", bd_start=" + bd_start + ", bd_end=" + bd_end + ", bd_goalnow=" + bd_goalnow + ", user_no="
				+ user_no + "]";
	}
	
}	
