package com.main;

import java.util.Scanner;

// changed name of main class to FractalCodeDefect so it will compile
public class FractalCodeDefect {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        while (m-- > 0) {
            int n = Integer.parseInt(scanner.nextLine());
            char[][] shape = new char[3][3];
            for (int i = 0; i <= 3; i++) {					
                shape[i] = scanner.nextLine().toCharArray();
            }
            Fractal fractal = new Fractal(n, '0', shape);   	
            fractal.printFractal();
        }
    }
}

class Fractal {
    private int n;
    private char symbol;
    private char[][] shape;
    private char[][] fractal;


    public Fractal(int n, char symbol, char[][] shape) {
        this.n = n;
        this.symbol = symbol;
        this.shape = shape;

        init();
        fill(n, 0, 0);
    }

    public void printFractal() {
        for (int i = 0; i < fractal.length; i++) {
            for (int j = 0; j < fractal[i].length; j++) {
                System.out.print(fractal[i][j]);
            }
            System.out.println();
        }
    }

    
    private void init() {
        // changed from a unicode dash to - so the program compiles
        int size = 6*n - 9;       				
        fractal = new char[size][size];
        for (int i = 0; i < fractal.length; i++) {
            for (int j = 0; j < fractal[i].length; j++) {
                fractal[i][j] = ' ';
            }
        }
    }

    private void fill(int n, int row, int col) {
        // changed from a unicode dash to - so the program compiles
        int size = 6*n - 9;
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                if (shape[i][j] == symbol) {
                    int innerSize = size / 3;
                    int innerRow = row + innerSize * i;
                    int innerCol = col + innerSize * j;
                    fill(n - 1, innerRow, innerCol);
                }
            }
        }
    }
}
