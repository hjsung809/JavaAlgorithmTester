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

public class _16197 implements Executable {
	static int n, m;
	static int[][] arr;
	static ArrayList<int []> coins;
	static int[][][][] check;
	
	static int[] di = {1, -1, 0, 0};
	static int[] dj = {0,  0,-1, 1};
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		coins = new ArrayList<int[]>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		check = new int[n][m][n][m];
		
		for(int i = 0; i < n; i++) {
			String tmp = br.readLine();
			for(int j = 0; j < m; j++) {
				arr[i][j] = tmp.charAt(j);
				
				if(arr[i][j] == 'o') {
					arr[i][j] = '.';
					coins.add(new int[] {i, j});
				}
			}
		}
		
		int sol = search();
		bw.write(String.valueOf(sol));
		
		br.close();
		bw.close();
	}
	
	public static int search() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {
			coins.get(0)[0],
			coins.get(0)[1],
			coins.get(1)[0],
			coins.get(1)[1]
			});
		check[coins.get(0)[0]][coins.get(0)[1]][coins.get(1)[0]][coins.get(1)[1]] = 1;
		
		while(!q.isEmpty()) {
			int[] c = q.poll();
			
			if(check[c[0]][c[1]][c[2]][c[3]] > 11) {
				
			}
			
			
			// 내 방향으로 이동.
			for(int i = 0; i < di.length; i++) {
				// 아
				int i1 = c[0] + di[i];
				int j1 = c[1] + dj[i];
				int i2 = c[2] + di[i];
				int j2 = c[3] + dj[i];
				
				boolean alive1 = i1 >=0 && i1 < n && j1 >= 0 && j1 <= m;
				boolean alive2 = i2 >=0 && i2 < n && j2 >= 0 && j2 <= m;
				
				if(alive1 ^ alive2) {
					return check[c[0]][c[1]][c[2]][c[3]] + 1;
				}
				else if(alive1 && alive2) {
					check[i1][j1][i2][j2] = check[c[0]][c[1]][c[2]][c[3]] + 1;
					q.add(new int[] {i1, j1, i2, j2});					
				}
			}
		}
		
		return -1;
	}

}
