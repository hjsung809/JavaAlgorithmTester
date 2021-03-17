package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import tester.Executable;

public class _14225 implements Executable {
	static int n;
	static int[] arr;
	static boolean[] check;
	static ArrayList<Integer> list;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		check = new boolean[20*100000 + 1];
		list = new ArrayList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		backtracking(0);
		
		for(int i = 1; i <= 2000000; i++) {
			if(!check[i]) {
				bw.write(String.valueOf(i));
				break;
			}
		}
		bw.close();
		br.close();
	}
	
	public static void backtracking(int idx) {
		int sum = list.stream().reduce(0, (a,b) -> a+b);
		check[sum] = true;
		
		if(idx == n) {
			return;
		}
		
		
		backtracking(idx + 1);
		list.add(arr[idx]);
		backtracking(idx + 1);
		list.remove(list.size() - 1);
	}

}
