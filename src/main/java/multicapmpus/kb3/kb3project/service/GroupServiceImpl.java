package multicapmpus.kb3.kb3project.service;

import lombok.extern.slf4j.Slf4j;
import multicapmpus.kb3.kb3project.entity.Bgroup;
import multicapmpus.kb3.kb3project.entity.necessary.GroupInfo;
import multicapmpus.kb3.kb3project.entity.extra.GroupWithLeaderName;
import multicapmpus.kb3.kb3project.entity.necessary.GroupWithMemberCount;
import multicapmpus.kb3.kb3project.mapper.GroupMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class GroupServiceImpl implements GroupService {

    private final GroupMapper groupMapper;

    @Autowired
    public GroupServiceImpl(GroupMapper groupMapper) {
        this.groupMapper = groupMapper;
    }

    @Override
    public int createGroup(Bgroup group) {
        int result = groupMapper.saveGroup(group);
        return result;
    }

    @Override
    public int getGroupNoByGname(String gName) {
        int result = groupMapper.selectGroupNoByGname(gName);
        return result;
    }

    @Override
    public GroupInfo getGroupInfo(int groupNo) {
        GroupInfo groupInfo = groupMapper.selectGroupInfo(groupNo);
        return groupInfo;
    }

    @Override
    public List<GroupWithMemberCount> getGroupsWithMemeberCount(int userNo) {
        List<GroupWithMemberCount> groupWithMemberCount = groupMapper.selectGroupsWithMemberCountByUserNo(userNo);
        return groupWithMemberCount;
    }

    @Override
    public List<Bgroup> getGroupList() {
        List<Bgroup> Bgroups = groupMapper.selectAll();
        return Bgroups;
    }

    @Override
    public List<Bgroup> getBySearchValue(String searchValue) {
        List<Bgroup> Bgroups = groupMapper.selectBySearchValue(searchValue);
        return Bgroups;
    }

    @Override
    public List<Bgroup> getGroupsByGtag(String gRequiredTag) {
        List<Bgroup> groupsByRequiredtag = groupMapper.selectByGtag(gRequiredTag);
        return groupsByRequiredtag;
    }

    @Override
    public int joinGroup(int userNo, int groupNo) {
        int result = groupMapper.insertUserGroup(userNo, groupNo);
        return result;
    }

    @Override
    public GroupWithLeaderName getGroupByGroupNo(int groupNo) {
        GroupWithLeaderName group = groupMapper.selectByGroupNo(groupNo);
        return group;
    }

    @Override  // 사용X
    public List<Bgroup> getGroupsByUserNo(int userNo) {
        List<Bgroup> userBgroups = groupMapper.selectGroupsByUserNo(userNo);
        return userBgroups;
    }

}
