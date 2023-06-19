package multicapmpus.kb3.kb3project.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import multicapmpus.kb3.kb3project.entity.necessary.ConsumeForFeed;
import multicapmpus.kb3.kb3project.entity.necessary.ConsumeWithUserName;
import multicapmpus.kb3.kb3project.mapper.ConsumeMapper;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;

import multicapmpus.kb3.kb3project.DataNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import multicapmpus.kb3.kb3project.entity.Consume;
import multicapmpus.kb3.kb3project.mapper.ConsumeMapper;


//@RequiredArgsConstructor
@Service
public class ConsumeServiceImpl implements ConsumeService {

	private final ConsumeMapper mapper;
	

	public ConsumeServiceImpl(ConsumeMapper mapper) {
		this.mapper = mapper;
	}

	@Override
	public List<Consume> getConsumeList() {
		return mapper.getAll();
	}

	@Override
	public Consume getConsumeDetail(int c_no) {
		Optional<Consume> csm = this.mapper.findByCno(c_no);
		if (csm.isPresent()) {
			return csm.get();
		} else {
			throw new DataNotFoundException("Not Found");
		}
	}
	
	

	@Override
	public void create(String date, int amount, int category, String memo, String photo,HttpSession session) {
		// date type String to LocalDate
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate localDate = LocalDate.parse(date, formatter);

		Consume csm = new Consume();
		Integer user_no=(Integer)session.getAttribute("user_no");
		csm.setUser_no(user_no); // �닔�젙�븘�슂
		//csm.setC_date(date);
		csm.setC_date(localDate);
		csm.setC_money(amount);
		csm.setC_categoryid(category);
		csm.setC_content(memo);
		csm.setC_image(photo);
		this.mapper.save(csm);

	}

//	@Override
//	public List<Consume> getConsumeListByDate(String c_date) {
//		return mapper.findByDate(c_date);
//	}

	@Override
	public List<Consume> getConsumeListByDate(String c_date, HttpSession session, Model model) {
		return mapper.findByDate(c_date, (int) session.getAttribute("user_no"));
	}

//////////////////////////////////////////////////ys
	@Override
	public List<Consume> getMonthConsume(int user_no, String date) {
		return mapper.getMonthConsume(user_no, date);
	}

	@Override
	public List<Consume> getDayConsume(int user_no, String date) {
		System.out.println(date);
		return mapper.getDayConsume(user_no, date);
	}

	@Override
	public int[] getSum(List<Consume> consumes) {

		int[] arr = new int[32];
		arr[0] = 0;

		for (Consume consume : consumes) {
			arr[0] += consume.getC_money();
			arr[consume.getC_date().getDayOfMonth()] += consume.getC_money();
		}

		return arr;
	}
//	@Override
//	public List<Consume> getGroupDayConsume(long g_no, String date) {
//		return mapper.getGroupDayConsume(g_no, date);
//		
//	}

	@Override
	public List<String> getUserNicknames(long g_no, String date) {
		// TODO Auto-generated method stub
		return mapper.getUserNicknames(g_no, date);
	}

	@Override
	public List<Integer> getTotalMoneyList(long g_no, String date) {
		// TODO Auto-generated method stub
		return mapper.getTotalMoneyList(g_no, date);
	}

	@Override
	public List<Consume> getGroupDayConsume(long g_no, String date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Consume> getMemberMonthConsume(long g_no, String date) {
		return mapper.getMemberMonthConsume(g_no, date);
	}

	@Override
	public List<Consume> getMemberDayConsume(long g_no, String date) {
		return mapper.getMemberDayConsume(g_no, date);
	}

    @Override
    public List<ConsumeForFeed> getConsumesForFeed(int groupNo) {
        List<ConsumeForFeed> consumesForFeed = mapper.selectConsumesWithCommentNumByGroupNo(groupNo);
        return consumesForFeed;
    }

    @Override
    public int increaseLike(int consumeNo) {
        int result = mapper.updateLike(consumeNo);
        return result;
    }

    @Override
    public ConsumeWithUserName getConsumeByConsumeNo(int consumeNo) {
        ConsumeWithUserName consume = mapper.selectOneByConsumeNo(consumeNo);
        return consume;
    }

    @Override  // �궗�슜X
    public List<ConsumeWithUserName> getConsumes(int groupNo) {
        List<ConsumeWithUserName> consumes = mapper.selectConsumesByGroupNo(groupNo);
        return consumes;
    }

    ///////////////////////////////////minjoo

}
