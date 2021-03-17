package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

import tester.Executable;

public class _16947 implements Executable {
	static int n;
	static ArrayList<Integer>[] graph;
	
//	static int[] from;
	static int[] check;
	static int cyclePoint;


	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		n = Integer.parseInt(br.readLine());
		graph = new ArrayList[n + 1];
		check = new int[n + 1];
//		from = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		Arrays.fill(check, -1);
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		findCycle();
		bfs();
		
		for(int i = 1; i <= n; i++) {
			bw.write(String.valueOf(check[i]) + " ");
		}
		bw.close();
		br.close();
	}
	
	public static void findCycle() {
		check[1] = 1;
		dfs(1);
	}
	
	public static boolean dfs(int current) {
		
		for(int next : graph[current]) {
			if(check[next] == -1) {
				check[next] = current;
				
				if(dfs(next)) {
					// 사이클에 포함되면 true를 받음.	
					check[current] = 0;
					return current != cyclePoint;
				}
			} else {
				if(next == check[current]) {
					// 온 곳.
					continue;
				} else {
					//사이클.
					check[current] = 0;
					cyclePoint = next;
					return true;
				}
			}
		}
		
		return false;
	}
	
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i = 1; i <= n; i++) {
			if(check[i] == 0) {
				q.add(i);
			} else {
				check[i] = - 1;
			}
		}
		
		while(!q.isEmpty()) {
			int current = q.poll();
			
			for(int next: graph[current]) {
				if(check[next] == -1) {
					check[next] = check[current] + 1;
					q.add(next);
				}
			}
		}
	}

}
