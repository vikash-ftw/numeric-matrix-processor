import java.util.Arrays;
import java.util.Scanner;

//Addition, Multiplication of matrices
// Multiplication of matrix by constant
//no. of rows->arr_name.length
//no. of columns->arr_name[0].length
public class Main {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
        while (true) {
            switch (choiceMenu()){
                case 1:{int m1row = scn.nextInt();
                    int m1col = scn.nextInt();
                    double[][] mtx1 = new double[m1row][m1col];
                    setMatrix(mtx1);

                    int m2row = scn.nextInt();
                    int m2col = scn.nextInt();
                    double[][] mtx2 = new double[m2row][m2col];
                    setMatrix(mtx2);
                    if(m1row==m2row && m1col==m2col){
                        double[][] add_mtx=new double[m1row][m1col];
                        addingMatrix(mtx1,mtx2,add_mtx);
                        displayMatrix(add_mtx);
                    }else{
                        System.out.println("ERROR");
                    }} break;
                case 2:{int m1row = scn.nextInt();
                    int m1col = scn.nextInt();
                    double[][] mtx1 = new double[m1row][m1col];
                    setMatrix(mtx1);
                    int num = scn.nextInt();
                    multiplicationNum(mtx1,num);
                    displayMatrix(mtx1);} break;
                case 3:{int m1row = scn.nextInt();
                    int m1col = scn.nextInt();
                    double[][] mtx1 = new double[m1row][m1col];
                    setMatrix(mtx1);

                    int m2row = scn.nextInt();
                    int m2col = scn.nextInt();
                    double[][] mtx2 = new double[m2row][m2col];
                    setMatrix(mtx2);
                    if(m1col==m2row){
                        double[][] mlt_mtx=new double[m1row][m2col];
                        multiplyMatrix(mtx1,mtx2,mlt_mtx);
                        displayMatrix(mlt_mtx);
                    }else{
                        System.out.println("ERROR");
                    }} break;
                case 4:{
                    System.out.println("1. Main diagonal\n" +
                            "2. Side diagonal\n" +
                            "3. Vertical line\n" +
                            "4. Horizontal line");
                    int transposeChoice = scn.nextInt();
                    int mrow = scn.nextInt();
                    int mcol = scn.nextInt();
                    double[][] mtx = new double[mrow][mcol];
                    setMatrix(mtx);
                    if(transposeChoice == 1){mainDiagonalTranspose(mtx);}
                    else if(transposeChoice == 2){sideDiagonalTranspose(mtx);}
                    else if(transposeChoice == 3){verticalLineTranspose(mtx);}
                    else if(transposeChoice == 4){horizontalLineTranspose(mtx);}
                    displayMatrix(mtx);
                } break;
                case 0:System.exit(1); break;

            }
        }

    }
    public static void setMatrix(double[][] m){
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                m[i][j]=scn.nextDouble();
            }
        }
    }
    public static void displayMatrix(double[][] m){
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                System.out.print(m[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void addingMatrix(double[][] m1,double[][] m2,double[][] nm){
        for(int i=0;i<m1.length;i++){
            for(int j=0;j<m1[0].length;j++){
                nm[i][j]=m1[i][j]+m2[i][j];
            }
        }
    }
    public static void multiplicationNum(double[][] m,int num){
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                m[i][j]=num*m[i][j];
            }
        }
    }
    public static void multiplyMatrix(double[][] m1,double[][] m2,double[][] nm){
        double temp=0;
        double elem=0;
        for(int i=0;i<m1.length;i++){  //new matrix row count
            for(int j=0;j<m2[0].length;j++){  // new matrix column count
                for(int k=0;k<m1[0].length;k++){ // count upto m1 column or m2 row count
                    temp=m1[i][k]*m2[k][j];
                    elem+=temp;
                }
                nm[i][j]=elem;
                elem=0;
            }
        }
    }
    public static void mainDiagonalTranspose(double[][]m){
        double temp=0;
        for(int i=0;i<m.length-1;i++){
            for(int j=1+i;j<m[0].length;j++){
                temp = m[i][j];
                m[i][j]=m[j][i];
                m[j][i]=temp;
            }
        }
    }
    public static void sideDiagonalTranspose(double[][]m){
        double temp=0;
        int col2=m[0].length-1;
        int col1;
        for(int i=0;i<m.length-1;i++){
            col1=m[0].length-1;
            for(int j=0;j<m[0].length-1-i;j++){
                temp=m[i][j];
                m[i][j]=m[col1][col2];
                m[col1][col2]=temp;
                col1--;
            }
            col2--;
        }
    }
    public static void verticalLineTranspose(double[][]m){
        double temp=0;
        int col;
        for(int i=0;i<m.length;i++){
            col = m[0].length-1;
            for(int j=0;j<m[0].length/2;j++){
               temp = m[i][j];
               m[i][j]=m[i][col];
               m[i][col]=temp;
               col--;
            }
        }
    }
    public static void  horizontalLineTranspose(double[][]m){
        double temp=0;
        int row;
        for(int j=0;j<m[0].length;j++){
            row = m.length-1;
            for(int i=0;i<m.length/2;i++){
                temp = m[i][j];
                m[i][j]=m[row][j];
                m[row][j]=temp;
                row--;
            }
        }
    }

    public static int choiceMenu(){
        System.out.println("1. Add matrices\n" +
                "2. Multiply matrix to a constant\n" +
                "3. Multiply matrices\n" +
                "4. Transpose matrix\n" +
                "0. Exit");
        System.out.println("Your choice: ");
        return scn.nextInt();
    }
}
