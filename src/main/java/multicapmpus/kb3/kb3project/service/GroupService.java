package multicapmpus.kb3.kb3project.service;

import multicapmpus.kb3.kb3project.entity.Bgroup;
import multicapmpus.kb3.kb3project.entity.necessary.GroupInfo;
import multicapmpus.kb3.kb3project.entity.extra.GroupWithLeaderName;
import multicapmpus.kb3.kb3project.entity.necessary.GroupWithMemberCount;

import java.util.List;

public interface GroupService {

    public int createGroup(Bgroup group);  //그룹 만들기
    public int getGroupNoByGname(String gName);  //gName으로 gNo 가져오기

    public GroupInfo getGroupInfo(int groupNo);  //그룹정보 가져오기(그룹, 리더이름, 현재인원)

    public List<GroupWithMemberCount> getGroupsWithMemeberCount(int userNo);  //멤버가 가입한 모든 그룹(+총인원) 조회

    public List<Bgroup> getGroupsByGtag(String gRequiredTag);  //태그로 그룹 조회하기

    public List<Bgroup> getGroupList();  //모든 그룹 조회

    public List<Bgroup> getBySearchValue(String searchValue);  //검색어로 그룹 조회

    public int joinGroup(int userNo, int groupNo);  //userNo를 groupNo에 가입

    public List<Bgroup> getGroupsByUserNo(int userNo);  //회원의 모든 그룹 조회 - 사용X

    public GroupWithLeaderName getGroupByGroupNo(int groupNo);  //groupNo으로 그룹정보 조회 - 사용X

}
