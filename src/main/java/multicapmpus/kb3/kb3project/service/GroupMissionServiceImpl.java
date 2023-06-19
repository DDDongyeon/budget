package multicapmpus.kb3.kb3project.service;

import multicapmpus.kb3.kb3project.entity.Bgroupmission;
import multicapmpus.kb3.kb3project.mapper.GroupMissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class GroupMissionServiceImpl implements GroupMissionService {

    private final GroupMissionMapper groupMissionMapper;

    @Autowired
    public GroupMissionServiceImpl(GroupMissionMapper groupMissionMapper) {
        this.groupMissionMapper = groupMissionMapper;
    }


    @Override
    public String getGroupMissionBanner(int gNo) {
        Bgroupmission bGroupMission = groupMissionMapper.selectOne(gNo);

        if (bGroupMission == null) {
            return "현재 등록된 미션이 없습니다!";
        }

        LocalDate gmStartDate = bGroupMission.getBgm_start();
        LocalDate gmEndDate = bGroupMission.getBgm_end();
        int gmGoal = bGroupMission.getBgm_goal();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
        String formattedStartDate = gmStartDate.format(formatter);
        String formattedEndDate = gmEndDate.format(formatter);

        String groupMissionName = formattedStartDate + " ~ " + formattedEndDate + "<br>" + gmGoal + "원만 소비하기";
        return groupMissionName;
    }

    @Override
    public Integer getGroupMissionNoByGroupNo(int gNo) {
        Integer bgmNo = groupMissionMapper.selectBgmNoByGroupNo(gNo);

        if (bgmNo == null) {
            return 0;  //ㄱㅊ?
        }

        return bgmNo;
    }
}
