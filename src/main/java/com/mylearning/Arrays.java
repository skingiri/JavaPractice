package com.mylearning;

public class Arrays {
    public static void main(String[] args) {
        int[] n={1,2,3,4,5};
//        for (int i=0; i<n.length; i++){
//            System.out.println(n[i]);
//        }
        int[][] matrix=new int[2][3];
//        matrix={{1,2,3},{4,5,6}};
        for (int i=0;i< matrix.length;i++){
            for (int j=0;j<matrix[i].length;j++){
                System.out.println(matrix[i][j]);
            }
        }
    }
}
