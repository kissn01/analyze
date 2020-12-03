package com.yoooum.test;


import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLSyntaxErrorException;

@RestControllerAdvice
public class RestControllerAdvicer {


    @ExceptionHandler(value = Exception.class)
    public String handlerException(Exception e) {

        if (e instanceof NullPointerException) {
            System.out.println("发生错误,已被拦截");
            System.out.println(e.toString());
            return "服务端空指针异常！";
        }else if (e instanceof HttpMessageNotReadableException) {
            System.out.println("发生错误,已被拦截");
            return e.getMessage();
        }else if (e instanceof SQLSyntaxErrorException){
            System.out.println("我以捕获SQLSyntaxErrorException");

            return "表不存在？？？"+e.getMessage();
        }
        else if (e instanceof BadSqlGrammarException){

            System.out.println("我以捕获BadSqlGrammarException");
            return "表不存在？？？"+e.getMessage();
        }
        System.out.println("完善错误拦截信息在错误拦截器中添加");
        e.printStackTrace();
        return null;
    }



}
