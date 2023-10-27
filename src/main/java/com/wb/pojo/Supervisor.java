package com.wb.pojo;

public class Supervisor {
    private String id;
    private String name;
    private String password;
    private String dept_name;
    private String identity;

    public Supervisor(String id, String name, String password, String dept_name, String identity) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.dept_name = dept_name;
        this.identity = identity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    @Override
    public String toString() {
        return "Supervisor{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", dept_name='" + dept_name + '\'' +
                ", identity='" + identity + '\'' +
                '}';
    }
}
