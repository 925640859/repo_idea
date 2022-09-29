package com.lagou.dao;

import com.lagou.domain.Role;
import com.lagou.domain.Role_menu_relation;

import java.util.List;

public interface RoleMapper {

    public List<Role> findAllRole(Role role);

    List<String> findMenuByRoleId(Integer roleId);

    /*根据roleId清空中间表的连接关系*/
    public void deleteRoleContextMenu(Integer rid);

    /*为角色分配菜单信息*/
    public void RoleContextMenu(Role_menu_relation role_menu_relation);

    /*删除角色*/
    void deleteRole(Integer id);


}
