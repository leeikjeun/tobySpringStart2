package springbook2.learningtest.spring.pojo;

/**
 * Created by adaeng on 27/03/2019.
 */
public class StringPrinter implements Printer {
    private StringBuilder builder = new StringBuilder();

    @Override
    public void print(String message) {
        this.builder.append(message);
    }

    @Override
    public String toString() {
        return this.builder.toString();
    }
}
