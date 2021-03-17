package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

import tester.Executable;

public class _7562 implements Executable {
	static int I;
	static int[][] check;
	static int si, sj;
	static int ei, ej;
	
	static int[] mi = { 1, 2, -1, 2, -2, 1, -1, -2 };
	static int[] mj = { 2, 1, 2, -1, 1, -2, -2, -1 };
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			I = Integer.parseInt(br.readLine());
			check = new int[I][I];
			
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			si = Integer.parseInt(st.nextToken());
			sj = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			ei = Integer.parseInt(st.nextToken());
			ej = Integer.parseInt(st.nextToken());
			
			bfs();
			bw.write(String.valueOf(check[ei][ej] - 1) + '\n');
		}
		bw.close();
		br.close();
	}
	
	static void bfs() {		
		Queue<int[]> q = new LinkedList<>();
		check[si][sj] = 1;
		q.add(new int[] {si, sj});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int ti = tmp[0];
			int tj = tmp[1];
			
			if(ti == ei && tj == ej) return;
			
			for(int i = 0; i < 8; i++) {
				int ci = ti + mi[i];
				int cj = tj + mj[i];
				
				if(ci >= 0 && ci < I &&
						cj >= 0 && cj < I && 
							check[ci][cj] == 0) {
					check[ci][cj] = check[ti][tj] + 1;
					q.add(new int[] {ci, cj});
				}
			}
		}
		
	}

}
