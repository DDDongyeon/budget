package multicapmpus.kb3.kb3project.service;

import java.util.List;

import multicapmpus.kb3.kb3project.entity.Bgroup;

public interface BgroupService {

    Bgroup getBgroupByNo(int gNo);

    int saveBgroup(Bgroup bgroup);

    int deleteBgroup(int gNo);
    
    int getgNoByUserNo(int userNo);
    
    List<String> getGNamesByUserNo(int userNo);
    
    List<Integer> getGNosByUserNo(int userNo);

}

