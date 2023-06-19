package multicapmpus.kb3.kb3project.entity;


public class Buser {
	private int user_no;
	private String user_pwd;
	private String user_email;
	private String user_name;
	private String user_id;
	private String user_nickname;

	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_pwd() {
		return user_pwd;
	}
	public void setUser_pwd(String user_pwd) {
		this.user_pwd = user_pwd;
	}
	public String getUser_email() {
		return user_email;
	}
	public void setUser_email(String user_email) {
		this.user_email = user_email;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}

	@Override
	public String toString() {
		return "Buser [user_no=" + user_no + ", user_pwd=" + user_pwd + ", user_email=" + user_email + ", user_name="
				+ user_name + ", user_id=" + user_id + ", user_nickname=" + user_nickname + "]";
	}

}
