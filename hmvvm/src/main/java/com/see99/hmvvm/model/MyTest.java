package com.see99.hmvvm.model;

public class MyTest {
    private String name;
    private String age;
    private String url;

    public MyTest(String ni, String wo) {
        name = ni;
        url = wo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
