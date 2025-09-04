import java.io.*;
import java.util.*;

public class Solution {
	static class Desk
	{
		int no, needTime, customerTime; // 창구 번호, 소요 시간, 고객이 들어오고 얼마나 지났나
		boolean isCustomer; // 고객이 있나?
		Customer customer; // 고객
		
		// 생성자
		public Desk(int no, int needTime) 
		{
			this.no = no;
			this.needTime = needTime;
			this.isCustomer = false;
		}
		
		// 고객 받아라
		public void SetCustomer(Customer customer)
		{
			this.isCustomer = true;
			this.customer = customer;
			customerTime = 0;
		}
		
		public boolean OneHour()
		{
			customerTime++;
			
			return (CheckCustomer());
		}
		
		// 이 고객이 이제 나가야 되는지
		public boolean CheckCustomer()
		{
			if(customerTime == needTime)
				return true;
			else
				return false;
		}
	}
	
	static class Customer
	{
		int no, arrivalTime; // 고객번호, 도착시간
		int receptionNo, repairNo; // 이용 접수 창구 번호, 이용 정비 창구 번호

		public Customer(int no, int arrivalTime) 
		{
			this.no = no;
			this.arrivalTime = arrivalTime;
		}
		
		// 얘가 a접수 창구, b정비 창구를 이용한 고객인가?
		public boolean CheckCustomer(int a, int b)
		{
			if(receptionNo == a && repairNo == b)
				return true;
			else
				return false;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static int T, N, M, K, A, B; // 접수 창구의 수, 정비 창구의 수, 고객 수, 타겟접수, 타겟 정비
	static Desk[] receptionDeskArr;
	static Desk[] repairDeskArr;
	static Customer[] customerArr;
	static Deque<Customer> receptionWaitingDeq;
	static Deque<Customer> repairWaitingDeq;
	
	static int endCustomerCnt, ans, nowTime;

    public static void main(String[] args) throws IOException 
    {
    	T= Integer.parseInt(br.readLine());
    	
    	for (int t = 1; t <= T; t++) 
    	{
    		st = new StringTokenizer(br.readLine());
    		
    		N = Integer.parseInt(st.nextToken());
    		M = Integer.parseInt(st.nextToken());
    		K = Integer.parseInt(st.nextToken());
    		A = Integer.parseInt(st.nextToken());
    		B = Integer.parseInt(st.nextToken());
    		
    		// 변수 초기화 여기서
    		ans = 0;
    		nowTime = 0;
    		endCustomerCnt = 0;
    		
    		receptionDeskArr = new Desk[N];
    		repairDeskArr = new Desk[M];
    		customerArr = new Customer[K];
    		
    		// 접수 창구 만들기
    		st = new StringTokenizer(br.readLine());
    		for (int i = 0; i < N; i++) 
    			receptionDeskArr[i] = new Desk(i + 1, Integer.parseInt(st.nextToken()));
    		
    		// 정비 창구 만들기
    		st = new StringTokenizer(br.readLine());
    		for (int i = 0; i < M; i++)
    			repairDeskArr[i] = new Desk(i + 1, Integer.parseInt(st.nextToken()));
    		
    		// 고객 만들기
    		st = new StringTokenizer(br.readLine());
    		for (int i = 0; i < K; i++)
    			customerArr[i] = new Customer(i + 1, Integer.parseInt(st.nextToken()));
    		
    		receptionWaitingDeq = new ArrayDeque<>();
    		repairWaitingDeq = new ArrayDeque<>();
    		
    		while(endCustomerCnt != K)
    		{
    			// 현재 시간에 도착한 고객들 접수 창고에 넣어
    			for (int i = 0; i < K; i++) 
    			{
    				if(customerArr[i].arrivalTime == nowTime)
    					receptionWaitingDeq.add(customerArr[i]);
				}
    			
    			// 한시간이 지났다
    			PriorityQueue<Customer> tempPq = new PriorityQueue<>( new Comparator<Customer>() {
					@Override
					public int compare(Customer o1, Customer o2) 
					{
						return Integer.compare(o1.receptionNo, o2.receptionNo);
					}
    			} );
    			
    			// 응대 시간 끝난 애들은 나가라
    			for (int i = 0; i < receptionDeskArr.length; i++) 
    			{
    				if(receptionDeskArr[i].customer != null)
    				{
    					if(receptionDeskArr[i].OneHour()) // true == 응대 시간 끝남
    					{
    						// 얘는 이제 정비소로 옮기세요
    						tempPq.add(receptionDeskArr[i].customer);
    						receptionDeskArr[i].customer = null;
    						receptionDeskArr[i].isCustomer = false;
    					}
    				}
				}
    			
    			// 응대 시간 끝난 애들은 나가라
    			for (int i = 0; i < repairDeskArr.length; i++) 
    			{
    				if(repairDeskArr[i].customer != null)
    				{
    					if(repairDeskArr[i].OneHour()) // true == 응대 시간 끝남
    					{
    						repairDeskArr[i].customer = null;
    						repairDeskArr[i].isCustomer = false;
    						endCustomerCnt++; // 고객 한명 끝냄
    					}
    				}
				}
    			
    			// 정비 창고로 가야 되는 애들 정비 창고 대기소로 보낼게요
    			while(!tempPq.isEmpty())
    			{
    				repairWaitingDeq.offer(tempPq.poll());
    			}
    			
    			// 접수 창고에 애들 배치
    			if(receptionWaitingDeq.size() != 0)
    			{
    	  			for (int i = 0; i < receptionDeskArr.length; i++) 
        			{
        				// 놀고 있는 창구에 고객 집어 넣기
        				if(receptionDeskArr[i].customer == null && receptionWaitingDeq.size() != 0)
        				{
        					Customer c = receptionWaitingDeq.poll();
        					receptionDeskArr[i].SetCustomer(c);
        					c.receptionNo = receptionDeskArr[i].no; // 이 고객이 이용한 접수 창구
        				}
        			}
    			}
    			
    			// 정비 창고에 애들 배치
    			for (int i = 0; i < repairDeskArr.length; i++) 
    			{
    				if(repairDeskArr[i].customer == null && repairWaitingDeq.size() != 0)
    				{
    					Customer c = repairWaitingDeq.poll();
    					repairDeskArr[i].SetCustomer(c);
    					c.repairNo = repairDeskArr[i].no; // 이 고객이 이용한 정비 창구
    				}
				}
    			
    			nowTime++; // 한시간이 지났다.
    		}
    		
    		// 고객들 중에서 A = reception, B = repair 애들 찾기
    		for (int i = 0; i < customerArr.length; i++) 
    		{
    			if(customerArr[i].receptionNo == A && customerArr[i].repairNo == B)
    				ans += customerArr[i].no;
			}
    		
    		sb.append("#").append(t).append(" ").append(ans == 0 ? -1 : ans).append("\n");
    	}
    	
    	if(sb.length() > 0)
    		sb.setLength(sb.length() - 1);
    	
    	System.out.println(sb);
    }
}
