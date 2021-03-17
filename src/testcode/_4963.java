package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import tester.Executable;

public class _4963 implements Executable {
	static int w;
	static int h;
	static int[][] arr;
	static boolean[][] check;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) break;
			arr = new int[h][w];
			check = new boolean[h][w];
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int count = 0;
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(!check[i][j] && arr[i][j] == 1) {
						count ++;
						bfs(i, j);
//						System.out.println(i + "," + j);
					}
				}
			}
			
			bw.write(String.valueOf(count) + '\n');
		}
		bw.close();
		br.close();
	}
	
	public static void bfs(int si, int sj) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {si, sj});
		check[si][sj] = true;
		
		while(!q.isEmpty()) {
			int[] e = q.poll();
			int ti = e[0];
			int tj = e[1];
//			System.out.println(ti + "," + tj);
			
			int di = ti - 1 >= 0 ? ti - 1 : 0;
			int ui = ti + 1 < h ? ti + 1 : h - 1;
			
			int dj = tj - 1 >= 0 ? tj - 1 : 0;
			int uj = tj + 1 < w ? tj + 1 : w - 1;
			
			for(int i = di; i <= ui; i++ ) {
				for(int j = dj; j <= uj; j++) {
					if(!check[i][j] && arr[i][j] == 1) {
						
						check[i][j] = true;
						bfs(i, j);
					}
				}
			}
		}
		
	}

}
