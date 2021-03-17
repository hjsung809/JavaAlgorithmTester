package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

import tester.Executable;

public class _16940 implements Executable {
	static int n;
	static ArrayList<Integer>[] graph;
	static boolean[] check;
	static int[] answer;
	static int[] tmp;
	static int tmpCount;
	
	static int[] order;
	
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		n = Integer.parseInt(br.readLine());
		graph = new ArrayList[n + 1];
		check = new boolean[n + 1];
		answer = new int[n + 1];
		tmp = new int[n + 1];
		tmpCount = 1;
		order = new int[n + 1];
		
		for(int i = 1; i<= n; i++) graph[i] = new ArrayList<>();
		
		for(int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			answer[i] = Integer.parseInt(st.nextToken());
			order[answer[i]] = i;
		}
		
		for(int i = 1; i <= n; i++) {
			Collections.sort(graph[i], (a,b) -> order[a] - order[b]);
		}
		
		
		bw.write(solution() ? "1" : "0");
		
		br.close();
		bw.close();
	}
	
	public static boolean solution() {
		if(answer[1] != 1) return false;
		
		check[1] = true;
		tmp[tmpCount++] = 1;
		dfs(1);
		
		for(int i = 1; i <= n; i++) {
			if(tmp[i] != answer[i]) return false;
		}
		return true;
	}
	
	
	public static void dfs(int c) {
		for(int v : graph[c]) {
			if(!check[v]) {
				check[v] = true;
				tmp[tmpCount++] = v;
				dfs(c);
			}
		}
	}
	
}
