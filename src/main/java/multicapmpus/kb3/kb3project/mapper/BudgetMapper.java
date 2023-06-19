package multicapmpus.kb3.kb3project.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import multicapmpus.kb3.kb3project.entity.Budget;
import multicapmpus.kb3.kb3project.entity.BudgetList;
import multicapmpus.kb3.kb3project.entity.Consume;
import multicapmpus.kb3.kb3project.entity.ConsumePlusCategory;
@Mapper
public interface BudgetMapper {
	 
	@Insert("INSERT INTO BUDGET(bd_no, bd_name, bd_goal, bd_content, bd_start, bd_end, bd_goalnow, user_no) " +
            "VALUES(BD_NO_SEQ.NEXTVAL, #{budget.bd_name}, #{budget.bd_goal}, #{budget.bd_content}, #{budget.bd_start}, " +
            "#{budget.bd_end}, #{budget.bd_goalnow}, #{budget.user_no})")
    int save(@Param("budget") Budget budget);

    @Select("SELECT bd_no, bd_name, bd_goal, bd_goal-bd_goalnow AS bd_goalleft, bd_end-bd_start AS bd_dateleft " +
            "FROM budget WHERE user_no = #{user_no} ORDER BY bd_no DESC")
    List<BudgetList> findbudgetAll(@Param("user_no") int user_no);

    @Select("SELECT SUM(c.c_money) AS c_money, c.c_categoryid AS c_categoryid " +
            "FROM consume c, budget b " +
            "WHERE c.user_no = #{user_no} AND b.bd_no = #{bd_no} " +
            "AND c.c_date BETWEEN b.bd_start AND b.bd_end " +
            "GROUP BY c_categoryid")
    List<ConsumePlusCategory> findbudgetC(@Param("user_no") int user_no, @Param("bd_no") int bd_no);

   @Select("SELECT bd_no, bd_name, bd_goal, bd_goal-bd_goalnow AS bd_goalleft, bd_end-bd_start AS bd_dateleft " + 
   		   "FROM budget WHERE bd_no=#{bd_no}")
   BudgetList getBudgetByNo(@Param("bd_no") int bd_No);

   @Select("select bd_start, bd_end, bd_goalnow from budget where bd_no=#{bd_no}")
   Budget getBdByNo(@Param("bd_no") int bd_No);
   
   @Select("SELECT c.c_categoryid\r\n" + 
   		"FROM (\r\n" + 
   		"    SELECT c.c_categoryid, SUM(c.c_money) AS total_money\r\n" + 
   		"    FROM consume c, budget b\r\n" + 
   		"    WHERE c.user_no = #{user_no} AND b.bd_no = #{bd_no} AND c.c_date BETWEEN b.bd_start AND b.bd_end\r\n" + 
   		"    GROUP BY c.c_categoryid\r\n" + 
   		"    ORDER BY SUM(c.c_money) DESC\r\n" + 
   		") c\r\n" + 
   		"WHERE ROWNUM = 1")
   ConsumePlusCategory getCategoryByNo(@Param("user_no") int user_no, @Param("bd_no") int bd_no);
}
