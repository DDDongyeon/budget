package multicapmpus.kb3.kb3project.entity;

import java.time.LocalDate;


public class GroupConsume {
	private int c_no;
	private int c_money;
	private int user_no;
	private String user_nickname;
	private LocalDate c_date;
	private String c_content;
	private int c_like;
	private int c_categoryId;
	private String c_category;
	
	
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
	}
	public String getC_category() {
		return c_category;
	}
	public void setC_category(String c_category) {
		this.c_category = c_category;
	}
	public int getC_categoryId() {
		return c_categoryId;
	}
	public void setC_categoryId(int c_categoryId) {
		this.c_categoryId = c_categoryId;
	}
	public int getC_like() {
		return c_like;
	}
	public void setC_like(int c_like) {
		this.c_like = c_like;
	}
	public String getC_content() {
		return c_content;
	}
	public void setC_content(String c_content) {
		this.c_content = c_content;
	}
	public int getC_money() {
		return c_money;
	}
	public void setC_money(int c_money) {
		this.c_money = c_money;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public LocalDate getC_date() {
		return c_date;
	}
	public void setC_date(LocalDate c_date) {
		this.c_date = c_date;
	}
	@Override
	public String toString() {
		return "GroupConsume [c_money=" + c_money + ", user_no=" + user_no + ", user_nickname=" + user_nickname
				+ ", c_date=" + c_date + "]";
	}
	
	
	
}
