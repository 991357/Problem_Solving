import java.io.*;
import java.util.*;

public class dijkstra_adjMat {
	static int N = 7;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		List<Integer>[] numList = new List[N + 1];
		for(int i = 1; i <= N; i++)
			numList[i] = new ArrayList<>();

		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			numList[s].add(e);
			numList[e].add(s);
		}

		// 거리 배열 (초기값 무한대)
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);

		// 방문 여부 배열
		boolean[] v = new boolean[N];

		// 시작 정점(0) 거리 0으로 설정
		dist[0] = 0;

		// 전체 정점 개수 - 1번 반복
		for (int cnt = 0; cnt < N - 1; cnt++) {
			int minIdx = -1;
			int minD = Integer.MAX_VALUE;

			// 방문하지 않은 정점 중 dist 값이 가장 작은 정점 찾기
			for (int i = 0; i < dist.length; i++) {
				if (!v[i] && dist[i] < minD) {
					minIdx = i;
					minD = dist[i];
				}
			}

			// 찾은 정점을 방문 처리
			v[minIdx] = true;

			// 거리 배열 갱신
			for (int i = 0; i < v.length; i++) {
				if (numList[minIdx].get(i) != 0 && !v[i] &&
						dist[minIdx] +numList[minIdx].get(i) < dist[i]) {
					dist[i] = dist[minIdx] + numList[minIdx].get(i);
				}
			}
		}

		// 최단 거리 출력
		System.out.println(Arrays.toString(dist));
	}
}
