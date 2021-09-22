package com.zl.dao.mb.adm;

import com.zl.dao.mb.driver.InsertXmlDriver;
import com.zl.dao.mb.driver.SimpleXmlDriver;
import com.zl.domain.po.adm.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    @ResultType(User.class)
    @Select("select * from tb_user where id = #{id}")
    User getUser(@Param("id") Integer id);

    @ResultType(User.class)
    @Lang(SimpleXmlDriver.class)
    @Select("select * from tb_user where id in (#{ids})")
    List<User> getUsers(@Param("ids") List<Integer> ids);

    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Lang(InsertXmlDriver.class)
    @Insert("insert into user value(#{user})")
    int save(User user);


}
