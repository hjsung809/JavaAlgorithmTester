package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import tester.Executable;

public class _1260 implements Executable {
	static int n, m , v;
	static ArrayList<Integer>[] arr;
	static StringBuilder sb;

	static boolean[] check;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		arr = new ArrayList[n + 1];
		check = new boolean[n + 1];
		
		
		for(int i = 1; i <= n; i++) arr[i] = new ArrayList<>();
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			arr[a].add(b);
			arr[b].add(a);
		}
		for(int i = 1; i <= n; i++) Collections.sort(arr[i]);
		
		sb.append(v).append(" ");
		check[v] = true;
		dfs(v);
		bw.write(sb.append('\n').toString());
		
		Arrays.fill(check, false);
		sb = new StringBuilder();
		bfs(v);
		bw.write(sb.append('\n').toString());
		
		bw.close();
		br.close();
	}
	
	public static void dfs(int from) {
		for(int v : arr[from]) {
			if(!check[v]) {
				check[v] = true;
				sb.append(v).append(" ");
				dfs(v);
//				check[v] = false;
			}
		}
	}
	
	public static void bfs(int from) {
		Queue<Integer> q = new LinkedList<Integer>();
		check[from] = true;
		q.add(from);

		
		while(!q.isEmpty()) {
			int c = q.poll();
			sb.append(c).append(" ");
			
			for(int v : arr[c]) {
				if(!check[v]) {
					check[v] = true;
					q.add(v);					
				}
			}
		}
		
	}

}
