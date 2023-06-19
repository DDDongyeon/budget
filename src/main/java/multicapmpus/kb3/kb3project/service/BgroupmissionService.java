package multicapmpus.kb3.kb3project.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import multicapmpus.kb3.kb3project.entity.Bgroup;
import multicapmpus.kb3.kb3project.entity.Bgroupmission;
import multicapmpus.kb3.kb3project.entity.BgroupmissionInfo;

public interface BgroupmissionService {

    Bgroupmission getBgmByNo(int bgmNo);

    List<Bgroupmission> getAll();
    
    int saveBgroupmission(int gNo,Bgroupmission bgm);

    int deleteBgroupmission(int bgmNo);
    
    List<Integer> getUserNoList(int bgmNo);
    
    List<Integer> getUserCList(int bgmNo);
    
    List<Integer> getUserCListDate(int bgmNo);

    List<String> getUserCListDateUserNo(int bgmNo);

	List<Integer> getUserNicknameByUserNo(int userNo);
	
	
    
}

