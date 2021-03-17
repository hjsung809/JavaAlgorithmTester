package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import tester.Executable;

public class _1697 implements Executable {
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] check = new int[100001];
		
		if(n == k) {
			bw.write("0");
		} else {
			Queue<Integer> q = new LinkedList<>();
			q.add(n);
			check[n] = 1;
			
			while(!q.isEmpty()) {
				int tmp = q.poll();
				if(tmp == k) {
					break;
				}
				
				if(tmp < 100000 && check[tmp + 1] == 0) {
					q.add(tmp + 1);					
					check[tmp + 1] = check[tmp] + 1;
				}

				if(tmp > 0 && check[tmp - 1] == 0) {
					q.add(tmp - 1);
					check[tmp - 1] = check[tmp] + 1;
				}
				
				if(tmp <= 50000 && check[tmp * 2] == 0) {
					q.add(tmp * 2);				
					check[tmp * 2] = check[tmp] + 1;
				}
			}
			bw.write((check[k] - 1) + "");
		}	
		

		bw.close();
		br.close();
	}

}
