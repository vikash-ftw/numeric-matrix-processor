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
                case 1:{
                	System.out.println("Enter the row and column size for matrix 1 ::");
                	int m1row = scn.nextInt();
                    int m1col = scn.nextInt();
                    int[][] mtx1 = new int[m1row][m1col];
                    setMatrix(mtx1);
                    System.out.println("Enter the row and column size for matrix 2 ::");
                    int m2row = scn.nextInt();
                    int m2col = scn.nextInt();
                    int[][] mtx2 = new int[m2row][m2col];
                    setMatrix(mtx2);
                    if(m1row==m2row && m1col==m2col){
                        int[][] add_mtx=new int[m1row][m1col];
                        addingMatrix(mtx1,mtx2,add_mtx);
                        displayMatrix(add_mtx);
                    }else{
                        System.out.println("ERROR row and column size not matching");
                    }} break;
                case 2:{
                	System.out.println("Enter the row and column size ::");
                	int m1row = scn.nextInt();
                    int m1col = scn.nextInt();
                    int[][] mtx1 = new int[m1row][m1col];
                    setMatrix(mtx1);
                    System.out.println("Enter the muliplication constant ::");
                    int num = scn.nextInt();
                    displayMatrix(mtx1);
                    multiplicationNum(mtx1,num);
                    System.out.println("After multiplication :: ");
                    displayMatrix(mtx1);} break;
                case 3:{
                	System.out.println("Enter the row and column size for matrix 1::");
                	int m1row = scn.nextInt();
                    int m1col = scn.nextInt();
                    int[][] mtx1 = new int[m1row][m1col];
                    setMatrix(mtx1);
                    
                    System.out.println("Enter the row and column size for matrix 2::");
                    int m2row = scn.nextInt();
                    int m2col = scn.nextInt();
                    int[][] mtx2 = new int[m2row][m2col];
                    setMatrix(mtx2);
                    if(m1col==m2row){
                        int[][] mlt_mtx=new int[m1row][m2col];
                        multiplyMatrix(mtx1,mtx2,mlt_mtx);
                        displayMatrix(mlt_mtx);
                    }else{
                        System.out.println("ERROR");
                    }} break;
                case 4:{
                	System.out.println("Enter the row and column size ::");
                    int mrow = scn.nextInt();
                    int mcol = scn.nextInt();
                    int[][] mtx = new int[mrow][mcol];
                    int[][] tmtx = new int[mcol][mrow];
                    setMatrix(mtx);
                    displayMatrix(mtx);
                    mainDiagonalTranspose(mtx,tmtx);
                    System.out.println("After transpose :: ");
                    displayMatrix(tmtx);
                } break;
                case 0:System.exit(1); break;

            }
        }

    }
    public static void setMatrix(int[][] m){
        System.out.println("Enter data for matrix ::");
    	for(int i=0;i<m.length;i++){
    		System.out.println("Row "+(i+1));
            for(int j=0;j<m[0].length;j++){
            	System.out.println("Enter data for column "+(j+1));
                m[i][j]=scn.nextInt();
            }
        }
    }
    public static void displayMatrix(int[][] m){
    	int i, j;
		for (i = 0; i < m.length; i++) {
			System.out.print(" [");
			for (j = 0; j < m[i].length; j++) {
				System.out.printf("%5d",m[i][j]);
			}
			System.out.println(" ]");
		}
    }
    public static void addingMatrix(int[][] m1,int[][] m2,int[][] nm){
        for(int i=0;i<m1.length;i++){
            for(int j=0;j<m1[0].length;j++){
                nm[i][j]=m1[i][j]+m2[i][j];
            }
        }
    }
    public static void multiplicationNum(int[][] m,int num){
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                m[i][j]=num*m[i][j];
            }
        }
    }
    public static void multiplyMatrix(int[][] m1,int[][] m2,int[][] nm){
        int temp=0;
        int elem=0;
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

	public static void mainDiagonalTranspose(int[][]m, int[][]t){
        for(int i=0;i<t.length;i++){
            for(int j=0;j<t[i].length;j++){
            	t[i][j] = m[j][i];        
            }
        }
    }

    public static int choiceMenu(){
    	System.out.println("");
        System.out.println("1. Add matrices\n" +
                "2. Multiply matrix to a constant\n" +
                "3. Multiply matrices\n" +
                "4. Transpose matrix\n" +
                "0. Exit");
        System.out.println("Your choice: ");
        return scn.nextInt();
    }
}
