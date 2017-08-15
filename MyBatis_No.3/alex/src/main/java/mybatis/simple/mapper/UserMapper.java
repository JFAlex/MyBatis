package mybatis.simple.mapper;

import java.util.List;

import mybatis.simple.model.SysRole;
import mybatis.simple.model.SysUser;

public interface UserMapper {
	/**
	 * 根据用户id查询用户信息
	 * 
	 * @param id
	 * @return
	 */
	public SysUser selectById(Long id);

	/**
	 * 查询所有用户信息
	 * 
	 * @return
	 */
	public List<SysUser> selectAll();

	/**
	 * 查询用户所拥有的角色
	 * 
	 * @param userId
	 * @return
	 */
	public List<SysRole> selectRoleByUserId(Long userId);

	/**
	 * 保存新用户信息
	 * 
	 * @param sysUser
	 * @return
	 */
	public int insert(SysUser sysUser);

	/**
	 * 保存新用户信息，并返回主键
	 * 
	 * @param sysUser
	 * @return
	 */
	public int insert2(SysUser sysUser);

	/**
	 * 保存新用户信息，并返回主键
	 * 
	 * @param sysUser
	 * @return
	 */
	public int insert3(SysUser sysUser);

	/**
	 * 根据用户id，修改用户信息
	 * 
	 * @param sysUser
	 * @return
	 */
	public int updateById(SysUser sysUser);

	/**
	 * 根据用户id，删除用户信息
	 * 
	 * @param id
	 * @return
	 */
	public int deleteById(Long id);

	/**
	 * 根据用户id，删除用户信息
	 * 
	 * @param sysUser
	 * @return
	 */
	public int deleteById(SysUser sysUser);

}
