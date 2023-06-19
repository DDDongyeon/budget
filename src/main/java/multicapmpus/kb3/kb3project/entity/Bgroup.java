package multicapmpus.kb3.kb3project.entity;
import java.util.Date;

public class Bgroup {
    private int g_no;
    private int g_maxpeople;
    private String g_content;
    private int g_private;
    private String g_tag;
    private Date g_date;
    private int g_leader;
    private String g_name;
    private String g_requiredTag;
    
	public String getG_requiredTag() {
		return g_requiredTag;
	}
	public void setG_requiredTag(String g_requiredTag) {
		this.g_requiredTag = g_requiredTag;
	}
	public int getG_no() {
		return g_no;
	}
	public void setG_no(int g_no) {
		this.g_no = g_no;
	}
	public int getG_maxpeople() {
		return g_maxpeople;
	}
	public void setG_maxpeople(int g_maxpeople) {
		this.g_maxpeople = g_maxpeople;
	}
	public String getG_content() {
		return g_content;
	}
	public void setG_content(String g_content) {
		this.g_content = g_content;
	}
	public int getG_private() {
		return g_private;
	}
	public void setG_private(int g_private) {
		this.g_private = g_private;
	}
	public String getG_tag() {
		return g_tag;
	}
	public void setG_tag(String g_tag) {
		this.g_tag = g_tag;
	}
	public Date getG_date() {
		return g_date;
	}
	public void setG_date(Date g_date) {
		this.g_date = g_date;
	}
	public int getG_leader() {
		return g_leader;
	}
	public void setG_leader(int g_leader) {
		this.g_leader = g_leader;
	}
	public String getG_name() {
		return g_name;
	}
	public void setG_name(String g_name) {
		this.g_name = g_name;
	}
	@Override
	public String toString() {
		return "Bgroup [g_no=" + g_no + ", g_maxpeople=" + g_maxpeople + ", g_content=" + g_content + ", g_private="
				+ g_private + ", g_tag=" + g_tag + ", g_date=" + g_date + ", g_leader=" + g_leader + ", g_name="
				+ g_name + "]";
	}
    
    
}

