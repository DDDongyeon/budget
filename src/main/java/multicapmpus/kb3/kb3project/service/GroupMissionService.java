package multicapmpus.kb3.kb3project.service;

public interface GroupMissionService {

    /*
    그룹미션 배너 가져오기
     */
    public String getGroupMissionBanner(int g_no);

    /*
    그룹의 그룹미션 번호 가져오기
     */
    public Integer getGroupMissionNoByGroupNo(int gNo);

}
