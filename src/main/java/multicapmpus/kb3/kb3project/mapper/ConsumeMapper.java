package multicapmpus.kb3.kb3project.mapper;


import multicapmpus.kb3.kb3project.entity.necessary.ConsumeForFeed;
import multicapmpus.kb3.kb3project.entity.necessary.ConsumeWithUserName;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Insert;

import multicapmpus.kb3.kb3project.entity.Consume;


@Mapper
public interface ConsumeMapper {

    /*
        g_no�쓽 紐⑤뱺 user_no�쓽 user_name怨� consume怨� �빐�떦 consume湲��쓽 �뙎湲� 媛쒖닔瑜� date �삤由꾩감�닚�쑝濡� 媛��졇�삤湲�
    */
	@Select("SELECT c.c_no, c.user_no, TO_CHAR(c.c_date, 'YYYY\"년\" MM\"월\" DD\"일\"') as c_date, c.c_money, c.c_categoryid, c.c_image, c.c_content, bu.user_nickname, COUNT(bc.cmn_no) AS commentNum, c.c_like " +
			"FROM user_group ug " +
			"JOIN Buser bu ON ug.user_no = bu.user_no " +
			"JOIN Consume c ON ug.user_no = c.user_no " +
			"LEFT JOIN Bcomment bc ON c.c_no = bc.c_no " +
			"WHERE ug.g_no = #{groupNo} " +
			"GROUP BY c.c_no, c.user_no, c.c_date, c.c_money, c.c_categoryid, c.c_image, c.c_content, bu.user_name, bu.user_nickname, c.c_like " +
			"ORDER BY c.c_date DESC")
	public List<ConsumeForFeed> selectConsumesWithCommentNumByGroupNo(@Param("groupNo") int groupNo);

	/*
        consumeNo로 소비글 가져오기
     */
	@Select("SELECT TO_CHAR(c.c_date, 'YYYY\"년\"MM\"월\"DD\"일\"') AS c_date, c.user_no, c.c_money, c.c_categoryid, c.c_image, c.c_content, c.c_like, buser.user_nickname " +
			"FROM consume c " +
			"JOIN buser ON c.user_no = buser.user_no " +
			"WHERE c.c_no = #{consumeNo}")
	public ConsumeWithUserName selectOneByConsumeNo(@Param("consumeNo") int consumeNo);

    /*
        g_no�쓽 紐⑤뱺 user_no�쓽 user_name怨� consume�쓣 date �삤由꾩감�닚�쑝濡� 媛��졇�삤湲� - �궗�슜X
    */
    @Select("SELECT C.*, B.user_name" +
            "        FROM Consume C JOIN Buser B ON C.user_no = B.user_no" +
            "        WHERE C.user_no IN (SELECT user_no FROM user_group WHERE g_no = #{groupNo})" +
            "        ORDER BY C.c_date ASC")
    public List<ConsumeWithUserName> selectConsumesByGroupNo(@Param("groupNo") int groupNo);

    /*
    醫뗭븘�슂 �늻瑜대㈃ c_like +1
     */
    @Update("UPDATE Consume SET c_like = c_like + 1 WHERE c_no = #{consumeNo}")
    public int updateLike(@Param("consumeNo") int consumeNo);
    
	@Select("Select * from CONSUME ORDER BY c_no DESC")
	public List<Consume> getAll();

	@Select("SELECT * FROM CONSUME WHERE C_NO= #{c_no}")
	Optional<Consume> findByCno(@Param("c_no") int c_no);

	@Insert("insert into CONSUME (c_no, user_no, c_money, c_categoryid, c_date, c_image,c_content) "
			+ "VALUES (C_NO_SEQ.nextval,#{csm.user_no},#{csm.c_money},#{csm.c_categoryid},#{csm.c_date},#{csm.c_image},#{csm.c_content})")
	int save(@Param("csm") Consume csm);

	// SELECT * FROM Consume WHERE c_date >= TO_DATE('2023-05-17', 'YYYY-MM-DD') and
	// c_date <= TO_DATE('2023-05-17', 'YYYY-MM-DD')+1;
	@Select("SELECT * FROM consume WHERE TRUNC(c_date) = TO_DATE(#{date}, 'YYYY-MM-DD') " + "AND user_no=#{user_no} ORDER BY C_NO DESC")
	// ("select * from consume where c_date >= TO_DATE( #{date}, 'YYYY-MM-DD') and
	// c_date <= TO_DATE(#{date}, 'YYYY-MM-DD')+1")
	// ("select * from consume where c_date >= TO_DATE( #{date}, 'YYYY-MM-DD') and
	// c_date <= TO_DATE(#{date}, 'YYYY-MM-DD')+1")
	public List<Consume> findByDate(@Param("date") String date, @Param("user_no") int user_no);

	////////////// �삁�뒳�떂
	@Select("SELECT * FROM CONSUME WHERE USER_NO=#{user_no} AND TO_CHAR(C_DATE, 'YYYY-MM') = #{date}")
	List<Consume> getMonthConsume(@Param("user_no") int user_no, @Param("date") String date);

	@Select("SELECT * FROM CONSUME WHERE USER_NO=#{user_no} AND TO_CHAR(C_DATE, 'YYYY-MM-DD') = #{date}")

	List<Consume> getDayConsume(@Param("user_no") long user_no, @Param("date") String date);

	@Select("SELECT buser.user_nickname " + "FROM CONSUME " + "JOIN user_group ON CONSUME.USER_NO = user_group.USER_NO "
			+ "JOIN buser ON user_group.USER_NO = buser.USER_NO " + "WHERE user_group.G_NO = #{g_no} "
			+ "AND TO_CHAR(CONSUME.C_DATE, 'YYYY-MM-DD') = #{date} " + "GROUP BY buser.user_nickname "
			+ "ORDER BY SUM(CONSUME.c_money) deSC")
	List<String> getUserNicknames(@Param("g_no") long g_no, @Param("date") String date);

	@Select("SELECT SUM(CONSUME.c_money) AS total_money " + "FROM CONSUME "
			+ "JOIN user_group ON CONSUME.USER_NO = user_group.USER_NO "
			+ "JOIN buser ON user_group.USER_NO = buser.USER_NO " + "WHERE user_group.G_NO = #{g_no} "
			+ "AND TO_CHAR(CONSUME.C_DATE, 'YYYY-MM-DD') = #{date} " + "GROUP BY buser.user_nickname "
			+ "ORDER BY total_money deSC")
	List<Integer> getTotalMoneyList(@Param("g_no") long g_no, @Param("date") String date);

	@Select("SELECT * " + "FROM (" + "    SELECT user_no, SUM(c_money) AS total_money " + "    FROM CONSUME "
			+ "    WHERE USER_NO IN ( " + "        SELECT ug.user_no " + "        FROM user_group ug "
			+ "        JOIN bgroup bg ON ug.g_no = bg.g_no " + "        WHERE bg.g_no = #{g_no} "
			+ "    ) AND TO_CHAR(C_DATE, 'YYYY-MM') = #{date} " + "    GROUP BY user_no "
			+ "    ORDER BY total_money DESC " + ") " + "WHERE ROWNUM = 1")
	List<Consume> getMemberMonthConsume(@Param("g_no") long g_no, @Param("date") String date);

	@Select("SELECT * " + "FROM (" + "    SELECT user_no, SUM(c_money) AS total_money " + "    FROM CONSUME "
			+ "    WHERE USER_NO IN ( " + "        SELECT ug.user_no " + "        FROM user_group ug "
			+ "        JOIN bgroup bg ON ug.g_no = bg.g_no " + "        WHERE bg.g_no = #{g_no} "
			+ "    ) AND TO_CHAR(C_DATE, 'YYYY-MM') = #{date} " + "    GROUP BY user_no "
			+ "    ORDER BY total_money DESC " + ") " + "WHERE ROWNUM = 1")
	List<Consume> getMemberDayConsume(@Param("g_no") long g_no, @Param("date") String date);

	@Select("SELECT b.user_nickname, c.c_money, c.c_content, c.c_like " + "FROM CONSUME c "
			+ "JOIN user_group ug ON c.USER_NO = ug.USER_NO " + "JOIN buser b ON c.USER_NO = b.USER_NO "
			+ "WHERE ug.G_NO = #{g_no} " + "AND TO_CHAR(c.C_DATE, 'YYYY-MM-DD') = #{date}")
	List<Consume> getGroupConsumeByDate(@Param("g_no") long g_no, @Param("date") String date);

}
