package com.mylearning.interfaceexample;

public class Circle implements Drawable{
    public static void main(String[] args) {
        Circle c = new Circle();
        c.draw();
    }
    public void draw() {
        System.out.println("Draw Circle");
    }
}
