package com.zhxy.note.repositories;

import com.zhxy.note.entities.Users;
import org.springframework.data.repository.query.Param;

/**
 * Created by zhxy on 2016/8/31.
 */
public class UsersRepositoryImpl implements UsersRepositoryCustom {

    @Override
    public Users findById(@Param("id") Integer id) {
        System.out.println("custom get user method.");
        return null;
    }
}
