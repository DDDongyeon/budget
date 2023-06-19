package multicapmpus.kb3.kb3project.entity;

import java.util.List;


public class BgroupmissionInfo {
    private String bgm_content;
    private String bgm_name;
    private String bgm_start;
    private String bgm_end;
    private int bgm_goal;
    private List<Integer> userCList;
    private List<Integer> userNoList;
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
	public String getBgm_start() {
		return bgm_start;
	}
	public void setBgm_start(String bgm_start) {
		this.bgm_start = bgm_start;
	}
	public String getBgm_end() {
		return bgm_end;
	}
	public void setBgm_end(String bgm_end) {
		this.bgm_end = bgm_end;
	}
	public int getBgm_goal() {
		return bgm_goal;
	}
	public void setBgm_goal(int bgm_goal) {
		this.bgm_goal = bgm_goal;
	}
	public List<Integer> getUserCList() {
		return userCList;
	}
	public void setUserCList(List<Integer> userCList) {
		this.userCList = userCList;
	}
	public List<Integer> getUserNoList() {
		return userNoList;
	}
	public void setUserNoList(List<Integer> userNoList) {
		this.userNoList = userNoList;
	}
	@Override
	public String toString() {
		return "BgroupmissionInfo [bgm_content=" + bgm_content + ", bgm_name=" + bgm_name + ", bgm_start=" + bgm_start
				+ ", bgm_end=" + bgm_end + ", bgm_goal=" + bgm_goal + ", userCList=" + userCList + ", userNoList="
				+ userNoList + "]";
	}
    
    
}
