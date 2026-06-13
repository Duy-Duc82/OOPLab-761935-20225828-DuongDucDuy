import java.util.Scanner;

public class MatrixAddition {
    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Enter row: ");
        int n = keyboard.nextInt();
        System.out.print("Enter column: ");
        int m = keyboard.nextInt();

        int[][] a=new int[n][m];
        int[][] b=new int[n][m];
        int[][] c=new int[n][m];

        System.out.println("Enter elements of matrix a: ");
        for (int i = 0; i < n; i++) {
            for(int j=0; j<m;j++){
                a[i][j] = keyboard.nextInt();
            }
        }
        System.out.println("Enter elements of matrix b: ");
        for (int i = 0; i < n; i++) {
            for(int j=0; j<m;j++){
                b[i][j] = keyboard.nextInt();
            }
        }   
        keyboard.close();

        for (int i = 0; i < n; i++) {
            for(int j=0; j<m;j++){
                c[i][j]=a[i][j]+b[i][j];
            }
        }

        System.out.println("Result: ");
        for (int i = 0; i < n; i++) {
            for(int j=0; j<m;j++){
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        System.exit(0);
        }

}
