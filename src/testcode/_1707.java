package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import tester.Executable;

public class _1707 implements Executable {
	static int n, m ;
	static boolean avail;
//	static int[][] set;
	static ArrayList<Integer>[] graph;
	static int[] check;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			graph = new ArrayList[n + 1];
			check = new int[n + 1];
			
			Arrays.fill(check, -1);
			for(int i = 1; i <= n; i++) graph[i] = new ArrayList<>();
			
			avail = true;
//			set = new int[n + 1][2];
			while(m-- > 0) {
				String tmp = br.readLine();
				st = new StringTokenizer(tmp);
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				graph[b].add(a);
			}
			
			for(int i = 1; i <= n; i ++) {
				if(check[i] == -1) {
					bfs(i);
					if(!avail) break;
				}
			}
			
			bw.write(avail ? "YES\n" :  "NO\n");
		}
		
		bw.close();
		br.close();
	}
	
	public static void bfs(int from) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(from);
		check[from] = 0;
		
		while(!q.isEmpty()) {
			int e = q.poll();
			
			for(int v : graph[e]) {
				if(check[v] == -1) {
					check[v] = check[e] + 1;
					q.add(v);
				} else {
					if(check[v] % 2 == check[e] % 2) {
						avail = false;
						return;
					}
				}
			}
		}
	}

}
