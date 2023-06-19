package multicapmpus.kb3.kb3project.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import multicapmpus.kb3.kb3project.entity.Consume;
import multicapmpus.kb3.kb3project.entity.GroupConsume;

@Mapper
public interface GroupConsumeMapper {


	@Select("SELECT C.C_MONEY, U.User_nickname, C.C_Date " +
	        "FROM (" +
	        "    SELECT U.USER_NO, C.C_MONEY, C.C_Date, " +
	        "        ROW_NUMBER() OVER (PARTITION BY C.C_Date ORDER BY C.C_MONEY DESC) AS rn " +
	        "    FROM BUSER U " +
	        "    INNER JOIN USER_GROUP G ON U.USER_NO = G.USER_NO " +
	        "    INNER JOIN CONSUME C ON U.USER_NO = C.USER_NO " +
	        "    WHERE G.G_NO = #{g_no} " +
	        "        AND TO_CHAR(C.C_Date, 'YYYY-MM') = #{date} " +
	        ") T " +
	        "INNER JOIN BUSER U ON T.USER_NO = U.USER_NO " +
	        "INNER JOIN CONSUME C ON T.USER_NO = C.USER_NO AND T.C_Date = C.C_Date " +
	        "WHERE T.rn = 1 " +
	        "ORDER BY C.C_Date")

	List<GroupConsume> getGroupMonthConsumes(@Param("g_no") Long g_no, @Param("date") String date);

	
	
	
	/*
	 * @Select("SELECT C.C_MONEY, U.User_no, U.user_nickname, C.C_Date " +
	 * "FROM BUSER U " + "INNER JOIN USER_GROUP G ON U.USER_NO = G.USER_NO " +
	 * "INNER JOIN CONSUME C ON U.USER_NO = C.USER_NO " + "WHERE G.G_NO = #{g_no} "
	 * + "    AND TO_CHAR(C.C_DATE, 'YYYY-MM-DD') = #{date} " +
	 * "    AND U.USER_NO = (" + "        SELECT U.USER_NO " +
	 * "        FROM BUSER U " +
	 * "        INNER JOIN USER_GROUP G ON U.USER_NO = G.USER_NO " +
	 * "        INNER JOIN CONSUME C ON U.USER_NO = C.USER_NO " +
	 * "        WHERE G.G_NO = #{g_no} " +
	 * "            AND TO_CHAR(C.C_DATE, 'YYYY-MM-DD') = #{date} " +
	 * "        GROUP BY U.USER_NO, U.USER_nickname " +
	 * "        ORDER BY SUM(C.C_MONEY) DESC " + "        FETCH FIRST 1 ROW ONLY" +
	 * "    )") List<GroupConsume> getGroupDayConsumes(@Param("g_no") Long
	 * g_no, @Param("date") String date);
	 */
	
	@Select("SELECT SUM(C.C_MONEY) AS c_money, U.User_no, U.user_nickname, C.C_Date " +
	        "FROM BUSER U " +
	        "INNER JOIN USER_GROUP G ON U.USER_NO = G.USER_NO " +
	        "INNER JOIN CONSUME C ON U.USER_NO = C.USER_NO " +
	        "WHERE G.G_NO = #{g_no} " +
	        "    AND TO_CHAR(C.C_DATE, 'YYYY-MM-DD') = #{date} " +
	        "    AND U.USER_NO IN (" +
	        "        SELECT U.USER_NO " +
	        "        FROM BUSER U " +
	        "        INNER JOIN USER_GROUP G ON U.USER_NO = G.USER_NO " +
	        "        INNER JOIN CONSUME C ON U.USER_NO = C.USER_NO " +
	        "        WHERE G.G_NO = #{g_no} " +
	        "            AND TO_CHAR(C.C_DATE, 'YYYY-MM-DD') = #{date} " +
	        "        GROUP BY U.USER_NO " +
	        "        ORDER BY SUM(C.C_MONEY) DESC " +
	        "        FETCH FIRST 1 ROW ONLY" +
	        "    ) " +
	        "GROUP BY U.User_no, U.user_nickname, C.C_Date")
	List<GroupConsume> getGroupDayConsumes(@Param("g_no") Long g_no, @Param("date") String date);


	
	@Select("SELECT user_nickname " + "FROM BUSER U " + "INNER JOIN USER_GROUP G ON U.USER_NO = G.USER_NO "
			+ "INNER JOIN CONSUME C ON U.USER_NO = C.USER_NO " + "WHERE G.G_NO = #{g_no} "
			+ "    AND TO_CHAR(C.C_DATE, 'YYYY-MM-DD') = #{date} " + "GROUP BY U.user_nickname "
			+ "ORDER BY SUM(C.C_MONEY) DESC " + "FETCH FIRST 1 ROW ONLY")
	String getTopUserNickname(@Param("g_no") long g_no, @Param("date") String date);

	@Select("Select * from consume where user_no = #{user_no}")
	Consume getConsumebyId(@Param("user_no") long user_no);

	@Select("SELECT b.user_nickname, c.c_money, SUM(c.c_money) AS total_money, c.c_content, c.c_like, c.c_categoryid "
			+ "FROM CONSUME c " + "JOIN user_group ug ON c.USER_NO = ug.USER_NO "
			+ "JOIN buser b ON c.USER_NO = b.USER_NO " + "WHERE ug.G_NO = #{g_no} "
			+ "AND TO_CHAR(c.C_DATE, 'YYYY-MM-DD') = #{date} "
			+ "GROUP BY b.user_nickname, c.c_money, c.c_content, c.c_like, c.c_categoryid "
			+ "ORDER BY total_money DESC")
	List<GroupConsume> getGroupConsumeByDate(@Param("g_no") long g_no, @Param("date") String date);

	@Select("SELECT G_NAME FROM Bgroup WHERE G_NO = #{g_no}")
	String getGroupName(@Param("g_no") long g_no);

}