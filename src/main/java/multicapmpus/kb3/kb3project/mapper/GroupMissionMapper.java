package multicapmpus.kb3.kb3project.mapper;

import multicapmpus.kb3.kb3project.entity.Bgroupmission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface GroupMissionMapper {

    /*
    그룹 미션 조회
     */
    @Select("select * from bgroupmission where g_no = #{gNo}")
    public Bgroupmission selectOne(@Param("gNo") int gNo);

    /*
    그룹no으로 그룹미션no 조회
     */
    @Select("SELECT bgm_no FROM Bgroupmission WHERE g_no = #{groupNo}")
    public Integer selectBgmNoByGroupNo(@Param("groupNo") int groupNo);
}

