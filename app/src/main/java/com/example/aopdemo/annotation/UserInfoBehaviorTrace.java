package com.example.aopdemo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * author : xia chen hui
 * email : 184415359@qq.com
 * date : 2019/8/23/023 7:55
 * desc : 用户行为
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserInfoBehaviorTrace {
    String value();
}
