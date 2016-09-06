package com.zhxy.note.repositories;

import com.zhxy.note.entities.Article;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

/**
 * Created by zhxy on 2016/9/2.
 */
@RepositoryRestResource(collectionResourceRel = "article",path = "article")
public interface ArticleRepository extends CrudRepository<Article,Long> {

    @Query(value = "select * from article order by id desc ",nativeQuery = true)
    List<Article> findAllOrderByIdDesc();

    @Query(value = "select * from article a where lower(a.title) like lower(concat('%',:keyWord,'%') ) or lower(a.content) like lower(concat('%',:keyWord,'%') ) order by id desc ", nativeQuery = true)
    List<Article> findByTitleAndContent(@Param("keyWord") String keyWord);
}
