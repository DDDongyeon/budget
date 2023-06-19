package multicapmpus.kb3.kb3project.entity.necessary;

import java.util.Date;

public class GroupWithMemberCount {
    private int g_no;
    private String g_name;
    private int memberCount;  //현재인원
    private int g_maxpeople;
    private String g_requiredTag;
    private String g_tag;
    private int g_leader;
    private Date g_date;
    private String g_content;
    private int g_private;

    public int getG_no() {
        return g_no;
    }

    public void setG_no(int g_no) {
        this.g_no = g_no;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public int getMemberCount() {
        return memberCount;
    }

    public void setMemberCount(int memberCount) {
        this.memberCount = memberCount;
    }

    public int getG_maxpeople() {
        return g_maxpeople;
    }

    public void setG_maxpeople(int g_maxpeople) {
        this.g_maxpeople = g_maxpeople;
    }

    public String getG_requiredTag() {
        return g_requiredTag;
    }

    public void setG_requiredTag(String g_requiredTag) {
        this.g_requiredTag = g_requiredTag;
    }

    public String getG_tag() {
        return g_tag;
    }

    public void setG_tag(String g_tag) {
        this.g_tag = g_tag;
    }

    public int getG_leader() {
        return g_leader;
    }

    public void setG_leader(int g_leader) {
        this.g_leader = g_leader;
    }

    public Date getG_date() {
        return g_date;
    }

    public void setG_date(Date g_date) {
        this.g_date = g_date;
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
}
