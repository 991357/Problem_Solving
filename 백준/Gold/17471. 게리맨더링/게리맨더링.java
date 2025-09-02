import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N, MIN;
	static int[] peopleArr;
	static List<Integer>[] areaArr;
	
	// 부분 집합
	static int[] arr;
	static boolean[] sel;
	
	static Deque<List<Integer>> areaDeq;
	
	public static void main(String[] args) throws IOException 
	{
		N = Integer.parseInt(br.readLine());
		MIN = Integer.MAX_VALUE;
		
		peopleArr = new int[N + 1];
		areaArr = new List[N + 1];
		for (int i = 1; i <= N; i++)
			areaArr[i] = new ArrayList<>();
		
		// 인구수
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) 
			peopleArr[i] = Integer.parseInt(st.nextToken());
		
		// 구역
		for (int i = 1; i <= N; i++) 
		{
			st = new StringTokenizer(br.readLine());
			
			int count = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < count; j++) 
				areaArr[i].add(Integer.parseInt(st.nextToken()));
		}
		//PrintInfo();
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = i + 1;
		sel = new boolean[N];
		areaDeq = new ArrayDeque<>();
		PowerSet(0);
		DivisionArea();
		System.out.println(MIN == Integer.MAX_VALUE ? -1 : MIN);
	}
	
	private static void DivisionArea() 
	{
		while(!areaDeq.isEmpty())
		{
			List<Integer> first = areaDeq.pollFirst();
			
			List<Integer> last = areaDeq.pollLast();
			
			// 구역이 이어져 있는지 확인하기
			if(!bfs(first))
				continue;
			
			if(!bfs(last))
				continue;
			
			// 둘 다 이어짐
			int firstCnt = 0, lastCnt = 0;
			for (int i = 0; i < first.size(); i++) 
				firstCnt += peopleArr[first.get(i)];
			for (int i = 0; i < last.size(); i++) 
				lastCnt += peopleArr[last.get(i)];
			
			MIN = Math.min(MIN, Math.abs(firstCnt- lastCnt));
		}
	}

	private static boolean bfs(List<Integer> group) 
	{
		Deque<Integer> bfsQ = new ArrayDeque<>();
		boolean[] v = new boolean[N + 1];
		int cnt = 1;
		v[group.get(0)] = true;
		bfsQ.offer(group.get(0));
		
		while(!bfsQ.isEmpty())
		{
			int cur = bfsQ.poll();
			
			for (int i = 0; i < areaArr[cur].size(); i++) 
			{
				if(!v[areaArr[cur].get(i)] && group.contains(areaArr[cur].get(i))) 
				{
					v[areaArr[cur].get(i)] = true;
					cnt++;
					bfsQ.offer(areaArr[cur].get(i));
				}
			}
		}
		
		return cnt == group.size();
	}

	private static void PowerSet(int idx) 
	{
		// b
		if(idx == N)
		{
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < N; i++) 
			{
				if(sel[i])
					temp.add(arr[i]);
			}
			
			if(temp.size() != 0 && temp.size() != N)
				areaDeq.offer(temp);
			
			return;
		}
		
		// i
		sel[idx] = true;
		PowerSet(idx + 1);
		
		sel[idx] = false;
		PowerSet(idx + 1);
	}
}
