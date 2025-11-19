import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	static int N;
	static String str;

	public static void main(String[] args) throws IOException 
	{
		N = Integer.parseInt(br.readLine());
		str = br.readLine();

		int[] alphaCnt = new int[26];
		int start = 0;
		int curCnt = 0;
		int max = 0;

		for (int i = 0; i < str.length(); i++) 
		{
			int endChar = str.charAt(i) - 'a';

			if (alphaCnt[endChar] == 0)
				curCnt++;

			alphaCnt[endChar]++;

			while (curCnt > N) 
			{
				int startChar = str.charAt(start) - 'a';
				alphaCnt[startChar]--;

				if (alphaCnt[startChar] == 0)
					curCnt--;

				start++;
			}
			
			max = Math.max(max, i - start + 1);
		}

		System.out.println(max);
	}
}