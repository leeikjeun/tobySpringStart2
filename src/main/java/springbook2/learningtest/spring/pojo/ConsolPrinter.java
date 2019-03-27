package springbook2.learningtest.spring.pojo;

/**
 * Created by adaeng on 27/03/2019.
 */
public class ConsolPrinter implements Printer {
    @Override
    public void print(String message) {
        System.out.println(message);
    }
}
