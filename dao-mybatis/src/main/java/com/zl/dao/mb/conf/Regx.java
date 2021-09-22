package com.zl.dao.mb.conf;

import java.util.regex.Pattern;

public abstract class Regx {

    public static final Pattern paramRegx = Pattern.compile("\\(#\\{(\\w+)\\}\\)");

    private Regx() {
    }
}
