package multicapmpus.kb3.kb3project.service;


import java.util.Date;
import java.util.List;
import multicapmpus.kb3.kb3project.entity.necessary.ConsumeForFeed;
import multicapmpus.kb3.kb3project.entity.necessary.ConsumeWithUserName;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.apache.ibatis.annotations.Param;
import multicapmpus.kb3.kb3project.entity.Consume;

public interface ConsumeService {
	public List<Consume> getConsumeList();
	public Consume getConsumeDetail(int c_no);
	public void create(String date, int amount, int category,String memo, String photo,HttpSession session);
//	public List<Consume> getConsumeListByDate(String c_date);
	public List<Consume> getConsumeListByDate(String c_date,HttpSession session, Model model);
	
	
	////////////////////////////////////ys
	List<Consume> getMonthConsume(int user_no, String date);

	List<Consume> getDayConsume(int user_no, String date);

	int [] getSum(List<Consume> consumes);
	
	List<Consume> getGroupDayConsume(long g_no, String date);
	
	List<String> getUserNicknames(long g_no, String date);
	
	List<Integer> getTotalMoneyList(long g_no, String date);

	List<Consume> getMemberMonthConsume(long g_no, String date);
	
	List<Consume> getMemberDayConsume(long g_no, String date);

    public List<ConsumeForFeed> getConsumesForFeed(int groupNo);  //�빐�떦 洹몃９�쓽 紐⑤뱺 �냼鍮꾧� 媛��졇�삤湲�(+�뙎湲� 媛쒖닔, 醫뗭븘�슂�닔)

    public int increaseLike(int consumeNo);  //�빐�떦 �냼鍮꾧��쓽 醫뗭븘�슂 �닔 利앷�

    public ConsumeWithUserName getConsumeByConsumeNo(int consumeNo);  //�빐�떦 �냼鍮꾧� 遺덈윭�삤湲� in �뙎湲� 紐⑤떖李�

    public List<ConsumeWithUserName> getConsumes(int groupNo);  //洹몃９�쓽 紐⑤뱺 �냼鍮꾧� 議고쉶 - �궗�슜X
}
