package multicapmpus.kb3.kb3project.controller;

import lombok.extern.slf4j.Slf4j;
import multicapmpus.kb3.kb3project.entity.Bgroup;
import multicapmpus.kb3.kb3project.entity.necessary.GroupWithMemberCount;
import multicapmpus.kb3.kb3project.service.ConsumeService;
import multicapmpus.kb3.kb3project.service.GroupMissionService;
import multicapmpus.kb3.kb3project.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

    @Controller
    @Slf4j
    public class GroupHomeController {

        private final GroupService groupService;
        private final GroupMissionService groupMissionService;
        private final ConsumeService consumeService;

        @Autowired
        public GroupHomeController(GroupService groupService, GroupMissionService groupMissionService, ConsumeService consumeService) {
            this.groupService = groupService;
            this.groupMissionService = groupMissionService;
            this.consumeService = consumeService;
        }

        /*
        洹몃９ 硫붿씤 �솕硫�
         */
        @GetMapping("/group")
        public String main(Model model, HttpServletRequest request) {
            // 세션에 담긴 회원no가져오기
        HttpSession session = request.getSession();
        int userNo = (int) session.getAttribute("user_no");
//            int userNo = 1;

            // 회원이 가입한 그룹들 (+현재 인원)
            List<GroupWithMemberCount> groupsWithMemberCount = groupService.getGroupsWithMemeberCount(userNo);
            System.out.println("groupsWithMemberCount=" + groupsWithMemberCount);
            model.addAttribute("groupsWithMemberCount", groupsWithMemberCount);
            List<Bgroup> groupList = groupService.getGroupList();
            System.out.println("groups=" + groupList);
            model.addAttribute("groupList", groupList);

            return "group/home";  // group/main�쑝濡� 由щ떎�씠�젆�듃
        }

        /*
        寃��깋�맂 洹몃９
         */
        @GetMapping("/group/search")
        public String main(@RequestParam("q") String searchValue, Model model, HttpServletRequest request) {

            List<Bgroup> groupsBySearch = groupService.getBySearchValue(searchValue);
            System.out.println("groupsBySearch=" + groupsBySearch);
            model.addAttribute("groupsBySearch", groupsBySearch);

            return "group/search";
        }

        /*
        洹몃９ 留뚮뱾湲� �럹�씠吏�濡� �씠�룞
         */
        @GetMapping("/group/create")
        private String createbgroup(Model model) {
            return "group/createGroup";
        }

        /*
        洹몃９ 留뚮뱾湲� 泥섎━ �썑 洹몃９�솃 �럹�씠吏�濡� �씠�룞
         */
        @PostMapping("/group/create")
        public String createBgroup(HttpSession session, @RequestParam("g_name") String gName,
                                   @RequestParam("g_maxpeople") int gPeople,
                                   @RequestParam("g_content") String gContent,
                                   @RequestParam("g_tag") String gTag,
                                   @RequestParam("g_rtag") String gRTag) {
            // �꽭�뀡�뿉 �떞湲� �쉶�썝no媛��졇�삤湲�
        	
        	 int userNo = (int) session.getAttribute("user_no");
//        HttpSession session = request.getSession();
//        int userNo = (int) session.getAttribute("user_no");
//        int userNo = 1;

            Bgroup group = new Bgroup();
            group.setG_name(gName);
            group.setG_leader(userNo);
            group.setG_maxpeople(gPeople);
            group.setG_requiredTag(gRTag);
            group.setG_tag(gTag);
            group.setG_content(gContent);
            groupService.createGroup(group);
            System.out.println("생성완료");
            
            
            // �깮�꽦�맂 洹몃９�쓽 groupNo瑜� 諛쏆븘���꽌, user_group�뀒�씠釉붿뿉 userNo�� groupNo瑜� �궫�엯�빐二쇨린
            int groupNo = groupService.getGroupNoByGname(gName);
            groupService.joinGroup(userNo, groupNo);
            System.out.println("조인완료");
            return "redirect:/group";
        }

        /*
        g_requiredTag濡� 洹몃９ 議고쉶�븯湲�
         */
        @GetMapping("/group/list")
        public String showGroupsByGTag(@RequestParam("tag") String selectedTag, Model model, HttpServletRequest request) {
            // �꽭�뀡�뿉 �떞湲� �쉶�썝no媛��졇�삤湲�
        HttpSession session = request.getSession();
        	int userNo = (int) session.getAttribute("user_no");
           

            // �쉶�썝�씠 媛��엯�븳 洹몃９�뱾 (+�쁽�옱 �씤�썝)
            List<GroupWithMemberCount> groupsWithMemberCount = groupService.getGroupsWithMemeberCount(userNo);
            System.out.println("groupsWithMemberCount=" + groupsWithMemberCount);
            model.addAttribute("groupsWithMemberCount", groupsWithMemberCount);

            // �꽑�깮�맂 �깭洹몄쓽 洹몃９�뱾
            List<Bgroup> groupsByGtag = groupService.getGroupsByGtag(selectedTag);
            System.out.println("groupsByGtag=" + groupsByGtag);
            model.addAttribute("groupsByGtag", groupsByGtag);

            // �꽑�깮�맂 �깭洹� model�뿉 �떞�븘二쇨린
            model.addAttribute("selectedTag", selectedTag);

            return "group/homeByGtag";
        }


        /*
        test
         */
        @GetMapping("/groupList")
        public String home(Model model) {
            List<Bgroup> BgroupList = groupService.getGroupList();
            System.out.println("groupList=" + BgroupList);
            model.addAttribute("groupList", BgroupList);
            return "test/groupList";
        }

}
