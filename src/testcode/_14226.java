package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

import tester.Executable;

public class _14226 implements Executable {

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		int n = Integer.parseInt(br.readLine());
		int[][] check = new int[2001][2001];
		
		Queue<int[]> q = new LinkedList<>();
		// 화면, 클립보드
		q.add(new int[] {1, 0});
		check[1][0] = 1;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			if(tmp[0] == n) {
				break;
			}
			
			// 붙여넣기, 클립 보드 차있을떄.
			if(tmp[1] != 0 && tmp[0] + tmp[1] <= 2000 && check[tmp[0] + tmp[1]][tmp[1]] == 0) {
				q.add(new int[] { tmp[0] + tmp[1], tmp[1] });
				check[tmp[0] + tmp[1]][tmp[1]] = check[tmp[0]][tmp[1]] + 1;
			}
			
			// 복사, 
			
			
			
		}
	}

}
