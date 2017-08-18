package mybatis.simple.test;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import junit.framework.Assert;
import mybatis.simple.mapper.UserMapper;
import mybatis.simple.model.SysRole;
import mybatis.simple.model.SysUser;

public class UserMapperTest extends BaseMapperTest {

/*	@Test
	public void testSelectById() {
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();

		// 获取UserMapper接口
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 调用selectById方法，查询id=1的用户
			SysUser user = userMapper.selectById(1L);
		} finally {
			// 关闭SqlSession
			sqlSession.close();
		}
	}

	@Test
	public void testSelectAll() {
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();

		// 获取UserMapper接口
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 调用selectById方法，查询id=1的用户
			List<SysUser> userList = userMapper.selectAll();
		} finally {
			// 关闭SqlSession
			sqlSession.close();
		}
	}

	@Test
	public void testSelectRoleByUserId() {
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();

		// 获取UserMapper接口
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 调用selectById方法，查询id=1的用户
			List<SysRole> roleList = userMapper.selectRoleByUserId(1L);
		} finally {
			// 关闭SqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert(){
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();

		// 获取UserMapper接口
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//创建一个user对象
			SysUser user = new SysUser();
			user.setUserName("insert");
			user.setUserPassword("123456");
			user.setUserEmail("mybatis@my.test");
			user.setUserInfo("insert data");
			//正常情况下应该存入一张图片
			user.setHeadImg(new byte[]{1,2,3});
			user.setCreateTime(new Date());
			
			//将新建的对象插入数据库中，特别注意这里的返回值result是执行的SQL影响的行数
			int result = userMapper.insert(user);
			System.out.println("插入成功数据条数为：" + result);
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			//为了不对其他的测试造成影响，此处进行数据回滚
			//由于默认的sqlSessionFactory.openSession()是不会自动提交的，因此如果不手动进行commit操作，数据也不会写入数据库
			sqlSession.rollback();
			// 关闭SqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert2(){
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();

		// 获取UserMapper接口
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//创建一个user对象
			SysUser user = new SysUser();
			user.setUserName("insert");
			user.setUserPassword("123456");
			user.setUserEmail("mybatis@my.test");
			user.setUserInfo("insert data");
			//正常情况下应该存入一张图片
			user.setHeadImg(new byte[]{1,2,3});
			user.setCreateTime(new Date());
			
			//将新建的对象插入数据库中，特别注意这里的返回值result是执行的SQL影响的行数
			int result = userMapper.insert2(user);
			System.out.println("插入成功数据条数为：" + result);
			System.out.println("主键id为："+user.getId());
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			//为了不对其他的测试造成影响，此处进行数据回滚
			//由于默认的sqlSessionFactory.openSession()是不会自动提交的，因此如果不手动进行commit操作，数据也不会写入数据库
			sqlSession.rollback();
			// 关闭SqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testInsert3(){
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();

		// 获取UserMapper接口
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			//创建一个user对象
			SysUser user = new SysUser();
			user.setUserName("insert");
			user.setUserPassword("123456");
			user.setUserEmail("mybatis@my.test");
			user.setUserInfo("insert data");
			//正常情况下应该存入一张图片
			user.setHeadImg(new byte[]{1,2,3});
			user.setCreateTime(new Date());
			
			//将新建的对象插入数据库中，特别注意这里的返回值result是执行的SQL影响的行数
			int result = userMapper.insert3(user);
			System.out.println("插入成功数据条数为：" + result);
			System.out.println("主键id为："+user.getId());
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			//为了不对其他的测试造成影响，此处进行数据回滚
			//由于默认的sqlSessionFactory.openSession()是不会自动提交的，因此如果不手动进行commit操作，数据也不会写入数据库
			sqlSession.rollback();
			// 关闭SqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testUpateById(){
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();

		// 获取UserMapper接口
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			//根据数据库中的用户的ID,查询出用户数据
			SysUser user = userMapper.selectById(3L);
			
			System.out.println("修改前数据为：" + user);
			
			//修改用户数据
			user.setUserName("update");
			user.setUserPassword("12345678");
			user.setUserEmail("mybatis@my.test");
			user.setUserInfo("update data");
			//正常情况下应该存入一张图片
			user.setHeadImg(new byte[]{1,2,3});
			user.setCreateTime(new Date());
			
			//将新建的对象插入数据库中，特别注意这里的返回值result是执行的SQL影响的行数
			int result = userMapper.updateById(user);
			System.out.println("修改成功数据条数为：" + result);
			
			//修改后再次获取用户数据
			SysUser user2 = userMapper.selectById(3L);
			System.out.println("修改后数据为：" + user2);
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			//为了不对其他的测试造成影响，此处进行数据回滚
			//由于默认的sqlSessionFactory.openSession()是不会自动提交的，因此如果不手动进行commit操作，数据也不会写入数据库
			sqlSession.rollback();
			// 关闭SqlSession
			sqlSession.close();
		}
	}
	
	@Test
	public void testDeleteById(){
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();

		// 获取UserMapper接口
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			
			//根据数据库中的用户的ID,查询出用户数据
			SysUser user1 = userMapper.selectById(1L);
			SysUser user2 = userMapper.selectById(2L);
			//此时还能够查询出数据
			System.out.println("执行删除前："+user1);
			System.out.println("执行删除前："+user2);
			
			//执行删除
			int result1 = userMapper.deleteById(1L);
			
			int result2 = userMapper.deleteById(user2);
			
			System.out.println("删除id=1数据条数：" + result1);
			System.out.println("删除id=2数据条数：" + result2);
			
			SysUser user11 = userMapper.selectById(1L);
			SysUser user22 = userMapper.selectById(2L);
			//此时还能够查询出数据
			System.out.println("执行删除后："+user11);
			System.out.println("执行删除后："+user22);
		}catch(Exception e){
			e.printStackTrace();
		} finally {
			//为了不对其他的测试造成影响，此处进行数据回滚
			//由于默认的sqlSessionFactory.openSession()是不会自动提交的，因此如果不手动进行commit操作，数据也不会写入数据库
			sqlSession.rollback();
			// 关闭SqlSession
			sqlSession.close();
		}
	}*/
	
	@Test
	public void testSelectRolesByUserIdAndRoleEnabled() {
		// 获取SqlSession
		SqlSession sqlSession = getSqlSession();

		// 获取UserMapper接口
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			// 调用selectById方法，查询id=1的用户
			List<SysRole> roleList = userMapper.selectRolesByUserIdAndRoleEnabled(1L,1);
		} catch(Exception e){
			e.printStackTrace();
		}finally {
			// 关闭SqlSession
			sqlSession.close();
		}
	}
}
