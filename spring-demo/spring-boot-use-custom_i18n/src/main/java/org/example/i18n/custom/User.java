package org.example.i18n.custom;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * Created by heqingfu on 2020/2/20.
 */
public class User {

    @Max(value = 10, message = "{age.limitation}")
    private Integer age ;

    @NotNull(message = "{param.not.null}")
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
