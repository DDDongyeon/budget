package multicapmpus.kb3.kb3project.service;

import multicapmpus.kb3.kb3project.entity.Buser;

public interface BuserService {

	public Buser getBuserDetail(int u_no);
	public void create(String user_id,String user_pwd,String user_name,String user_nickname,String user_email);
	public boolean isUseridTaken(String id);
	public boolean authenticateUser(String id,String pwd);
	public int getBuserNo(String id);
}
