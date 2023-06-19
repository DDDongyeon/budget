package multicapmpus.kb3.kb3project.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import multicapmpus.kb3.kb3project.entity.Buser;
import multicapmpus.kb3.kb3project.service.BuserService;
import multicapmpus.kb3.kb3project.service.ConsumeService;

import lombok.RequiredArgsConstructor;


@Controller
@RequestMapping("/Buser")
public class BuserController {

	private final BuserService BService;


	public BuserController(BuserService BService) {
		this.BService = BService;
		 		 
	}

	@GetMapping("/signup")
	public String signup() {
		return "home/signup";
	}
	/*
	 * @PostMapping("/signup") public String
	 * signup(@ModelAttribute("BuserCreateForm") BuserCreateForm ucf, Model model) {
	 * String id=ucf.getUser_id(); String pwd=ucf.getUser_pwd(); String
	 * pwd2=ucf.getUser_pwd2(); String email=ucf.getUser_email(); String
	 * name=ucf.getUser_name(); String nickname=ucf.getUser_nickname();
	 * 
	 * System.out.println(id); System.out.println(123);
	 * 
	 * // 비밀번호 확인 if (!pwd.equals(pwd2)) { //model.addAttribute("error",
	 * "비밀번호가 일치하지 않습니다."); return "signup"; // 비밀번호가 일치하지 않을 경우 회원가입 폼으로 다시 이동 }
	 * 
	 * BService.create(ucf.getUser_id(), ucf.getUser_email(), ucf.getUser_pwd(),
	 * ucf.getUser_name(), ucf.getUser_nickname());
	 * 
	 * 
	 * 
	 * return "redirect:/Buser/login"; }
	 */

	@PostMapping("/signup")
	public String signup(@RequestParam("user_name") String name, @RequestParam("user_id") String id,
			@RequestParam("user_pwd") String pwd, @RequestParam("user_pwd2") String pwd2,
			@RequestParam("user_email") String email, @RequestParam("user_nickname") String nickname, Model model) {
		// 회원가입 로직 구현

		if (BService.isUseridTaken(id)) {
			model.addAttribute("error", "아이디 중복");
			return "home/signup";
		}

		if (!pwd.equals(pwd2)) {
			model.addAttribute("error", "비밀번호가 일치하지 않습니다.");
			return "home/signup";
		}
		BService.create(id, pwd, name, nickname, email);

		return "redirect:/Buser/login";
	}

	@GetMapping("/login")
	public String login() {
		return "home/login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("id") String id, @RequestParam("pwd") String pwd,
			HttpSession session, Model model) {
		// 로그인 로직 구현
		// id와 password를 사용하여 회원 인증을 수행하고 세션에 저장된 로그인 상태를 설정
		if (BService.authenticateUser(id, pwd)) {
			int user_no=BService.getBuserNo(id);
			session.setAttribute("user_no", user_no);
			session.setAttribute("id", id);

		    LocalDate now = LocalDate.now();
		    session.setAttribute("loginDate", now);
		  //  return "redirect:/home";
		    return "redirect:/hMyCalendar?year="+now.getYear()+"&&month="+now.getMonthValue()+"&&day="+now.getDayOfMonth();
		} else {
			model.addAttribute("error", "로그인 실패");
			return "home/login";
		}
	}
	
	@GetMapping("/mypage")
	public String mypage(Model model,HttpSession session) {
		Integer user_no=(Integer)session.getAttribute("user_no");
		Buser buser=BService.getBuserDetail(user_no);
		model.addAttribute("buser", buser);
		return "home/mypage";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
	    // 세션에서 로그인 상태를 제거
	    session.invalidate();
	    // 로그인 페이지로 리디렉션
	    return "redirect:/Buser/login";
	}

}
