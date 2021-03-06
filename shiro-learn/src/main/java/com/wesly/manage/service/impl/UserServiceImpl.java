package com.wesly.manage.service.impl;

import com.wesly.manage.mapper.PermissionMapper;
import com.wesly.manage.mapper.RolePermissionMapper;
import com.wesly.manage.mapper.UserMapper;
import com.wesly.manage.mapper.UserRoleMapper;
import com.wesly.manage.model.*;
import com.wesly.manage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    public User findByUsername(String username) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andNameEqualTo(username);
        List<User> users = userMapper.selectByExample(userExample);
        if (CollectionUtils.isEmpty(users)) {
            return null;
        } else {
            return users.get(0);
        }
    }

    /**
     * 取多个角色权限的并集
     *
     * @param userId
     * @return
     */
    @Override
    public List<String> getUserPermissions(String userId) {
        // 查找角色
        UserRoleExample userRoleExample = new UserRoleExample();
        userRoleExample.createCriteria()
                .andUserIdEqualTo(userId);
        List<UserRole> userRoles = userRoleMapper.selectByExample(userRoleExample);
        if (userRoles.size() == 0) {
            return new ArrayList<>();
        }
        // 查找权限
        RolePermissionExample rolePermissionExample = new RolePermissionExample();
        rolePermissionExample.createCriteria()
                .andRoleIdIn(userRoles.stream().map(UserRole::getRoleId).collect(Collectors.toList()));
        List<RolePermission> rolePermissions = rolePermissionMapper.selectByExample(rolePermissionExample);
        if (rolePermissions.size() == 0) {
            return new ArrayList<>();
        }
        // 查找权限
        PermissionExample permissionExample = new PermissionExample();
        permissionExample.createCriteria()
                .andIdIn(rolePermissions.stream().map(RolePermission::getPermissionId).distinct().collect(Collectors.toList()));
        return permissionMapper.selectByExample(permissionExample)
                .stream()
                .map(Permission::getValue)
                .distinct()
                .collect(Collectors.toList());
    }
}
