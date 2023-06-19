package multicapmpus.kb3.kb3project.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import multicapmpus.kb3.kb3project.DataNotFoundException;
import multicapmpus.kb3.kb3project.entity.Buser;
import multicapmpus.kb3.kb3project.mapper.BuserMapper;

import lombok.RequiredArgsConstructor;


@Service
public class BuserServiceImpl implements BuserService {

	private final BuserMapper bMapper;

	public BuserServiceImpl(BuserMapper bMapper) {
		this.bMapper = bMapper;
	}

	@Override
	public Buser getBuserDetail(int u_no) {
		Optional<Buser> buser=this.bMapper.findByUno(u_no);
		if (buser.isPresent()) {
			return buser.get();
		} else {
			throw new DataNotFoundException("Not Found");
		}
		//Buser buser=bMapper.findByUno(u_no);
	//	return buser;
	}

	@Override
	public void create(String user_id, String user_pwd, String user_name, String user_nickname, String user_email) {
		Buser buser = new Buser();
		buser.setUser_email(user_email);
		buser.setUser_id(user_id);
		buser.setUser_name(user_name);
		buser.setUser_nickname(user_nickname);
		buser.setUser_pwd(user_pwd);
		this.bMapper.save(buser);
	}

	@Override
	public boolean isUseridTaken(String id) {
		int count = bMapper.countByUserid(id);
		return count > 0;
	}

	@Override
	public boolean authenticateUser(String id, String pwd) {
		Buser buser=bMapper.getUserByUserid(id);
		
		if (buser != null && buser.getUser_pwd().equals(pwd)) {
            return true;
        }
        return false;
	}

	@Override
	public int getBuserNo(String id) {
		int user_no=bMapper.getUsernoByUserid(id);
		
		return user_no;
	}

}
