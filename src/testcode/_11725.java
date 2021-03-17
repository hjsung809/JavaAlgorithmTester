package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

import tester.Executable;

public class _11725 implements Executable {
	static int n;
	static int[] check;
	static ArrayList<Integer>[] graph;

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		n = Integer.parseInt(br.readLine());
		check = new int[n + 1];
		graph = new ArrayList[n + 1];
		
		for(int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			graph[b].add(a);
		}
		
		bfs();
		for(int i = 2; i <= n; i++) {
			bw.write(String.valueOf(check[i]) + '\n');
		}
		bw.close();
		br.close();
	}
	
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		check[1] = 1;
		
		while(!q.isEmpty()) {
			int tmp = q.poll();
			
			for(int v : graph[tmp]) {
				if(check[v] == 0) {
					check[v] = tmp;
					q.add(v);
				}
			}
		}
	}
}
