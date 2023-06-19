package multicapmpus.kb3.kb3project.entity;

import lombok.Data;
import lombok.NoArgsConstructor;


public class UserGroup {
    private int userGroup;
    private int user_no;
    private int g_no;

    public int getUserGroup() {
        return userGroup;
    }

    public void setUserGroup(int userGroup) {
        this.userGroup = userGroup;
    }

    public int getUser_no() {
        return user_no;
    }

    public void setUser_no(int user_no) {
        this.user_no = user_no;
    }

    public int getG_no() {
        return g_no;
    }

    public void setG_no(int g_no) {
        this.g_no = g_no;
    }
}
