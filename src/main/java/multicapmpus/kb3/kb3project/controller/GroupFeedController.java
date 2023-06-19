package multicapmpus.kb3.kb3project.controller;

import multicapmpus.kb3.kb3project.entity.Bcomment;
import multicapmpus.kb3.kb3project.entity.Bgroupmission;
import multicapmpus.kb3.kb3project.entity.extra.GroupWithLeaderName;
import multicapmpus.kb3.kb3project.entity.necessary.CommentWithUserName;
import multicapmpus.kb3.kb3project.entity.necessary.ConsumeForFeed;
import multicapmpus.kb3.kb3project.entity.necessary.ConsumeWithUserName;
import multicapmpus.kb3.kb3project.service.BgroupmissionService;
import multicapmpus.kb3.kb3project.service.CommentService;
import multicapmpus.kb3.kb3project.service.ConsumeService;
import multicapmpus.kb3.kb3project.service.GroupMissionService;
import multicapmpus.kb3.kb3project.service.GroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.List;

@Controller
public class GroupFeedController {

    private final GroupService groupService;
    private final GroupMissionService groupMissionService;
    private final ConsumeService consumeService;
    private final CommentService commentService;

    @Autowired
	private BgroupmissionService bgroupmissionservice;

    public GroupFeedController(GroupService groupService, GroupMissionService groupMissionService, ConsumeService consumeService, CommentService commentService) {
        this.groupService = groupService;
        this.groupMissionService = groupMissionService;
        this.consumeService = consumeService;
        this.commentService = commentService;
    }

    /*
        그룹 피드 화면
    */
    @GetMapping("/group/feed")
    public String feed(@RequestParam("groupNo") int groupNo, Model model,HttpSession session) {
    	session.setAttribute("g_no", groupNo);
    	
        GroupWithLeaderName group = groupService.getGroupByGroupNo(groupNo);
        model.addAttribute("groupName", group.getG_name());
		
        String groupMissionBanner = groupMissionService.getGroupMissionBanner(groupNo);
        System.out.println("groupMissionBanner=" + groupMissionBanner);
        model.addAttribute("groupMissionBanner", groupMissionBanner);

        int bgmNo = groupMissionService.getGroupMissionNoByGroupNo(groupNo);
        model.addAttribute("bgmNo", bgmNo);

        Bgroupmission bgmByNo = bgroupmissionservice.getBgmByNo(bgmNo);
        String bgm_name = bgmByNo.getBgm_name();
        model.addAttribute("name", bgm_name);
        
        
        
        // 그룹미션 넘버 jsp로 넘겨주기 (그룹미션 페이지로 이동시 필요함)
        
        List<ConsumeForFeed> consumes = consumeService.getConsumesForFeed(groupNo);
        System.out.println("consumes=" + consumes);

        HashMap<Integer, String> categoryMap = getCategoryMap();

        model.addAttribute("consumes", consumes);
        model.addAttribute("categoryMap", categoryMap);
        return "group/feed";
    }

    // 좋아요 수를 증가시키는 Ajax 요청을 처리하는 메서드 in 그룹피드
    @PostMapping("/consume/increaseLikeCount")
    @ResponseBody
    public void increaseLikeCount(@RequestParam("consumeNo") int consumeNo) {
        consumeService.increaseLike(consumeNo);
    }

    // 업데이트된 좋아요 수를 화면에 반영하기
    @GetMapping("/consume/getConsume")
    @ResponseBody
    public ConsumeWithUserName getConsume(@RequestParam("consumeNo") int consumeNo) {
        return consumeService.getConsumeByConsumeNo(consumeNo);
    }


    /*
        그룹피드 댓글 화면
     */
    @GetMapping("/group/feed/comment")
    //comment 이게 별로인듯
    public String comment(@RequestParam("consumeNo") int consumeNo, Model model, HttpServletRequest request) {

        // 세션 처리하기 추가
        HttpSession session = request.getSession();
        int groupNo = (int) session.getAttribute("g_no");
        GroupWithLeaderName group = groupService.getGroupByGroupNo(groupNo);
        String groupName = group.getG_name();
        model.addAttribute("groupName", groupName);

        ConsumeWithUserName consume = consumeService.getConsumeByConsumeNo(consumeNo);
        consume.setC_no(consumeNo);
        System.out.println("consume=" + consume);
        model.addAttribute("consume", consume);
        HashMap<Integer, String> categoryMap = getCategoryMap();
        model.addAttribute("categoryMap", categoryMap);

        // 댓글 조회
        List<CommentWithUserName> comments = commentService.getCommentsForConsumeNo(consumeNo);
        model.addAttribute("comments", comments);
        System.out.println("comments=" + comments);

        return "group/comment";
    }

    /*
    댓글 등록
     */
    @PostMapping("/group/feed/comment")
    public String createComment(@RequestParam("consumeNo") int consumeNo,
                                @RequestParam("inputComment") String content,
                                Model model, HttpServletRequest request) {

        // 세션 처리하기
        HttpSession session = request.getSession();
        
        int userNo = (int) session.getAttribute("user_no");
        int gNo = (int) session.getAttribute("g_no");
//        int userNo = 1;

        // 댓글 등록
        Bcomment comment = new Bcomment();
        comment.setUser_no(userNo);
        comment.setC_no(consumeNo);
        comment.setCmn_content(content);

        int result = commentService.createComment(comment);

        return "redirect:/group/feed/comment?consumeNo=" + consumeNo;
    }


    /*
        test
    */
    @GetMapping("/group/feedTest")
    public String feedTest(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        int userNo = (int) session.getAttribute("user_no");
        int g_no = (int) session.getAttribute("g_no");

        String groupMissionBanner = groupMissionService.getGroupMissionBanner(g_no);
        System.out.println("groupMissionBanner=" + groupMissionBanner);
        model.addAttribute("groupMissionBanner", groupMissionBanner);

        List<ConsumeWithUserName> consumes = consumeService.getConsumes(g_no);
        System.out.println("consumes=" + consumes);
        model.addAttribute("consumes", consumes);
        return "group/feed";
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
