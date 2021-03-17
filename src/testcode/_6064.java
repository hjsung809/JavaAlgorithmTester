package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import tester.Executable;

public class _6064 implements Executable {

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		int t = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int lcf = getLcf(M,N);
			int count = x;
			int yy = x;

//			System.out.println(gcd);
			
			while(count <= lcf) {
				if(yy % N != 0) yy = yy % N;
				else yy = N;
//				System.out.println(yy + "," + count);
				
				if(yy == y) {
					break;
				}
				count += M;
				yy += M;
			}
			
			if(count > lcf) {
				bw.write(String.valueOf(-1) + '\n');
			} else {
				bw.write(String.valueOf(count) + '\n');
			}
		}
		
		bw.close();
		br.close();
	}
	
	public static int getLcf(int m, int n) {
		return m*n / getGcd(m,n);
	}
	
	public static int getGcd(int m, int n) {
		int max = Math.max(m, n);
		int min = Math.min(m, n);
		int tmp = max % min;
		
		while(tmp != 0) {
			max = min;
			min = tmp;
			tmp = max % min;
		}
		return min;
	}

}
