package com.zxh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.zxh.entity.TestPaper;

public interface ITestPaperDao {

	@Delete("delete from testPaper where id = #{id}")
	int deleteById(String id);

	@SelectKey(keyProperty = "testPaper.id", resultType = String.class, before = true, statement = "select replace(uuid(), '-', '')")
	@Insert("insert into testPaper (id,name,state,type,startTime,endTime,publicTime,totalScore,passScore,`explain`,createTime) "
			+ "values (#{testPaper.id},#{testPaper.name},#{testPaper.state},#{testPaper.type},#{testPaper.startTime},#{testPaper.endTime},#{testPaper.publicTime},#{testPaper.totalScore},#{testPaper.passScore},#{testPaper.explain},#{testPaper.createTime})")
	@Options(keyProperty = "testPaper.id", useGeneratedKeys = true)
	int insert(@Param("testPaper") TestPaper testPaper);

	@Select("select * from testPaper where id = #{id}")
	TestPaper get( String id);

	@Update("update testPaper set name = #{name},state = #{state},type=#{type} where id = #{id}")
	int updateById(TestPaper testPaper);

	@Select("<script> SELECT * FROM testPaper WHERE 1=1 <if test='name!=null and name!=\"\"'> and name like '%${name}%'</if>"
			+ "<if test='state!=null and state!=\"\"'> and state = #{state}</if><if test='type!=null and type!=\"\"'> and type = #{type}</if>  order by createTime desc</script>")
	List<TestPaper> selectByCondition(@Param("name") String name, @Param("state") String state,
			@Param("type") String type);

	@Select("SELECT testPaper.* FROM userPaper INNER JOIN testPaper ON userPaper.paperId = testPaper.id WHERE userPaper.userId = #{userId}")
	List<TestPaper> selectByUser(String userId);

}
