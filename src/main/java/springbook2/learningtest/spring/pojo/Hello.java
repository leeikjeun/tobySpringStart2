package springbook2.learningtest.spring.pojo;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by adaeng on 27/03/2019.
 * Resource를 사용하면 setter없이 프로퍼티의 정보를 넣어줄수 있다.
 */
@Component
public class Hello {
    @Resource(name = "name")
    private String name;

    @Resource(name = "printer")
    Printer printer;

//    public void setName(String name) {
//        this.name = name;
//    }

//    public void setPrinter(Printer printer) {
//        this.printer = printer;
//    }

    public String sayHello(){
        return "Hello " + this.name;
    }

    public void print(){
        this.printer.print(sayHello());
    }
}
