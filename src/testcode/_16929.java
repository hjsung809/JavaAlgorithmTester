package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

import tester.Executable;

public class _16929 implements Executable {
	static int n, m;
	static char[][] arr;
	static int[][] check;
	static int[] mi = { 0, 0, 1, -1 };
	static int[] mj = { 1, -1 ,0, 0 };
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new char[n][];
		check = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		boolean hasCycle = false;
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(check[i][j] == 0) {
					if(bfs(i, j)) {
						hasCycle = true;
						break;
					}
				}
			}
		}
		
		if(hasCycle) {
			bw.write("Yes\n");
		} else {
			bw.write("No\n");
		}
		bw.close();
		br.close();	
	}
	
	public static boolean bfs(int si, int sj) {
		Queue<int[]> q = new LinkedList<int[]>();
		char target = arr[si][sj];
		
		check[si][sj] = 1;
		q.add(new int[] {si, sj});
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int ti = tmp[0];
			int tj = tmp[1];
			
			
			for(int i = 0; i < 4; i++) {
				int ci = ti + mi[i];
				int cj = tj + mj[i];
				
				if(ci >= 0 && ci < n &&
						cj >= 0 && cj < m &&
						arr[ci][cj] == target) {
					
					if(check[ci][cj] != 0) {
						if(check[ci][cj] + 1 == check[ti][tj]) {
							//이전 노드일 때
							continue;
						} else {
							//싸이클 일때.
							return true;
						}
					}
					
					check[ci][cj] = check[ti][tj] + 1;
					q.add(new int[] {ci, cj});
				}
			}
		}
		
		return false;
	}

}
