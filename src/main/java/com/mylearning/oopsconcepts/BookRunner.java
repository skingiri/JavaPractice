package com.mylearning.oopsconcepts;

public class BookRunner {
    public static void main(String[] args) {
        Books artOfComputerProgramming = new Books();
        Books effectiveJava = new Books();
        Books cleanCode = new Books();
        artOfComputerProgramming.Read();
        effectiveJava.Write();
        cleanCode.Print();
    }
}
