package com.zxh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.zxh.entity.Answer;
import com.zxh.response.PaperAnswerResponse;

/**
 * 用户接口
 * 
 * @author ZXH
 *
 */
public interface IAnswerDao {

	@Delete("delete from answer where id = #{id}")
	int deleteById(String id);

	@Delete("delete from answer where subjectId = #{subjectId}")
	int deleteBySubjectId(Integer subjectId);

	@SelectKey(keyProperty = "answer.id", resultType = String.class, before = true, statement = "select replace(uuid(), '-', '')")
	@Insert("insert into answer (id,subjectId,`option`,content,flag,createTime) "
			+ "values (#{answer.id},#{answer.subjectId},#{answer.option},#{answer.content},#{answer.flag},#{answer.createTime})")
	@Options(keyProperty = "answer.id", useGeneratedKeys = true)
	int insert(@Param("answer") Answer answer);

	@Select("select * from answer where id = #{id}")
	Answer get(String id);

	@Update("update answer set subjectId = #{subjectId},option = #{option},content = #{content},flag = #{flag} where id = #{id}")
	int updateById(Answer answer);

	@Select("<script> SELECT * FROM answer WHERE 1=1 <if test='subjectId!=null'> and subjectId = #{subjectId}</if>"
			+ "order by option</script>")
	List<Answer> selectByCondition(@Param("subjectId") Integer subjectId);

	@Select("<script> SELECT id as answerId,`option` as `option`,content as content,flag as flag FROM answer WHERE 1=1 <if test='subjectId!=null'> and subjectId = #{subjectId}</if>"
			+ "order by `option`</script>")
	List<PaperAnswerResponse> listByPaperId(@Param("subjectId") Integer subjectId);

	@Select("select * from answer where subjectId = #{subjectId} and option = #{option} and flag = true")
	Answer getByCorrect(@Param("subjectId") Integer subjectId, @Param("option") String option);

}
