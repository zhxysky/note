package com.zhxy.note.repositories;

import com.zhxy.note.entities.Article;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by zhxy on 2016/9/2.
 */
@RepositoryRestResource(collectionResourceRel = "article",path = "article")
public interface ArticleRepository extends CrudRepository<Article,Long> {

}
