package springbook2.learningtest.spring.pojo;

/**
 * Created by adaeng on 27/03/2019.
 */
public class Hello {
    private String name;
    Printer printer;

    public void setName(String name) {
        this.name = name;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public String sayHello(){
        return "Hello " + this.name;
    }

    public void print(){
        this.printer.print(sayHello());
    }
}
