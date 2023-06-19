package multicapmpus.kb3.kb3project.entity.necessary;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

public class CommentWithUserName {
    private int cmn_no;
    private int user_no;
    private String user_nickname;
    private int c_no;
    private LocalDate cmn_date;
    private String cmn_content;

    public int getCmn_no() {
        return cmn_no;
    }

    public void setCmn_no(int cmn_no) {
        this.cmn_no = cmn_no;
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

    public int getC_no() {
        return c_no;
    }

    public void setC_no(int c_no) {
        this.c_no = c_no;
    }

    public LocalDate getCmn_date() {
        return cmn_date;
    }

    public void setCmn_date(LocalDate cmn_date) {
        this.cmn_date = cmn_date;
    }

    public String getCmn_content() {
        return cmn_content;
    }

    public void setCmn_content(String cmn_content) {
        this.cmn_content = cmn_content;
    }
}
