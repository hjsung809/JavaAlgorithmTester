package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

import tester.Executable;

public class _13023 implements Executable {
	static int n;
	static int m;
//	static boolean[][] arr;
	static ArrayList<Integer>[] arr;
	static boolean[] check;
	static boolean find;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n];
		check = new boolean[n];
		find = false;
		for(int i = 0; i < n; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[a].add(b);
			arr[b].add(a);
//			arr[a][b]= true;
//			arr[b][a] = true;
		}
		
//		System.out.println();
		for(int i = 0; i < n && !find; i++) {
			check[i] = true;
			backtracking(i, 0);
			check[i] = false;
//			for(int j = 0; j < n; j++) check[j] = false;
		}
		
		if(find) {
			bw.write('1');
		} else {
			bw.write('0');
		}
		bw.close();
		br.close();
	}
	
	static void backtracking(int from, int count) {
		if(count == 4) {
			find = true;
			return;
		}
		for(int i : arr[from]) {
			if(!check[i]) {
				check[i] = true;
				backtracking(i, count + 1);
				check[i] = false;
				
				if(find) return;
			}
		}
	}

}
