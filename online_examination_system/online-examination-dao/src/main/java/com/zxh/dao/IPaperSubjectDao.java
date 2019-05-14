package com.zxh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.zxh.entity.PaperSubject;

/**
 * 试卷-试题中间表
 * @author ZXH
 *
 */
public interface IPaperSubjectDao {

	@Delete("delete from paperSubject where id = #{id}")
	int deleteById(String id);
	
	
	@Delete("delete from paperSubject where paperId = #{paperId}")
	int deleteByPaperId(String paperId);

	@SelectKey(keyProperty = "paperSubject.id", resultType = String.class, before = true, statement = "select replace(uuid(), '-', '')")
	@Insert("insert into paperSubject (id,paperId,subjectId,createTime) "
			+ "values (#{paperSubject.id},#{paperSubject.paperId},#{paperSubject.subjectId},#{paperSubject.createTime})")
	@Options(keyProperty = "paperSubject.id", useGeneratedKeys = true)
	int insert(@Param("paperSubject") PaperSubject paperSubject);

	@Select("select * from paperSubject where id = #{id}")
	PaperSubject get(String id);

	@Update("update paperSubject set paperId = #{paperId},subjectId = #{subjectId} where id = #{id}")
	int updateById(PaperSubject paperSubject);

	@Select("<script> SELECT * FROM paperSubject WHERE 1=1 <if test='paperId!=null and paperId!=\"\"'> and paperId = #{paperId}</if> order by createTime asc</script>")
	List<PaperSubject> selectByCondition(@Param("paperId") String paperId);
}
