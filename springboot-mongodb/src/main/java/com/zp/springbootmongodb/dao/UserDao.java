package com.zp.springbootmongodb.dao;

import com.zp.springbootmongodb.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZP
 * @date 2021/5/9.
 */
@Repository
public interface UserDao extends MongoRepository<User, String> {

    /**
     * 根据年龄段来查找
     *
     * @param from from
     * @param to   to
     * @return List<User>
     */
    List<User> findByAgeBetween(Integer from, Integer to);

    /**
     * 通过年龄段，用户名，描述（模糊查询）
     *
     * @param from        from
     * @param to          to
     * @param name        name
     * @param description description
     * @return List<User>
     */
    List<User> findByAgeBetweenAndNameEqualsAndDescriptionIsLike(Integer from, Integer to, String name, String description);

}
