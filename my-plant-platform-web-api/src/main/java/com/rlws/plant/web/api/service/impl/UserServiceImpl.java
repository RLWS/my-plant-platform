package com.rlws.plant.web.api.service.impl;

import com.rlws.plant.commons.utils.Mmseg4jUtils;
import com.rlws.plant.domain.PageVo;
import com.rlws.plant.domain.User;
import com.rlws.plant.web.api.mapper.UserMapper;
import com.rlws.plant.web.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    //
    @Override
    public User selectByPrimaryKey(User user) {
        User user1 = userMapper.selectByPrimaryKey(user);
        return user1;
    }

    //根据用户email和power来判断能否登录成功
    @Override
    public User userLogin(String email) {
        User user = new User();
        user.setEmail(email);
        return userMapper.selectByPrimaryKey(user);
    }

    //根据id主键来对用户表进行查询
    @Override
    public User selectOneUserById(int userId) {
        User user = userMapper.selectOneUserById(userId);
        return user;
    }

    //更新用户表数据(密码或其他信息)
    @Override
    public boolean updateUser(User user) {
        int i = userMapper.updateUser(user);
        return i > 0 ? true : false;
    }

    //用户注册
    @Override
    public boolean userRegistration(User user) {
        int i = userMapper.insertOneUser(user);
        return i > 0 ? true : false;
    }

    //根据userId获取用户获取最佳回答的数量Count
    @Override
    public int selectUserBestAnswerCount(int userId) {
        int i = userMapper.selectUserBestAnswerCount(userId);
        return i;
    }

    //获取用户的数量Count
    @Override
    public int selectAllUserCount() {
        int i = userMapper.selectAllUserCount();
        return i;
    }

    //获取用户的所有信息
    @Override
    public List<User> selectAllUser(PageVo pageVo) {
        List<User> users = userMapper.selectAllUser(pageVo);
        return users;
    }

    //删除一条User数据
    @Override
    public boolean delectOneUser(int userId) {
        int i = userMapper.delectOneUser(userId);
        return i > 0 ? true : false;
    }

    //模糊查询关键字段Count
    @Override
    public int selectMainUserCount(String str) {
        int i = userMapper.selectMainUserCount(str);
        return i;
    }

    //模糊查询关键字段
    @Override
    public List<User> selectMainUser(PageVo pageVo) {
        List<User> users = userMapper.selectMainUser(pageVo);
        for (User user: users){
            user.setUsername(Mmseg4jUtils.titleConversion(user.getUsername(),pageVo.getSearch()));
            user.setEmail(Mmseg4jUtils.titleConversion(user.getEmail(),pageVo.getSearch()));
        }
        return users;
    }

    //获取所有有信息来往的List<User>
    @Override
    public List<User> selectAllMessageUser(int userId) {
        List<User> users = userMapper.selectAllMessageUser(userId);
        return users;
    }

}
