package com.liweqnaun.fastec.generators;

import com.example.annotations.AppRegisterGenerator;
import com.liweqnaun.latte.wxtemplate.AppRegisterTemplate;

/**
 * Created by liweqnaun on 2018/1/31.
 */
@AppRegisterGenerator(
        packageName = "com.liweqnaun.fastec",
        registerTemplate = AppRegisterTemplate.class
)
public interface AppRegister {
}
