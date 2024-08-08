package dev.neeraj.orderservice.exceptions;

public class OrderNotFoundException extends Exception{
    public OrderNotFoundException(String msg){
        super(msg);
    }
}
