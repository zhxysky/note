package com.zhxy.note.repositories;

import com.zhxy.note.entities.Person;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

/**
 * Created by zhxy on 2016/8/31.
 */
@RepositoryRestResource(collectionResourceRel = "people",path = "people")
public interface PersonRepository extends PagingAndSortingRepository<Person,Long> {

    List<Person> findByLastName(@Param("name") String name);


}
