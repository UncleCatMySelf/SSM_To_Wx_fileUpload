package com.myself.common;

/**
 * API接口返回协议
 * @Author:这个程序员有纹身
 * @Date: Created in 21:13 2017\12\13 0013
 */
public enum ResponseCode {
    SUCCESS(200,"SUCCESS"),
    ERROR(100,"ERROR"),
    NEED_LOGIN(101,"NEED_LOGIN"),
    //内部错误
    ILLEGAL_ARGUMENT(201,"ILLEGAL_ARGUMENT"),
    CHANGE_MAPPER_ERROR(-1001,"CHANGE_MAPPER_ERROR"),
    BOOK_IMG_NOT_NULL(-1002,"BOOK_IMG_NOT_NULL"),
    DATA_NOT_NULL(1000,"DATA_NOT_NULL"),
    //Service层方法执行报错
    SERVICE_ERROR(2000,"SERVICE_ERROR"),
    //DAO层方法执行报错
    DAO_ERROR(3000,"DAO_ERROR"),
    //netty
    NOT_CHANNEL(-2000,"NOT_CHANNEL");

    private final int code;
    private final String desc;


    ResponseCode(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }
    public String getDesc(){
        return desc;
    }
}
