package com.zl.dao.mb.adm;

import com.zl.domain.po.adm.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    @ResultType(User.class)
    @Select("select * from tb_user where id = #{id}")
    User getUser(@Param("id") Integer id);


}
