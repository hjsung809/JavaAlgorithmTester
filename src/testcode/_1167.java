package testcode;

import java.io.*;
import java.util.*;

import tester.Executable;


public class _1167 implements Executable {
	static int v;
	static ArrayList<int[]>[] graph;
	static boolean[] check;
	
	static int max;
	static int farthest;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		v = Integer.parseInt(br.readLine());
		graph = new ArrayList[v + 1];
		check = new boolean[v + 1];
		
		for(int i = 1; i <= v; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i = 1; i <= v; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int current = Integer.parseInt(st.nextToken());
			
			while(true) {
				int neighbor = Integer.parseInt(st.nextToken());
				if(neighbor == -1) break;
				int distance = Integer.parseInt(st.nextToken());
				graph[current].add(new int[] {neighbor, distance});				
			}
		}
		
		dfs(1, 0);
		max = 0;
		dfs(farthest, 0);
		bw.write(String.valueOf(max));
		bw.close();
		br.close();
	}
	
	static void dfs(int current, int distance) {
		check[current] = true;
		
		if(max <= distance) {
			max = distance;
			farthest = current;
		}
		
		for(int[] v : graph[current]) {
			if(!check[v[0]]) {
				dfs(v[0], distance + v[1]);
			}
		}
		check[current] = false;
	}

}
