package com.wesly.manage.service;

import com.wesly.manage.model.User;

import java.util.List;

public interface UserService {

    User findByUsername(String username);

    List<String> getUserPermissions(String username);
}
