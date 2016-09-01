package com.zhxy.note.repositories;

import com.zhxy.note.entities.Users;
import org.springframework.data.repository.query.Param;

/**
 * Created by zhxy on 2016/8/31.
 */
public interface UsersRepositoryCustom {

    Users findById(@Param("id") Integer id);

}
