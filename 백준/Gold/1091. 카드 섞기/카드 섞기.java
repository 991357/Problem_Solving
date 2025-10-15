import java.io.*;
import java.util.*;

public class Main {    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    
    static int N, cnt;
    static int[] sArr;
    static int[] pArr;
    static int[] cardArr;
    static int[] nArr;
    
    public static void main(String[] args) throws IOException
    {
    	N = Integer.parseInt(br.readLine());
    	sArr = new int[N];
    	pArr = new int[N];
    	st = new StringTokenizer(br.readLine());
    	for (int i = 0; i < N; i++)
    		pArr[i] = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < N; i++)
    		sArr[i] = Integer.parseInt(st.nextToken());
    	
    	cnt = 0;
    	
    	// 카드 저장
    	cardArr = new int[N];
    	nArr = new int[N];
    	for(int i = 0; i < N; i++)
    	{
    		cardArr[i] = i;
    		nArr[i] = i;
    	}
    	
    	   // 초기 상태가 이미 목표 상태인지 체크
        if(CheckpArr())
        {
            System.out.println(0);
            return;
        }
        
    	ShuffleCard();
    	
    	System.out.println(cnt);
    }
    
    private static void ShuffleCard() 
    {
    	while(true)
    	{
    		// 카드 섞기
        	int[] temp = new int[N];
        
        	// card의 i번째에 있는애가 sArr[i]번째위치로
        	for(int i = 0; i < N; i ++)
        		temp[sArr[i]] = cardArr[i];
        	
        	cardArr = temp;
        	
        	cnt++;
        	
        	// 체크
        	if(CheckpArr()) // 둘이 같아
        		break;
        	
        	// 원본으로 되돌아왔는지 체크
           	if(CheckOriginal()) // 오리지널로 되돌아옴
           	{
           		cnt = -1;
           		break;
           	}
    	}
	}

	static boolean CheckpArr()
    {
    	for(int i = 0; i < N; i++)
    	{
    		for(int j = 0; j < N; j++)
    		{
    			if(cardArr[j] == i)
    			{
    				if(j % 3 != pArr[i])
    					return false;
    				break;
    			}
    		}
    	}
    	return true;
    }

	static boolean CheckOriginal()
    {
    	for(int i = 0; i < N; i++)
    	{
    		if(cardArr[i] != nArr[i])
    			return false;
    	}
    	return true;
    }
}