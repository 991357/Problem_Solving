import java.io.*;
import java.util.*;

public class prim_adjMat
{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static int M;

	public static void main(String[] args) throws IOException
	{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		int[][] adj = new int[N][N];

		for(int i = 0; i < M; i++)
		{
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			adj[s-1][e-1] = p;
			adj[e-1][s-1] = p;
		}

		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);

		boolean[] v = new boolean[N];

		dist[0] = 0;

		for(int cnt = 0; cnt < N - 1; cnt++)
		{
			int minIdx = -1;

			int minD = Integer.MAX_VALUE;

			for(int i = 0; i < dist.length; i++)
			{
				if(!v[i] && dist[i] < minD)
				{
					minIdx = i;
					minD = dist[i];
				}
			}

			if(minIdx == -1)
				continue;

			v[minIdx] = true;

			for (int i = 0; i < v.length; i++)
			{
				if(adj[minIdx][i] != 0 && !v[i] && adj[minIdx][i] < dist[i])
					dist[i] = adj[minIdx][i];
			}
		}

		int sum = 0;

		for(int i = 0; i < dist.length; i++)
			sum += dist[i];

		System.out.println(sum);
	}
}