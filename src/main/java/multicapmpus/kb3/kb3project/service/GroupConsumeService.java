package multicapmpus.kb3.kb3project.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import multicapmpus.kb3.kb3project.entity.Consume;
import multicapmpus.kb3.kb3project.entity.GroupConsume;

public interface GroupConsumeService {

	
	
	List<GroupConsume> getGroupMonthConsume(long g_no, String date);

	List<GroupConsume> getGroupDayConsume(long g_no, String date);

	int[] getSum(List<GroupConsume> consumes);

	String getTopUserNickname(long g_no, String date);
	
	List<GroupConsume> getGroupConsumeByDate(long g_no, String date);
	
	String getGroupName(long g_no);
}
