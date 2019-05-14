package com.zxh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.zxh.entity.UserPaperDetail;

public interface IUserPaperDetailDao {

	@Delete("delete from userPaperDetail where id = #{id}")
	int deleteById(String id);

	@SelectKey(keyProperty = "userPaperDetail.id", resultType = String.class, before = true, statement = "select replace(uuid(), '-', '')")
	@Insert("insert into userPaperDetail (id,userPaperId,subjectId,answer,score,createTime) "
			+ "values (#{userPaperDetail.id},#{userPaperDetail.userPaperId},#{userPaperDetail.subjectId},#{userPaperDetail.answer},#{userPaperDetail.score},#{userPaperDetail.createTime})")
	@Options(keyProperty = "userPaperDetail.id", useGeneratedKeys = true)
	int insert(@Param("userPaperDetail") UserPaperDetail userPaperDetail);

	@Select("select * from userPaperDetail where id = #{id}")
	UserPaperDetail get(String id);

	@Update("update userPaperDetail set userPaperId = #{userPaperId},subjectId = #{subjectId},answer = #{answer},score = #{score} where id = #{id}")
	int updateById(UserPaperDetail userPaperDetail);

	@Select("<script> SELECT * FROM userPaperDetail WHERE 1=1 <if test='userPaperId!=null and userPaperId!=\"\"'> and userPaperId = #{userPaperId}</if>"
			+ "<if test='subjectId!=null and subjectId!=\"\"'> and subjectId = #{subjectId}</if>order by createTime</script>")
	List<UserPaperDetail> selectByCondition(@Param("role") String role);

	@Select("select SUM(score) from userPaperDetail where userPaperId = #{userPaperId}")
	Integer selectUserIdScore(String userPaperId);

	@Select("select * from userPaperDetail ")
	UserPaperDetail getAll();

	@Update("update userPaperDetail set score = #{score} where id = #{id}")
	void updatescore(UserPaperDetail userPaperDetail);



}
