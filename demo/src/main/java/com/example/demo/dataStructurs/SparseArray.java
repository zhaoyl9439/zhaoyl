package com.example.demo.dataStructurs;

public class SparseArray {

    public static void main(String[] args) {

        //创建二维数组 11*11
        //0:无棋子、 1：黑子、 2：篮子
        int chessArray1[][] = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        chessArray1[4][5] = 2;
        //输出
        for (int[] row : chessArray1) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }

        //转换为稀疏数组
        //1。遍历二维数组得到非0的个数
        int sum = 0;
        /*for (int[] row : chessArray1) {
            for (int data : row) {
                if (data != 0) sum++;
            }
        }*/
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray1[i][j] != 0)
                    sum++;
            }
        }
        System.out.println();
        System.out.println("sum="+ sum);

        //2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;

        //遍历原数组，将非0的值放入稀疏数组
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArray1[i][j];
                }
            }
        }

        //输出稀疏数组
        System.out.println();
        System.out.println("稀疏数组为~~~~~~~~~");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }

        //恢复为二维数组
        //1。创建原始数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
        //2.读取后几行数组，赋值给新数组
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        //输出恢复的数组
        System.out.println();
        System.out.println("恢复的二维数组~~~~~~~~");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }




    }

}
