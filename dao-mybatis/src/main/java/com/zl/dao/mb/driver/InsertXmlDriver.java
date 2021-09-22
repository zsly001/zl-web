package com.zl.dao.mb.driver;

import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;

import java.lang.reflect.Field;

public class InsertXmlDriver extends XMLLanguageDriver {

    @Override
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {

        Field[] fields = parameterType.getDeclaredFields();

        return super.createSqlSource(configuration, script, parameterType);
    }
}
