package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import tester.Executable;

public class _1182 implements Executable {
	static int n;
	static int s;
	static int[] arr;
	static int count;
	static int sum;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		arr =  new int[n];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		count = 0;
		sum = 0;
		dfs(0);
		
		bw.write(String.valueOf(count));
		bw.close();
		br.close();
	}
	
	static void dfs(int idx) {
		if(idx == n ) return;
		
		
		dfs(idx + 1);
		sum += arr[idx];
		if(sum == s) {
			count ++;
		}
		dfs(idx + 1);
		sum -= arr[idx];
	}
}
