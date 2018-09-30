package com.i2bgod.test.beans;

/**
 * @auther: Lyn
 * @data: 2018/9/29
 */
public class BeanDefinition {
    public static final int SCOPE_SINGLETON = 0;
    public static final int SCOPE_PROTOTYPE = 1;

    private String id;
    private String clazz;
    private int SCOPE = SCOPE_SINGLETON;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public int getSCOPE() {
        return SCOPE;
    }

    public void setSCOPE(int SCOPE) {
        this.SCOPE = SCOPE;
    }
}
