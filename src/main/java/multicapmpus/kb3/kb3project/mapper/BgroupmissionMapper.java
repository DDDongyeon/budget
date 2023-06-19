package multicapmpus.kb3.kb3project.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.MapKey;

import multicapmpus.kb3.kb3project.entity.Bgroup;
import multicapmpus.kb3.kb3project.entity.Bgroupmission;
import multicapmpus.kb3.kb3project.entity.BgroupmissionInfo;

@Mapper
public interface BgroupmissionMapper {
	
	@Select("SELECT * FROM bgroupmission WHERE bgm_no = #{bgmno}")
	Bgroupmission getBgmByNo(@Param("bgmno") int bgmNo);

	@Insert("INSERT INTO Bgroupmission (g_no, bgm_no, bgm_goal, bgm_content, bgm_start, bgm_end, bgm_name) " +
	        "VALUES (#{g_no}, bgm_no_seq.nextval, #{bgm.bgm_goal}, #{bgm.bgm_content}, #{bgm.bgm_start}, #{bgm.bgm_end}, #{bgm.bgm_name})")
	int save(@Param("g_no") int gNo, @Param("bgm") Bgroupmission bgm);
	
	@Delete("DELETE FROM bgroupmission WHERE bgm_no = #{bgmno}")
	int delete(@Param("bgmno") int bgmNo);
	
	@Select("select * from bgroupmission ordey by bgm_no desc")
	List<Bgroupmission> getBgroupmissionList();
	
	
	@Select("SELECT user_no FROM User_Group ug " +
	        "JOIN BGroupmission gm ON gm.G_NO = ug.G_NO " +
	        "WHERE gm.BGM_NO = #{bgmno}")
	List<Integer> getUserNoList(@Param("bgmno") int bgmNo);

	@Select("SELECT SUM(c.C_MONEY) AS USER_C_MONEY " +
	        "FROM User_Group ug " +
	        "JOIN Consume c ON ug.USER_NO = c.USER_NO " +
	        "WHERE ug.G_NO = (SELECT G_NO FROM BGroupmission WHERE BGM_NO = #{bgmno}) " +
	        "GROUP BY ug.USER_NO")
	List<Integer> getUserCList(@Param("bgmno") int bgmNo);

	@Select("SELECT SUM(c.C_MONEY) AS USER_C_MONEY " +
	        "FROM User_Group ug " +
	        "JOIN Consume c ON ug.USER_NO = c.USER_NO " +
	        "JOIN BGroupmission gm ON gm.G_NO = ug.G_NO " +
	        "WHERE ug.G_NO = (SELECT G_NO FROM BGroupmission WHERE BGM_NO = #{bgmno}) " +
	        "AND c.C_DATE < (SELECT BGM_start FROM BGroupmission WHERE BGM_NO = #{bgmno}) " +
	        "GROUP BY ug.USER_NO")
	List<Integer> getUserCListDate(@Param("bgmno") int bgmNo);

	@Select("SELECT u.USER_NICKNAME " +
	        "FROM User_Group ug " +
	        "JOIN Consume c ON ug.USER_NO = c.USER_NO " +
	        "JOIN BGroupmission gm ON gm.G_NO = ug.G_NO " +
	        "JOIN Buser u ON u.USER_NO = ug.USER_NO " +
	        "WHERE ug.G_NO = (SELECT G_NO FROM BGroupmission WHERE BGM_NO = #{bgmno}) " +
	        "AND c.C_DATE < (SELECT BGM_start FROM BGroupmission WHERE BGM_NO = #{bgmno}) " +
	        "GROUP BY u.USER_NICKNAME")
	List<String> getUserCListDateUserNo(@Param("bgmno") int bgmNo);


	@Select("SELECT USER_NICKNAME " +
	        "FROM User_Group " +
	        "WHERE USER_NO = #{userNo}")
	List<Integer> getUserNicknameByUserNo(@Param("userNo") int userNo);


	
}
