package mybatis.simple.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;

import mybatis.simple.model.SysRole;
import mybatis.simple.model.SysUser;

public interface UserMapper {
	/**
	 * 根据用户id查询用户信息
	 * 
	 * @param id
	 * @return
	 */
	@Results(id="userResultMap", value={
		@Result( property="id", column="id" ,id=true),
		@Result( property="userName", column="user_name" ),
		@Result( property="userPassword" ,column="user_password" ),
		@Result( property="userEmail", column="user_email" ),
		@Result( property="userInfo" ,column="user_info" ),
		@Result( property="headImg" ,column="head_img" , jdbcType=JdbcType.BLOB ),
		@Result( property="createTime" ,column="create_time" ,jdbcType=JdbcType.TIMESTAMP )
	})
	//@Select({"select id,user_name userName,user_password userPassword,user_email userEmail,user_info userInfo,head_img headImg,create_time createTime from sys_user where id = #{id}"})
	@Select({"select * from sys_user where id = #{id}"})
	public SysUser selectById(Long id);

	/**
	 * 查询所有用户信息
	 * 
	 * @return
	 */
	@ResultMap("userResultMap")
	@Select({"select * from sys_user"})
	public List<SysUser> selectAll();

	/**
	 * 查询用户所拥有的角色
	 * 
	 * @param userId
	 * @return
	 */
	@Select({"select r.id,r.role_name roleName,r.enabled,r.create_by createBy,r.create_time createTime,u.user_name as 'user.userName' from sys_user u inner join sys_user_role ur on u.id=ur.user_id inner join sys_role r on ur.role_id=r.id where u.id = #{userId}"})
	public List<SysRole> selectRoleByUserId(Long userId);

	/**
	 * 保存新用户信息
	 * 
	 * @param sysUser
	 * @return
	 */
	@Insert({"INSERT INTO sys_user (id,user_name, user_password,user_email, user_info, head_img, create_time) VALUES(#{id},#{userName},#{userPassword},#{userEmail},#{userInfo},#{headImg, jdbcType=BLOB},#{createTime,jdbcType=TIMESTAMP})"})
	public int insert(SysUser sysUser);

	/**
	 * 保存新用户信息，并返回主键
	 * 
	 * @param sysUser
	 * @return
	 */
	@Insert({"INSERT INTO sys_user (user_name, user_password,user_email, user_info,head_img, create_time)VALUES (#{userName},#{userPassword},#{userEmail},#{userInfo},#{headImg,jdbcType=BLOB},#{createTime,jdbcType=TIMESTAMP})"})
	@Options(useGeneratedKeys=true,keyProperty="id")
	public int insert2(SysUser sysUser);

	/**
	 * 保存新用户信息，并返回主键
	 * 
	 * @param sysUser
	 * @return
	 */
	@Insert({"INSERT INTO sys_user (id,user_name, user_password,user_email,user_info, head_img, create_time)VALUES(#{id},#{userName},#{userPassword},#{userEmail},#{userInfo},#{headImg, jdbcType=BLOB},#{createTime,jdbcType=TIMESTAMP})"})
	@SelectKey(statement="SELECT LAST_INSERT_ID()",
				keyProperty="id",
				resultType=Long.class,
				before=false)
	public int insert3(SysUser sysUser);

	/**
	 * 根据用户id，修改用户信息
	 * 
	 * @param sysUser
	 * @return
	 */
	@Update({"update sys_user set user_name = #{userName},user_password = #{userPassword},user_email = #{userEmail}, user_info = #{userInfo}, head_img = #{headImg , jdbcType=BLOB}, create_time = #{createTime,jdbcType=TIMESTAMP} where id = #{id}"})
	public int updateById(SysUser sysUser);

	/**
	 * 根据用户id，删除用户信息
	 * 
	 * @param id
	 * @return
	 */
	@Delete({"delete from sys_user where id = #{id}"})
	public int deleteById(Long id);

	/**
	 * 根据用户id和角色enable状态获取用户的角色
	 * 
	 * @param userId
	 * @param enabled
	 * @return
	 */
	
	@Select({"select r.id,r.role_name roleName,r.enabled,r.create_by createBy,r.create_time createTime,u.user_name as 'user.userName' from sys_user u inner join sys_user_role ur on u.id=ur.user_id inner join sys_role r on ur.role_id=r.id where u.id = #{userId} and r.enabled = #{enabled}"})
	public List<SysRole> selectRolesByUserIdAndRoleEnabled(@Param("userId")Long userId, @Param("enabled")Integer enabled);

}
