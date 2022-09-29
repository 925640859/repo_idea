package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.UserMapper;
import com.lagou.domain.*;
import com.lagou.service.UserService;
import com.lagou.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public PageInfo findAllUserByPage(UserVo userVo) {
        // 使用pageHelper
        PageHelper.startPage(userVo.getCurrentPage(),userVo.getPageSize());
        List<User> allUser = userMapper.findAllUserByPage(userVo);
        PageInfo<User> pageInfo = new PageInfo<>(allUser);
        return pageInfo;
    }

    @Override
    public void updateUserStatus(int id, String status) {
        userMapper.updateUserStatus(id,status);
    }

    @Override
    public User login(User user) throws Exception {
        User user2 = userMapper.login(user);
        if(user2 != null && Md5.verify(user.getPassword(),"lagou",user2.getPassword())){
            return user2;
        }else {
            return null;
        }
    }

    @Override
    public List<Role> findUserRelationRoleById(int id) {
        List<Role> roleList = userMapper.findUserRelationRoleById(id);
        return roleList;
    }

    @Override
    public void userContextRole(UserVo userVo) {
        // 根据用户ID清空中间表的关联关系
        userMapper.deleteUserContextRole(userVo.getUserId());
        // 向中间表添加记录
        for (Integer roleid : userVo.getRoleIdList()) {
            User_Role_relation user_role_relation = new User_Role_relation();
            user_role_relation.setUserId(userVo.getUserId());
            user_role_relation.setRoleId(roleid);
            Date date = new Date();
            user_role_relation.setCreatedTime(date);
            user_role_relation.setUpdatedTime(date);
            user_role_relation.setCreatedBy("system");
            user_role_relation.setUpdatedby("system");
            userMapper.userContextRole(user_role_relation);
        }
    }

    @Override
    public ResponseResult getUserPermissions(Integer id) {
        System.out.println("diyige"+ id);
        //1获取当前用户的角色
        List<Role> roleList = userMapper.findUserRelationRoleById(id);
        System.out.println("roleList" + roleList);
        //2获取角色id保存到list
        List<Integer> ids = new ArrayList<>();
        for (Role role : roleList) {
            ids.add(role.getId());
        }
        //3根据角色id查询父菜单
        System.out.println(ids);
        List<Menu> parentMenu = userMapper.findParentMenuByRoleId(ids);
        //4父菜单关联的子菜单
        for (Menu menu : parentMenu) {
            List<Menu> subMenuByPid = userMapper.findSubMenuByPid(menu.getId());
            menu.setSubMenuList(subMenuByPid);
        }
        //5获取资源信息
        List<Resource> resourceList = userMapper.findResourceByRoleId(ids);
        //6封装信息并且返回
        Map<String, Object> map = new HashMap<>();
        map.put("menuList", parentMenu);
        map.put("resourceList",resourceList);

        return new ResponseResult(true, 200, "获取成功", map);
    }

}

