/**
 * @program:community
 * @description: User服务接口
 * @author: zhangwei
 * @create: 2021年05月11日
 */
package com.ly.mt.mis.community.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.item.util.AppPage;
import com.ly.mt.mis.community.entity.User;
/**   
 *  
 * @Description:  User——SERVICE
 * @Author:       zhangwei   
 * @CreateDate:   2021年05月11日
 * @Version:      V1.0
 *    
 */
public interface UserService {
	
	/**
	 * @explain 查询User对象
	 * @param   对象参数：id
	 * @return  User
	 * @author  zhangwei
	 */
	public User selectByPrimaryKey(Long id);
	
	/**
	 * @explain 删除User对象
	 * @param   对象参数：id
	 * @return  int
	 * @author  zhangwei
	 */
	public int deleteByPrimaryKey(Long id);
	
	/**
	 * @explain 添加User对象
	 * @param   对象参数：User
	 * @return  int
	 * @author  zhangwei
	 */
	public int insertSelective(User user);
	
	/**
	 * @explain 修改User对象
	 * @param   对象参数：User
	 * @return  int
	 * @author  zhangwei
	 */
	public int updateByPrimaryKeySelective(User user);
	
	/**
	 * @explain 查询User集合
	 * @param   对象参数：User
	 * @return  List<User>
	 * @author  zhangwei
	 */
	public List<User> queryUserList(User user);
	
	/**
	 * @explain 分页查询User
	 * @param   对象参数：User
	 * @return  PageInfo<User>
	 * @author  zhangwei
	 */
	public PageInfo<User> getUserBySearch(AppPage<User> page);
}