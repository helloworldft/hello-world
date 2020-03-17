package org.example.validator;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by heqingfu on 2020/2/20.
 */
@Getter
@Setter
public class DemoModel {

    @NotBlank(message="{user.name.not.null}")
    private String userName;

    @NotBlank(message="{user.age.not.null}")
    @Pattern(regexp="^[0-9]{1,2}$",message="{user.age.incorrect}")
    private String age;

    @AssertFalse(message = "{param.false}")
    private Boolean isFalse;
    /**
     * 如果是空，则不校验，如果不为空，则校验
     */
    @Pattern(regexp="^[0-9]{4}-[0-9]{2}-[0-9]{2}$",message="{birthday.format.incorrect}")
    private String birthday;

    @NotNull
    @Valid
    private SubDemoModel subDemoModel;

    @Getter
    @Setter
    public static class SubDemoModel {
        @NotBlank(message="{user.sub.name.not.null}")
        private String subName;
    }
}

