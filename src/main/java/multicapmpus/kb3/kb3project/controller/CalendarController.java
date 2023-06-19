package multicapmpus.kb3.kb3project.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import multicapmpus.kb3.kb3project.entity.Consume;
import multicapmpus.kb3.kb3project.entity.GroupConsume;
import multicapmpus.kb3.kb3project.mapper.ConsumeMapper;
import multicapmpus.kb3.kb3project.service.ConsumeService;
import multicapmpus.kb3.kb3project.service.GroupConsumeService;

@Controller
public class CalendarController {
	
	@Autowired
	private ConsumeService consumeService;
	private Map<Integer, String> categoryMap = new HashMap<>();
	
	public CalendarController() {
		 categoryMap.put(1,"식비");
         categoryMap.put(2,"카페/간식");
         categoryMap.put(3,"술/유흥");
         categoryMap.put(4,"생활");
         categoryMap.put(5,"패션쇼핑");
         categoryMap.put(6,"뷰티/미용");
         categoryMap.put(7,"교통비");
         categoryMap.put(8,"주거비");
         categoryMap.put(9,"의료/건강");
         categoryMap.put(10,"문화");
         categoryMap.put(11,"금융");
         categoryMap.put(12,"여행/숙박");
         categoryMap.put(13,"교육/학습");
         categoryMap.put(14,"가족");
         categoryMap.put(15,"반려동물");
         categoryMap.put(16,"경조사/선물");
         categoryMap.put(17,"멍청비용");
         categoryMap.put(18,"기타");


	}
	@Autowired
	private GroupConsumeService groupService;
	
	@Autowired
	private ConsumeMapper csmMapper;
	  
	
	@GetMapping("/hMyCalendar")
	public String hMycalendar(@RequestParam("year") int year, @RequestParam("month") int month, @RequestParam("day") int day, Model model, HttpSession session) {
		LocalDate now= (LocalDate)session.getAttribute("loginDate");
		Integer user_no = (Integer) session.getAttribute("user_no");
		Integer bd_no = (Integer) session.getAttribute("bd_no");
		//
		model.addAttribute("bd_no",bd_no);
		//LocalDate now = LocalDate.now();
		model.addAttribute("now", now);
		
		//LocalDate start = LocalDate.of(year, month, 1);
		LocalDate start = LocalDate.of(year, month, user_no);
		String strStart = start.format(DateTimeFormatter.ofPattern("yyyy-MM"));
		model.addAttribute("start", start);
		
		LocalDate pick = LocalDate.of(year, month, day);
		String strPickDay = pick.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		model.addAttribute("pick", pick);
		
		//List <Consume> consumes = consumeService.getMonthConsume(1, strStart);
		List <Consume> consumes = consumeService.getMonthConsume(user_no, strStart);
		int [] arr = consumeService.getSum(consumes);
		model.addAttribute("arr", arr);
		
		//List <Consume> dayConsumes = consumeService.getDayConsume(1, strPickDay);
		List <Consume> dayConsumes = consumeService.getDayConsume(user_no, strPickDay);
		model.addAttribute("dayConsumes", dayConsumes);
		model.addAttribute("categoryMap", categoryMap); // 移댄뀒怨좊━ 留� �꽆寃⑥＜湲�
		
		return "home/MyCalendar";
	}
	
	
	@GetMapping("/group/groupcalendar")
	public String Groupcalendar(@RequestParam(value = "year", required = false) Integer year,
	                            @RequestParam(value = "month", required = false) Integer month,
	                            @RequestParam(value = "day", required = false) Integer day,
	                            Model model,
	                            HttpSession session) {
	    int g_no = (int) session.getAttribute("g_no");

	    LocalDate now = LocalDate.now();
	    int currentYear = now.getYear();
	    int currentMonth = now.getMonthValue();
	    int currentDay = now.getDayOfMonth();
	    String g_name = groupService.getGroupName(g_no);
	    
	    
	    year = (year != null) ? year : currentYear;
	    month = (month != null) ? month : currentMonth;
	    day = (day != null) ? day : currentDay;
	    model.addAttribute("g_name", g_name);
	    model.addAttribute("now", now);
	    model.addAttribute("year", year);
	    model.addAttribute("month", month);
	    model.addAttribute("day", day);

	    LocalDate start = LocalDate.of(year, month, 1);
	    String strStart = start.format(DateTimeFormatter.ofPattern("yyyy-MM"));
	    model.addAttribute("start", start);

	    LocalDate pick = LocalDate.of(year, month, day);
	    String strPickDay = pick.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	    model.addAttribute("pick", pick);

	    List<GroupConsume> consumes = groupService.getGroupMonthConsume(g_no, strStart);
	    int[] arr = groupService.getSum(consumes);
	    model.addAttribute("arr", arr);
		
		 List<GroupConsume> dayConsumes = groupService.getGroupDayConsume(g_no,
		 strPickDay); model.addAttribute("dayConsumes", dayConsumes);
		 
	    List<Integer> totalmoney = csmMapper.getTotalMoneyList(g_no, strPickDay);
	    List<String> usernick = csmMapper.getUserNicknames(g_no, strPickDay);

	    model.addAttribute("membercs", totalmoney);
	    model.addAttribute("member", usernick);

	    return "group/groupcalendar";
	}

	
}
