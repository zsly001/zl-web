package com.zl.dao.mb.driver;

import com.zl.dao.mb.conf.Regx;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;
import org.apache.ibatis.session.Configuration;

import java.util.regex.Matcher;

public class SimpleXmlDriver extends XMLLanguageDriver {

    @Override
    public SqlSource createSqlSource(Configuration configuration, String script, Class<?> parameterType) {
        Matcher matcher = Regx.paramRegx.matcher(script);
        if (matcher.find()) {
            script = matcher.replaceAll("(<foreach collection=\"$1\" item=\"_item\" separator=\",\" >#{_item}</foreach>)");
        }

        script = "<script>" + script + "</script>";
        System.out.println("script: "+script);
        return super.createSqlSource(configuration, script, parameterType);
    }
}
