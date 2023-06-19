package multicapmpus.kb3.kb3project.mapper;

import multicapmpus.kb3.kb3project.entity.Bcomment;
import multicapmpus.kb3.kb3project.entity.necessary.CommentWithUserName;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {

    /*
        댓글 등록
     */
    @Insert("INSERT INTO Bcomment (cmn_no, user_no, c_no, cmn_date, cmn_content) " +
            "VALUES (cmn_no_seq.nextval, #{bcomment.user_no}, #{bcomment.c_no}, sysdate, #{bcomment.cmn_content})")
    int insert(@Param("bcomment") Bcomment bcomment);

    /*
        댓글 조회
     */
    @Select("SELECT C.*, B.user_nickname FROM Bcomment C JOIN Buser B ON C.user_no = B.user_no " +
            "WHERE C.c_no = #{consumeNo} " +
            "ORDER BY C.cmn_date DESC")
    List<CommentWithUserName> selectByConsumeNo(@Param("consumeNo") int consumeNo);
}

