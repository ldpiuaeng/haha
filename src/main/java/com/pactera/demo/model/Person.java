package com.pactera.demo.model;

import javax.persistence.Id;

public class Person {
    @Id
    private Integer pid;
    private String pname;
    private Integer p_age;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getP_age() {
        return p_age;
    }

    public void setP_age(Integer p_age) {
        this.p_age = p_age;
    }

    @Override
    public String toString() {
        return "pid=" + pid + ", pname='" + pname + '\'' + ", p_age=" + p_age;
    }
}
