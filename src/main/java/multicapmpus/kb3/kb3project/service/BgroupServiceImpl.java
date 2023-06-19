package multicapmpus.kb3.kb3project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import multicapmpus.kb3.kb3project.entity.Bgroup;
import multicapmpus.kb3.kb3project.mapper.BgroupMapper;

@Service
public class BgroupServiceImpl implements BgroupService {
	
	private final BgroupMapper bgroupMapper;
	
	@Autowired
    public BgroupServiceImpl(BgroupMapper bgroupMapper) {
        this.bgroupMapper = bgroupMapper;
    }

	@Override
	public Bgroup getBgroupByNo(int gNo) {
		Bgroup group = bgroupMapper.getBgroupById(gNo);
		return group;
	}

	@Override
	public int saveBgroup(Bgroup bgroup) {
		int group = bgroupMapper.save(bgroup);
		return group;
	}

	@Override
	public int deleteBgroup(int gNo) {
		int group = bgroupMapper.delete(gNo);
		return group;
	}

	@Override
	public int getgNoByUserNo(int userNo) {
	    return bgroupMapper.getgNoByUserNo(userNo);
	}
	
	@Override
    public List<String> getGNamesByUserNo(int userNo) {
        return bgroupMapper.getGNamesByUserNo(userNo);
    }

	@Override
	public List<Integer> getGNosByUserNo(int userNo) {
		return bgroupMapper.getGNosByUserNo(userNo);
	}


}
