package multicapmpus.kb3.kb3project.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import multicapmpus.kb3.kb3project.entity.Consume;
import multicapmpus.kb3.kb3project.entity.GroupConsume;
import multicapmpus.kb3.kb3project.mapper.ConsumeMapper;
import multicapmpus.kb3.kb3project.mapper.GroupConsumeMapper;

@Service
public class GroupConsumeServiceImpl implements GroupConsumeService {
	
	@Autowired
	private GroupConsumeMapper mapper;

	@Override
	public List<GroupConsume> getGroupMonthConsume(long g_no, String date) {
		return mapper.getGroupMonthConsumes(g_no, date);
	}

	@Override
	public List<GroupConsume> getGroupDayConsume(long g_no, String date) {
		return mapper.getGroupDayConsumes(g_no, date);
	} 
	
	@Override
	public int[] getSum(List<GroupConsume> consumes) {
		
		int [] arr = new int [32];  
		arr[0] = 0;
		
		for (GroupConsume consume : consumes) {
			arr[0] += consume.getC_money();
			arr[consume.getC_date().getDayOfMonth()] += consume.getC_money();
		}
		
		return arr;
	}

	@Override
	public String getTopUserNickname(long g_no, String date) {
		return mapper.getTopUserNickname(g_no, date);
	}
	
	@Override
	public List<GroupConsume> getGroupConsumeByDate(long g_no, String date) {
		return mapper.getGroupConsumeByDate(g_no, date);
	}

	@Override
	public String getGroupName(long g_no) {
		return mapper.getGroupName(g_no);
	}

	



}
