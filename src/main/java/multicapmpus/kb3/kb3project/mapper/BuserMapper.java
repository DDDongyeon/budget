package multicapmpus.kb3.kb3project.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import multicapmpus.kb3.kb3project.entity.Buser;

@Mapper
public interface BuserMapper {
	@Select("Select * from BUSER ORDER BY USER_NO DESC")
	public List<Buser> findAll();

	@Select("SELECT * FROM BUSER WHERE USER_NO= #{u_no}")
	Optional<Buser> findByUno(@Param("u_no") int u_no);

	@Insert("insert into BUSER (user_no, user_id, user_pwd, user_name, user_nickname, user_email) "
			+ "VALUES (USER_NO_SEQ.nextval,#{buser.user_id},#{buser.user_pwd},#{buser.user_name},#{buser.user_nickname},#{buser.user_email})")
	int save(@Param("buser") Buser buser);

	@Select("SELECT COUNT(*) FROM BUSER WHERE user_id = #{id}")
	int countByUserid(@Param("id") String id);

	@Select("SELECT * FROM BUSER WHERE user_id = #{id}")
	Buser getUserByUserid(@Param("id") String id);
	
	@Select("SELECT USER_NO FROM BUSER WHERE user_id=#{id}")
	int getUsernoByUserid(@Param("id") String id);
}
