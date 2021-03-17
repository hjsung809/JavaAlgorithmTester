package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import tester.Executable;

public class _1780 implements Executable {
	static int n;
	static int[][] arr;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken()) + 1;
			}
		}
		
		long[] sol = partition(0, 0, n);
		bw.write(String.valueOf(sol[0]) + '\n');
		bw.write(String.valueOf(sol[1]) + '\n');
		bw.write(String.valueOf(sol[2]) + '\n');
		
		bw.close();
		br.close();
	}
	
	public static long[] partition(int si, int sj, int size) {
		long[] sum = new long[3];
		if(size == 1) {
			sum[arr[si][sj]] = 1;
			return sum;
		}
		
		int ps = size / 3;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				long[] result = partition(si + ps * i, sj + ps * j, ps);
				
				for(int z = 0; z < 3; z++) {
					sum[z] += result[z];
				}
			}
		}
		
		int total = 0;
		for(int z = 0; z < 3; z++) {
			total += sum[z];
		}
		if(total == 9) {
			for(int z = 0; z < 3; z++) {
				if(sum[z] == 9) {
					sum[z] = 1;
				}
			}
		}
		
		return sum;
	}
}
