package multicapmpus.kb3.kb3project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import multicapmpus.kb3.kb3project.entity.Bgroup;

@Mapper
public interface BgroupMapper {
	
	@Select("SELECT * FROM bgroup WHERE g_no = #{gno}")
	Bgroup getBgroupById(@Param("gno") int gNo);

	@Select("SELECT bg.g_no " +
	        "FROM user_group ug " +
	        "JOIN bgroup bg ON ug.g_no = bg.g_no " +
	        "WHERE ug.user_no = #{userNo}")
	int getgNoByUserNo(@Param("userNo") int userNo);
	
	@Insert("insert into Bgroup (g_no, g_maxpeople, g_content, g_tag, g_date, g_leader, g_name) "
			+ "VALUES (g_no_seq.nextval,#{Bgroup.g_maxpeople},#{Bgroup.g_content},#{Bgroup.g_tag},sysdate,#{Bgroup.g_leader},#{Bgroup.g_name})")
	int save(@Param("Bgroup") Bgroup bgroup);
	
	@Delete("DELETE FROM bgroup WHERE g_no = #{gno}")
	int delete(@Param("gno") int gno);
	
	@Select("select * from bgroup ordey by g_no desc")
	List<Bgroup> getBgroupList();
	
    @Select("SELECT g_name " +
            "FROM bgroup " +
            "WHERE g_no IN (" +
            "    SELECT g_no " +
            "    FROM user_group " +
            "    WHERE user_no = #{userNo}" +
            ")")
    List<String> getGNamesByUserNo(@Param("userNo") int userNo);

    @Select("SELECT g_no " +
    		"FROM bgroup " +
    		"WHERE g_no IN (" +
    		"    SELECT g_no " +
    		"    FROM user_group " +
    		"    WHERE user_no = #{userNo}" +
    		")")
    List<Integer> getGNosByUserNo(@Param("userNo") int userNo);



}
