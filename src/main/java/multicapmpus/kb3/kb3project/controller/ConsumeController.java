package multicapmpus.kb3.kb3project.controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ch.qos.logback.core.Context;
import multicapmpus.kb3.kb3project.entity.Consume;
import multicapmpus.kb3.kb3project.entity.ConsumePlusCategory;
import multicapmpus.kb3.kb3project.entity.GroupConsume;
import multicapmpus.kb3.kb3project.mapper.ConsumeMapper;
import multicapmpus.kb3.kb3project.service.ConsumeService;

import multicapmpus.kb3.kb3project.service.GroupConsumeService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.RequiredArgsConstructor;

@RequestMapping("/consume")
//@RequiredArgsConstructor
@Controller
public class ConsumeController {

	private final ConsumeService csmService;
	private Map<Integer, String> categoryMap = new HashMap<>();
	
	
	public ConsumeController(ConsumeService csmService, ConsumeMapper csmMapper) {
		this.csmService = csmService;
		this.csmMapper = csmMapper;
	      categoryMap.put(1, "식비");
	      categoryMap.put(2, "카페/간식");
	      categoryMap.put(3, "술/유흥");
	      categoryMap.put(4, "생활");
	      categoryMap.put(5, "패션쇼핑");
	      categoryMap.put(6, "뷰티/미용");
	      categoryMap.put(7, "교통비");
	      categoryMap.put(8, "주거비");
	      categoryMap.put(9, "의료/건강");
	      categoryMap.put(10, "문화");
	      categoryMap.put(11, "금융");
	      categoryMap.put(12, "여행/숙박");
	      categoryMap.put(13, "교육/학습");
	      categoryMap.put(14, "가족");
	      categoryMap.put(15, "반려동물");
	      categoryMap.put(16, "경조사/선물");
	      categoryMap.put(17, "멍청비용");
	      categoryMap.put(18, "기타");

	}

	@GetMapping("/list")
	public String list(Model model) {
		List<Consume> csmList = this.csmService.getConsumeList();
		model.addAttribute("csmList", csmList);
		return "consume/consume_list";
	}

	@GetMapping(value = "/detail/{c_no}")
	public String detail(Model model, @PathVariable("c_no") Integer c_no) {
		Consume csm = this.csmService.getConsumeDetail(c_no);
		model.addAttribute("csm", csm);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date = csm.getC_date().format(formatter);

		// String csm_date_modify = date.substring(0, 10); //�떆媛� �젙蹂� �젣嫄�
		// String csm_date_modify = csm.getC_date().substring(0, 10); //�떆媛� �젙蹂� �젣嫄�
//		model.addAttribute("csm_date_modify", csm_date_modify); //�궇吏쒕쭔 �꽆寃⑥＜湲�
		//model.addAttribute("csm_date_modify", date); // �궇吏쒕쭔 �꽆寃⑥＜湲�
		model.addAttribute("categoryMap", categoryMap); // 移댄뀒怨좊━ 留� �꽆寃⑥＜湲�
		
		String[] dateParts = date.split("-");
		int year = Integer.parseInt(dateParts[0]);
		int month = Integer.parseInt(dateParts[1]);
		int day = Integer.parseInt(dateParts[2]);

		// 월과 일이 1자리인 경우 앞에 0을 추가
		String monthStr = (month < 10) ? String.valueOf(month) : String.format("%02d", month);
		String dayStr = (day < 10) ? String.valueOf(day) : String.format("%02d", day);
		model.addAttribute("year", year);
		model.addAttribute("month", monthStr);
		model.addAttribute("day", dayStr);
		
		return "consume/consume_detail";
	}

	@GetMapping(value = "/list/{c_date}")
	// @ResponseBody
	public String dateList(Model model, @PathVariable("c_date") String c_date, HttpSession session) throws Exception {

		if (session.getAttribute("user_no") == null) {
			return "redirect:/Buser/login";
		}
		List<Consume> csmList = csmService.getConsumeListByDate(c_date, session, model);
		model.addAttribute("csmList", csmList);
		model.addAttribute("c_date", c_date);
		model.addAttribute("categoryMap", categoryMap);
		///////////////////
		String[] dateParts = c_date.split("-");
		int year = Integer.parseInt(dateParts[0]);
		int month = Integer.parseInt(dateParts[1]);
		int day = Integer.parseInt(dateParts[2]);

		// 월과 일이 1자리인 경우 앞에 0을 추가
		String monthStr = (month < 10) ? String.valueOf(month) : String.format("%02d", month);
		String dayStr = (day < 10) ? String.valueOf(day) : String.format("%02d", day);
		model.addAttribute("year", year);
		model.addAttribute("month", monthStr);
		model.addAttribute("day", dayStr);
		///////////////////
//		for (Consume csm : csmList) {
//			String csm_date_modify = csm.getC_date().substring(0, 10);
//			csm.setC_date(csm_date_modify);
//		
//			System.out.println(csm_date_modify);
//		}
		
		
		return "consume/consume_date";

	}

	@GetMapping("/create")
	public String create() {
		return "consume/consume_form";
	}

	@PostMapping("/create")
	public String create(@RequestParam String date, @RequestParam int amount, @RequestParam int category,
			@RequestParam String memo, HttpSession session, @RequestParam MultipartFile photo) {
		
		String photo_path="none";
		if (!photo.isEmpty()) {
			UUID uuid = UUID.randomUUID();
			String uuidString = uuid.toString();
			String fileName = uuidString+ "_" + photo.getOriginalFilename();
			String filePath = "/Users/shinminjoo/Desktop/budget/src/main/resources/static/jpg/" + fileName;

			try {
				File dest = new File(filePath);
				photo.transferTo(dest);
			} catch (IOException e) {
				e.printStackTrace();
			}
				
			photo_path= fileName;
		}

		//this.csmService.create(date, amount, category, memo, photo_path, session);
		this.csmService.create(date, amount, category, memo, photo_path, session);
		LocalDate now = (LocalDate) session.getAttribute("loginDate");
		// System.out.println(now.toString());
		if (now != null)
			return "redirect:/hMyCalendar?year=" + now.getYear() + "&month=" + now.getMonthValue() + "&day="
					+ now.getDayOfMonth();
		return "redirect:/Buser/login";
	}

	private final ConsumeMapper csmMapper;

	@Autowired
	private GroupConsumeService groupservice;

	@GetMapping("/grouplist/{date}")
	public String grouplist(@PathVariable("date") String date, HttpServletRequest request, Model model) {
	    int gNo = (int) request.getSession().getAttribute("g_no");
	    model.addAttribute("g_no", gNo);

	    List<Integer> totalmoney = csmMapper.getTotalMoneyList(gNo, date);
	    List<String> usernick = csmMapper.getUserNicknames(gNo, date);

	    model.addAttribute("membercs", totalmoney);
	    model.addAttribute("member", usernick);

	    LocalDate parsedDate = LocalDate.parse(date);
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
	    String formattedDate = parsedDate.format(formatter);

	    model.addAttribute("parsedDate", formattedDate);

	    List<GroupConsume> groupConsumeByDate = groupservice.getGroupConsumeByDate(gNo, date);

	    model.addAttribute("list", groupConsumeByDate);

	    List<String> consumeList = new ArrayList<>();
	    Map<String, List<GroupConsume>> consumeMap = new HashMap<>();

	    for (GroupConsume consume : groupConsumeByDate) {
	        String nickname = consume.getUser_nickname();
	        if (!consumeList.contains(nickname)) {
	            consumeList.add(nickname);
	        }
	        if (!consumeMap.containsKey(nickname)) {
	            consumeMap.put(nickname, new ArrayList<>());
	        }
	        consumeMap.get(nickname).add(consume);
	    }

	    model.addAttribute("consumeList", consumeList);
	    model.addAttribute("consumeMap", consumeMap);

	    // Adding category mapping
	    HashMap<Integer, String> categoryMap = getCategoryMap();
	    for (GroupConsume consume : groupConsumeByDate) {
	        int categoryId = consume.getC_categoryId();
	        String category = categoryMap.get(categoryId);
	        consume.setC_category(category);
	    }

	    return "consume/grouplist";
	}

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
