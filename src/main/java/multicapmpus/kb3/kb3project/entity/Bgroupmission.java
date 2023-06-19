package multicapmpus.kb3.kb3project.entity;

import java.time.LocalDate;

public class Bgroupmission {
	private int g_no;
    private int bgm_no;
    private int bgm_goal;
    private String bgm_content;
    private LocalDate bgm_start;
    private LocalDate bgm_end;
    private String bgm_name;
    
	public LocalDate getBgm_start() {
		return bgm_start;
	}
	public void setBgm_start(LocalDate bgm_start) {
		this.bgm_start = bgm_start;
	}
	public LocalDate getBgm_end() {
		return bgm_end;
	}
	public void setBgm_end(LocalDate bgm_end) {
		this.bgm_end = bgm_end;
	}
	public int getG_no() {
		return g_no;
	}
	public void setG_no(int g_no) {
		this.g_no = g_no;
	}
	public int getBgm_no() {
		return bgm_no;
	}
	public void setBgm_no(int bgm_no) {
		this.bgm_no = bgm_no;
	}
	public int getBgm_goal() {
		return bgm_goal;
	}
	public void setBgm_goal(int bgm_goal) {
		this.bgm_goal = bgm_goal;
	}
	public String getBgm_content() {
		return bgm_content;
	}
	public void setBgm_content(String bgm_content) {
		this.bgm_content = bgm_content;
	}

	public String getBgm_name() {
		return bgm_name;
	}
	public void setBgm_name(String bgm_name) {
		this.bgm_name = bgm_name;
	}
	@Override
	public String toString() {
		return "Bgroupmission [bgm_no=" + bgm_no + ", bgm_goal=" + bgm_goal + ", bgm_content=" + bgm_content
				+ ", bgm_start=" + bgm_start + ", bgm_end=" + bgm_end + ", bgm_name=" + bgm_name + "]";
	}
    
    
}