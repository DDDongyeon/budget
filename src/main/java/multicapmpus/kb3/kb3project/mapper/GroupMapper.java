package multicapmpus.kb3.kb3project.mapper;

import multicapmpus.kb3.kb3project.entity.Bgroup;
import multicapmpus.kb3.kb3project.entity.necessary.GroupInfo;
import multicapmpus.kb3.kb3project.entity.extra.GroupWithLeaderName;
import multicapmpus.kb3.kb3project.entity.necessary.GroupWithMemberCount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface GroupMapper {

    /*
    그룹 만들기
     */
    @Insert("insert into bgroup (g_no, g_maxpeople, g_content, g_tag, g_date, g_leader, g_requiredTag, g_name) " +
            "VALUES (g_no_seq.nextval, #{group.g_maxpeople}, #{group.g_content}, #{group.g_tag}, sysdate, #{group.g_leader}, #{group.g_requiredTag}, #{group.g_name})")
    public int saveGroup(@Param("group") Bgroup group);

    /*
    gName으로 g_no 가져오기
     */
    @Select("SELECT g_no FROM Bgroup WHERE g_name = #{gName}")
    public int selectGroupNoByGname(@Param("gName") String gName);

    /*
    g_no으로 그룹정보 가져오기 (그룹, 리더이름, 현재인원)
     */
    @Select("SELECT bg.g_no, bg.g_name, bg.g_maxpeople, bg.g_content, bg.g_requiredTag, bg.g_tag, bg.g_leader, bg.g_date, bg.g_private, " +
            "COUNT(ug.user_no) AS memberCount, bu.user_name AS g_leaderName " +
            "FROM Bgroup bg LEFT JOIN user_group ug ON bg.g_no = ug.g_no " +
            "JOIN Buser bu ON bg.g_leader = bu.user_no WHERE bg.g_no = #{groupNo} " +
            "GROUP BY bg.g_no, bg.g_name, bg.g_maxpeople, bg.g_content, bg.g_requiredTag, bg.g_tag, bg.g_leader, bg.g_date, bg.g_private, bu.user_name")
    public GroupInfo selectGroupInfo(@Param("groupNo") int groupNo);

    /*
    그룹 전체 조회
     */
    @Select("select * from bgroup")
    public List<Bgroup> selectAll();

    /*
    user_no가 속한 그룹들과 해당 그룹의 현재 인원 가져오기
     */
    @Select("SELECT bg.*, COUNT(u2.user_no) AS memberCount " +
            "FROM bgroup bg " +
            "JOIN user_group u ON bg.g_no = u.g_no " +
            "JOIN user_group u2 ON bg.g_no = u2.g_no " +
            "WHERE u.user_no = ${userNo} " +
            "GROUP BY bg.g_no, bg.g_name, bg.g_maxpeople, bg.g_content, bg.g_requiredTag, bg.g_tag, bg.g_leader, bg.g_date, bg.g_private")
    public List<GroupWithMemberCount> selectGroupsWithMemberCountByUserNo(@Param("userNo") int userNo);


    /*
        검색어가 그룹명 또는 해시태그 또는 필수태그에 포함된 그룹 가져오기
    */
    @Select("SELECT * FROM Bgroup WHERE g_tag LIKE '%' || #{searchValue} || '%' OR g_name LIKE '%' || #{searchValue} || '%' OR g_requiredTag LIKE '%' || #{searchValue} || '%'")
    public List<Bgroup> selectBySearchValue(@Param("searchValue") String searchValue);


    /*
        g_tag로 그룹 가져오기
     */
    @Select("SELECT * FROM Bgroup WHERE g_requiredTag = #{gRequiredTag}")
    public List<Bgroup> selectByGtag(@Param("gRequiredTag") String gRequiredTag);



    /*
    user_no와 groupNo를 등록
     */
    @Insert("insert into user_group (usergroup, user_no, g_no) " +
            "values (usergroup_no_seq.nextval, #{userNo}, #{groupNo})")
    public int insertUserGroup(@Param("userNo") int userNo, @Param("groupNo") int groupNo);

    /*
    user_no가 속한 group 가져오기 - 사용X
     */
    @Select("SELECT * FROM Bgroup WHERE g_no IN " +
            "(SELECT g_no FROM user_group WHERE user_no = #{userNo})")
    public List<Bgroup> selectGroupsByUserNo(@Param("userNo") int userNo);

    /*
    groupNo으로 그룹정보 가져오기 - 사용X
     */
    @Select("SELECT g.*, u.user_name as g_leaderName FROM Bgroup g " +
            "JOIN Buser u ON g.g_leader = u.user_no WHERE g.g_no = #{groupNo}")
    public GroupWithLeaderName selectByGroupNo(@Param("groupNo") int groupNo);




}
