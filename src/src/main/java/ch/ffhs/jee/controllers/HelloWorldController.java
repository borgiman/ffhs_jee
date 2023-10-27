package ch.ffhs.jee.controllers;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named
@RequestScoped
public class HelloWorldController {
    public String getHello() {
        return "Hello World!";
    }
}
