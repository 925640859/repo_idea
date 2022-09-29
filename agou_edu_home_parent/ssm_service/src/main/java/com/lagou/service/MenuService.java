package com.lagou.service;

import com.lagou.domain.Menu;

import java.util.List;

public interface MenuService {
    public List<Menu> findSubMenuListByPid(int pid);

    /*查询菜单列表*/
    public List<Menu> findAllMenu();


    Menu findMenuById(int id);
}
