package com.zhxy.note.repositories;

import com.zhxy.note.entities.Users;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by zhxy on 2016/8/31.
 */
@RepositoryRestResource(collectionResourceRel = "users",path = "users")
public interface UsersRepository extends CrudRepository<Users,Integer> {
    List<Users> findByName(@Param("name") String name);
}
