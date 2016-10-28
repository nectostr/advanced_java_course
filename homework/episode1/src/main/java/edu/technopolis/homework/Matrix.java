import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by Любовь on 21.10.2016.
 */
public class Matrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int N  =  in.nextInt();
            int M  =  in.nextInt();
            int X  =  in.nextInt();
            int Y  =  in.nextInt();
            int[][] arrA = new int[N][M];
            int[][] arrB = new int[X][Y];
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < M; j++)
                {
                    arrA[i][j] = in.nextInt();
                }
        }
        for (int i = 0; i < X; i++)
        {
            for (int j = 0; j < Y; j++)
            {
                arrB[i][j] = in.nextInt();
            }
        }
        if (M != X) out.println("Невозможно вычислить произведение") ;
        else {
            int[][] res = new int[N][Y];
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < Y; j++)
                {
                     for (int k = 0; k < X; k++)
                     {
                         res[i][j] += arrA[i][k]*arrB[k][j];
                     }
                }
            }
            for (int i = 0; i < X; i++)
            {
                for (int j = 0; j < Y; j++)
                {
                    out.print(res[i][j] + " ");
                }
                out.println("");
            }
        }
        out.flush();
    }
}
