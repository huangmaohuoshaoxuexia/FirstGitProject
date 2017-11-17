package com.jiaxufei.framework.service.Exception;

/**
 * author: 贾旭飞(<a href="mailto:jiaxufei@danlu.com">jiaxufei@danlu.com</a>)<br/>
 * version: 1.0.0<br/>
 * since: 2017-11-17 下午9:47<br/>
 * <p>
 * <p>
 * Retrofit不存在或没有初始化异常
 * </p>
 */
public class MissRetrofitException extends RuntimeException{
    public MissRetrofitException() {
        super("Miss Retrofit or not init! ");
    }
}
