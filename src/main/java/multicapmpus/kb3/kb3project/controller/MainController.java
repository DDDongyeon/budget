package multicapmpus.kb3.kb3project.controller;

import java.time.LocalDate;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@GetMapping("/sbb")
	@ResponseBody
	public String index() {
		return "안녕하세요 인덱스입니다.";
	}

	@GetMapping("/")
	public String root(HttpSession session) {
		/*
		 * Integer user_no = (Integer) session.getAttribute("user_no"); if (user_no !=
		 * null) return "home/home"; else return "redirect:/Buser/login";
		 */
		LocalDate now= (LocalDate)session.getAttribute("loginDate");
		Integer user_no = (Integer) session.getAttribute("user_no");
		if (user_no != null&&now!=null)
			return "forward:/hMyCalendar?year=" + now.getYear() + "&month=" + now.getMonthValue() + "&day=" + now.getDayOfMonth();
		else
			return "redirect:/Buser/login";
	}

	@GetMapping("/home")
	public String gohome(HttpSession session) {
		LocalDate now= (LocalDate)session.getAttribute("loginDate");
		Integer user_no = (Integer) session.getAttribute("user_no");
		if (user_no != null&&now!=null)
			return "forward:/hMyCalendar?year=" + now.getYear() + "&month=" + now.getMonthValue() + "&day=" + now.getDayOfMonth();
		else
			return "redirect:/Buser/login";
		//return "home/home";
	}
	
}
