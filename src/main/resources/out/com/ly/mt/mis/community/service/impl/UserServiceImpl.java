/**
 * @program:community
 * @description: User服务
 * @author: zhangwei
 * @create: 2021年05月11日
 */
package com.ly.mt.mis.community.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.item.util.AppPage;
import com.ly.mt.mis.community.entity.User;
import com.ly.mt.mis.community.mapper.UserDao;
import com.ly.mt.mis.community.service.UserService;

/**   
 *  
 * @Description:  User——SERVICEIMPL
 * @Author:       zhangwei   
 * @CreateDate:   2021年05月11日
 * @Version:      V1.0
 *    
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	public UserDao userDao;
	
	//查询对象
	@Override
	public User selectByPrimaryKey(Long id) {
		return userDao.selectByPrimaryKey(id);
	}
	
	//删除对象
	@Override
	public int deleteByPrimaryKey(Long id) {
		return userDao.deleteByPrimaryKey(id);
	}
	
	//添加对象
	@Override
	public int insertSelective(User user) {
		return userDao.insertSelective(user);
	}
	
	//修改对象
	@Override
	public int updateByPrimaryKeySelective(User user) {
		return userDao.updateByPrimaryKeySelective(user);
	}
	
	//查询集合
	@Override
	public List<User> queryUserList(User user) {
		return userDao.queryUserList(user);
	}
	
	//分页查询
	@Override
	public PageInfo<User> getUserBySearch(AppPage<User> page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page.getPageNum(),page.getPageSize());
		List<User> list=userDao.queryUserList(page.getParam());
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		return pageInfo;
	}
}