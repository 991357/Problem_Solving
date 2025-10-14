import java.io.*;
import java.util.*;

public class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int[][] sudokuArr;
    
    public static void main(String[] args) throws IOException
    {
        sudokuArr = new int[9][9];
        for (int i = 0; i < 9; i++) 
        {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++)
                sudokuArr[i][j] = Integer.parseInt(st.nextToken());
        }
        
        findValue(0, 0);
        
        PrintArr();
    }
    
    private static boolean findValue(int x, int y)
    {
        if (x == 9)
            return true;
        
        int nextX = (y == 8) ? x + 1 : x;
        int nextY = (y == 8) ? 0 : y + 1;
        
        // 이미 있음
        if (sudokuArr[x][y] != 0)
            return findValue(nextX, nextY);
        
        for (int i = 1; i <= 9; i++)
        {
            if (CheckRow(x, y, i) && CheckCol(x, y, i) && CheckThree(x, y, i))
            {
                sudokuArr[x][y] = i;
                
                if (findValue(nextX, nextY))
                    return true;
                
                sudokuArr[x][y] = 0;
            }
        }
        
        return false;
    }
    
    private static void PrintArr() 
    {
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
                sb.append(sudokuArr[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    static boolean CheckCol(int x, int y, int val)
    {
        for (int i = 0; i < 9; i++)
        {
            if (sudokuArr[x][i] == val)
                return false;
        }
        return true;
    }
    
    static boolean CheckRow(int x, int y, int val)
    {
        for (int i = 0; i < 9; i++)
        {
            if (sudokuArr[i][y] == val)
                return false;
        }
        return true;
    }
    
    static boolean CheckThree(int x, int y, int val)
    {
        int startRow = (x / 3) * 3;
        int startCol = (y / 3) * 3;
        
        for (int i = startRow; i < startRow + 3; i++) 
        {
            for (int j = startCol; j < startCol + 3; j++) 
            {
                if (sudokuArr[i][j] == val)
                    return false;
            }
        }
        
        return true;
    }
}