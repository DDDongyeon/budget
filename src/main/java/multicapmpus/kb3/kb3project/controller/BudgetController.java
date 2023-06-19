package multicapmpus.kb3.kb3project.controller;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import multicapmpus.kb3.kb3project.entity.Budget;
import multicapmpus.kb3.kb3project.entity.BudgetList;
import multicapmpus.kb3.kb3project.entity.Consume;
import multicapmpus.kb3.kb3project.entity.ConsumePlusCategory;
import multicapmpus.kb3.kb3project.service.BudgetService;

@Controller
public class BudgetController {
	
	@Autowired private BudgetService budgetService;
	//占쏙옙占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쌍깍옙
	@GetMapping("/budget/budget_start")
	public String budgetStart(Model model) {
		return "budget/budget_start";
	}
	
	//占쏙옙占쏙옙 占쏙옙占�
	@GetMapping("/budget/budget_register")
	public String budgetRegisterForm(Model model) {
		return "budget/budget_register";
	}
	@GetMapping("/budget/create") 
	private String createBudget(Model model) {
		return "budget/create"; 
	}
	//post占쏙옙 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙 insert
	@PostMapping("/budget/create")
	public String createBudgetPost(HttpSession session, @RequestParam("title") String bd_name,
			@RequestParam("start_date") String bd_start,
			@RequestParam("end_date") String bd_end,
			@RequestParam("goal") int bd_goal,
			@RequestParam("comment") String bd_comment,
			@RequestParam("goal_now") int bd_goalnow) { 
		
		int user_No=(int) session.getAttribute("user_no");
		Budget bd=new Budget();
		bd.setBd_name(bd_name);
		bd.setBd_start(bd_start);
		bd.setBd_end(bd_end);
		bd.setBd_goal(bd_goal);
		bd.setBd_content(bd_comment);
		bd.setBd_goalnow(bd_goalnow);
		
		bd.setUser_no(user_No);
		budgetService.saveBudget(bd);
		
		return"redirect:/budget/budget_list"; 
	}
	//占쏙옙占쏙옙 占쏙옙占쏙옙트 占쏙옙占쏙옙占쌍깍옙 
	@GetMapping("/budget/budget_list") 
	public String budgetList(HttpSession session, Model model) { 
		
		int user_No=(int)session.getAttribute("user_no");
		List<BudgetList> budgetList = budgetService.findbudgetAll(user_No);
	
		model.addAttribute("budgetList", budgetList);
		return "budget/budget_list"; 
	}
	
	//占쏙옙占싸울옙占쏙옙 占쏙옙占쏙옙 占쌨아울옙占쏙옙
	@GetMapping("/budget/main")
	public String main(HttpSession session, Model model) {
		int user_No=(int)session.getAttribute("user_no");	
		model.addAttribute("user_no",user_No);
		
		return "redirect:/budget/budget_list";
		
	}
	//占쏙옙占쏘별 占쌀븝옙 占쏙옙占쏙옙트 占쏙옙 占쏙옙占쏙옙占쏙옙 占쏙옙占쏙옙占쌍깍옙
	@GetMapping("/budget/budget_detail{bd_no}")
	public String budgetDetailList(@PathVariable("bd_no") int bd_No, HttpSession session, Model model) {
		int user_No=(int) session.getAttribute("user_no");
		
	
		
		BudgetList bgl=budgetService.getBudgetByNo(bd_No);
		Budget bg=budgetService.getBdByNo(bd_No);
		List<ConsumePlusCategory> consumeList=budgetService.findbudgetC(user_No,bd_No);
		ConsumePlusCategory cpc=budgetService.getCategoryByNo(user_No,bd_No);
		String bd_start=bg.getBd_start().substring(0,10);
		String bd_end=bg.getBd_end().substring(0,10);
		int bd_goalnow=bg.getBd_goalnow();
		int bd_no=bgl.getBd_no();
		String bd_name=bgl.getBd_name();
		int bd_goal=bgl.getBd_goal();
		int bd_goalleft=bgl.getBd_goalleft();
		/* String bd_dateleft=bgl.getBd_dateleft(); */
		
	    LocalDate now = LocalDate.now();
	    LocalDate bdEnd = LocalDate.parse(bd_end.substring(0, 10)); // "yyyy-MM-dd" 형식의 문자열을 LocalDate로 변환

	    Period period = Period.between(now, bdEnd);
	    int remainingDays = period.getDays();
		
		HashMap<Integer, String> categoryMap=getCategoryMap();
		for(ConsumePlusCategory consume : consumeList) {
			int categoryid=consume.getC_categoryid();
			String category=categoryMap.get(categoryid);
			consume.setC_category(category);
		}
		
		int categoryidmax=cpc.getC_categoryid();
		String categorymax=categoryMap.get(categoryidmax);
		cpc.setC_category(categorymax);
		
		model.addAttribute("categorymax",categorymax);
		model.addAttribute("bd_goalnow",bd_goalnow);
		model.addAttribute("bd_start",bd_start);
		model.addAttribute("bd_end",bd_end);
		model.addAttribute("bd_no",bd_no);
		model.addAttribute("bd_name",bd_name);
		model.addAttribute("bd_goal",bd_goal);
		model.addAttribute("bd_goalleft",bd_goalleft);
		model.addAttribute("bd_dateleft",remainingDays);
		model.addAttribute("consumeList",consumeList);
		return "budget/budget_detail";
	} 
	
	//占쌀븝옙카占쌓곤옙 id->占싱몌옙占쏙옙占쏙옙 占쏙옙환
	 private HashMap<Integer, String> getCategoryMap() {
		 HashMap<Integer,String> categoryMap= new HashMap<>();
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

         return categoryMap;
	    }
	
	
	
	
		

}	