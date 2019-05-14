package com.zxh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.zxh.entity.Subject;
import com.zxh.response.PaperSubjectResponse;

/**
 * 题目接口----主键自增
 * 
 * @author ZXH
 *
 */
public interface ISubjectDao {

	@Delete("delete from subject where id = #{id}")
	int deleteById(Integer id);

	
	@SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="subject.id", before=false, resultType=int.class)   
	@Insert("insert into subject (type,difficulty,state,stem,content,createTime) "
			+ "values (#{subject.type},#{subject.difficulty},#{subject.state},#{subject.stem},#{subject.content},#{subject.createTime})")
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
	int insert(@Param("subject") Subject subject);

	@Select("select * from subject where id = #{id}")
	Subject get(Integer id);

	@Update("update subject set type = #{type},difficulty = #{difficulty},state = #{state},stem = #{stem},content = #{content} where id = #{id}")
	int updateById(Subject subject);

	@Select("<script> SELECT * FROM subject WHERE 1=1 <if test='type!=null and type!=\"\"'> and type = #{type}</if>"
			+ "<if test='difficulty!=null and difficulty!=\"\"'> and difficulty = #{difficulty}</if>"
			+ "<if test='state!=null and state!=\"\"'> and state = #{state}</if> order by createTime desc</script>")
	List<Subject> selectByCondition(@Param("type") String type, @Param("difficulty") String difficulty,
			@Param("state") String state);

	@Select("<script> select count(*) from subject where 1 = 1 "
			+ "<if test='state!=null and state!=\"\"'>and state = #{state}</if></script>")
	Integer selectCount(@Param("state")String state);
	
	//随机获取数据集
	@Select("SELECT * FROM subject WHERE id >= ((SELECT MAX(id) FROM subject)-(SELECT MIN(id) FROM subject)) * RAND() + (SELECT MIN(id) FROM subject) ")
	List<Subject> selectByRandom();
	
	
	@Select("select id as subjectId,type as type,difficulty as difficulty,stem as stem,content as content from subject where id = #{id}")
	PaperSubjectResponse getByPaper(Integer id);

	@Select("select stem as zhuguanti from subject where type = '主观题'")
	String getSubject();

	
}
