package multicapmpus.kb3.kb3project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import multicapmpus.kb3.kb3project.entity.Bgroup;
import multicapmpus.kb3.kb3project.entity.Bgroupmission;
import multicapmpus.kb3.kb3project.entity.BgroupmissionInfo;
import multicapmpus.kb3.kb3project.mapper.BgroupMapper;
import multicapmpus.kb3.kb3project.mapper.BgroupmissionMapper;
@Service
public class BgroupmissionServiceImpl implements BgroupmissionService {
	
	private final BgroupmissionMapper bgroupmissionMapper;
	
	@Autowired
    public BgroupmissionServiceImpl(BgroupmissionMapper bgroupmissionMapper) {
        this.bgroupmissionMapper = bgroupmissionMapper;
    }

	@Override
	public Bgroupmission getBgmByNo(int bgmNo) {
		Bgroupmission bgm = bgroupmissionMapper.getBgmByNo(bgmNo);
		return bgm;
	}

	

	@Override
	public int deleteBgroupmission(int bgmNo) {
		int bgm = bgroupmissionMapper.delete(bgmNo);
		return bgm;
	}

	@Override
	public List<Bgroupmission> getAll() {
		List<Bgroupmission> bgm = bgroupmissionMapper.getBgroupmissionList();
		return bgm;
	}

	@Override
	public List<Integer> getUserNoList(int bgmNo) {
	    return bgroupmissionMapper.getUserNoList(bgmNo);
	}

//	@Override
//	public List<BgroupmissionInfo> getUserCList(int bgmNo) {
//	    return bgroupmissionMapper.getUserCList(bgmNo);
//	}

	@Override
	public List<Integer> getUserCList(int bgmNo) {
	    return bgroupmissionMapper.getUserCList(bgmNo);
	}

	@Override
	public List<Integer> getUserCListDate(int bgmNo) {
		return bgroupmissionMapper.getUserCListDate(bgmNo);
	}
	
	@Override
	public List<String> getUserCListDateUserNo(int bgmNo) {
		return bgroupmissionMapper.getUserCListDateUserNo(bgmNo);
	}

	@Override
	public List<Integer> getUserNicknameByUserNo(int userNo) {
		return bgroupmissionMapper.getUserNicknameByUserNo(userNo);
	}

	@Override
	public int saveBgroupmission(int gNo, Bgroupmission bgm) {
		return bgroupmissionMapper.save(gNo, bgm);
		
	}







}
