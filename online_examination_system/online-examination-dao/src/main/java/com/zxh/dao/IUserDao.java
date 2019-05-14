package com.zxh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.zxh.entity.User;

/**
 * 用户接口
 * 
 * @author ZXH
 *
 */
public interface IUserDao {

	@Delete("delete from user where id = #{id}")
	int deleteById(String id);

	@SelectKey(keyProperty = "user.id", resultType = String.class, before = true, statement = "select replace(uuid(), '-', '')")
	@Insert("insert into user (id,account,passWord,role,createTime) "
			+ "values (#{user.id},#{user.account},#{user.passWord},#{user.role},#{user.createTime})")
	@Options(keyProperty = "user.id", useGeneratedKeys = true)
	int insert(@Param("user") User user);

	@Select("select * from user where id = #{id}")
	User get(String id);

	@Select("select * from user where account = #{account}")
	User selectByAccount(String account);

	@Update("update user set passWord = #{passWord},role = #{role},account = #{account} where id = #{id}")
	int updateById(User user);

	@Select("<script> SELECT * FROM user WHERE 1=1 <if test='role!=null and role!=\"\"'> and role = #{role}</if>"
			+ "order by createTime</script>")
	List<User> selectByCondition(@Param("role") String role);

}
