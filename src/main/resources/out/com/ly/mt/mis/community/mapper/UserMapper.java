
package com.ly.mt.mis.community.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.ly.mt.mis.community.entity.User;


/**
 * @program:community
 * @description: Userdao层
 * @author: zhangwei
 * @create: 2021年05月11日
 */
@Mapper
public interface UserMapper {
	
	public User selectByPrimaryKey(Long id);
	
	public int deleteByPrimaryKey(Long id);
	
	public int insertSelective(User user);
	
	public int updateByPrimaryKeySelective(User user);
	
	public List<User> queryUserList(User user);
}
