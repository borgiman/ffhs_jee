package ch.ffhs.jee;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class HelloWorldController {
    public String getHello() {
        return "Hello World!";
    }
}
