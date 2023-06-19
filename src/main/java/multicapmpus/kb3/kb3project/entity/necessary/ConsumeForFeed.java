package multicapmpus.kb3.kb3project.entity.necessary;

import java.time.LocalDate;

public class ConsumeForFeed {
    private int c_no;
    private int user_no;
    private String user_nickname;
    private String c_date;
    private int c_money;
    private int c_categoryid;
    private String c_content;
    private String c_image;
    private int c_like;
    private int commentNum;  //댓글 개수

    public int getC_no() {
        return c_no;
    }

    public void setC_no(int c_no) {
        this.c_no = c_no;
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

    public String getC_date() {
        return c_date;
    }

    public void setC_date(String c_date) {
        this.c_date = c_date;
    }

    public int getC_money() {
        return c_money;
    }

    public void setC_money(int c_money) {
        this.c_money = c_money;
    }

    public int getC_categoryid() {
        return c_categoryid;
    }

    public void setC_categoryid(int c_categoryid) {
        this.c_categoryid = c_categoryid;
    }

    public String getC_content() {
        return c_content;
    }

    public void setC_content(String c_content) {
        this.c_content = c_content;
    }

    public String getC_image() {
        return c_image;
    }

    public void setC_image(String c_image) {
        this.c_image = c_image;
    }

    public int getC_like() {
        return c_like;
    }

    public void setC_like(int c_like) {
        this.c_like = c_like;
    }

    public int getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(int commentNum) {
        this.commentNum = commentNum;
    }

    @Override
    public String toString() {
        return "ConsumeForFeed{" +
                "c_no=" + c_no +
                ", user_no=" + user_no +
                ", user_nickname='" + user_nickname + '\'' +
                ", c_date=" + c_date +
                ", c_money=" + c_money +
                ", c_categoryid=" + c_categoryid +
                ", c_content='" + c_content + '\'' +
                ", c_image='" + c_image + '\'' +
                ", c_like=" + c_like +
                ", commentNum=" + commentNum +
                '}';
    }
}
