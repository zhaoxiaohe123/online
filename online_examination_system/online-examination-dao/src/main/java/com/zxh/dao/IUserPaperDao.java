package com.zxh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.zxh.entity.UserPaper;
import com.zxh.response.ScoreResponse;

public interface IUserPaperDao {

	@Delete("delete from userPaper where id = #{id}")
	int deleteById(String id);

	@SelectKey(keyProperty = "userPaper.id", resultType = String.class, before = true, statement = "select replace(uuid(), '-', '')")
	@Insert("insert into userPaper (id,name,userId,paperId,startTime,endTime,type,totalScore,actualScore,createTime) "
			+ "values (#{userPaper.id},#{userPaper.name},#{userPaper.userId},#{userPaper.paperId},#{userPaper.startTime},#{userPaper.endTime},#{userPaper.type},#{userPaper.totalScore},#{userPaper.actualScore},#{userPaper.createTime})")
	@Options(keyProperty = "userPaper.id", useGeneratedKeys = true)
	int insert(@Param("userPaper") UserPaper userPaper);

	@Select("select * from userPaper where id = #{id}")
	UserPaper get(String id);

	@Update("update userPaper set name = #{name},paperId = #{paperId},startTime = #{startTime},endTime = #{endTime},type = #{type},totalScore = #{totalScore},actualScore=#{actualScore} where id = #{id}")
	int updateById(UserPaper userPaper);

	@Select("<script> SELECT * FROM userPaper WHERE 1=1  <if test='paperId!=null and paperId!=\"\"'> and  paperId = #{paperId}</if>"
			+ "<if test='name!=null and name!=\"\"'> and name like '%${paperId}%'</if> <if test='type!=null and type!=\"\"'> and type = #{type}</if>"
			+ "<if test='userId!=null and userId!=\"\"'> and userId = #{userId}</if> order by createTime desc</script>")
	List<UserPaper> selectByCondition(@Param("paperId") String paperId, @Param("name") String name,
			@Param("type") String type, @Param("userId") String userId);

	@Select("SELECT MAX(actualScore) AS maxScore,MIN(actualScore) AS minScore,AVG(actualScore) AS avgScore FROM userPaper WHERE paperId = #{paperId}")
	ScoreResponse selectByPaperId(String paperId);

	@Select("<script> SELECT COUNT(*) FROM userPaper WHERE 1=1  <if test='paperId!=null and paperId!=\"\"'> and paperId = #{paperId} </if> "
			+ "<if test='passScore!=null'> AND actualScore &gt;= #{passScore} </if></script>")
	Integer selectByCount(@Param("paperId") String paperId, @Param("passScore") Integer passScore);

	@Delete("delete from userPaper where paperId = #{paperId}")
	void deleteByPaperId(String paperId);
}
