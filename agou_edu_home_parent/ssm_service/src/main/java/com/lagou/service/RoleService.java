package com.lagou.service;

import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVo;


import java.util.List;

public interface RoleService {

    public List<Role> findAllRole(Role role);

    List<String> findMenuByRoleId(Integer roleId);

    /*为角色分配菜单信息*/
    public void RoleContextMenu(RoleMenuVo roleMenuVo);

    /*删除角色*/
    void deleteRole(Integer id);
}
