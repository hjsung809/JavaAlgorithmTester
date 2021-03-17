package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

import tester.Executable;

public class _1976 implements Executable {

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		Set set = new Set(n);
		int[] d = new int[m];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				String tmp = st.nextToken();
//				System.out.println(i + "," + j + "," + tmp);
				if(j > i && tmp.equals("1")) {
					set.union(i, j);
//					System.out.println(i + "," + j);
				}
			}
		}
		
		boolean avail = true;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			d[i] = Integer.parseInt(st.nextToken()) - 1;
			if(i > 0) {
				if(set.find(d[i - 1]) != set.find(d[i])) {
					avail = false;
					break;
				}
			}
		}
		
		if(avail) {
			bw.write("YES\n");
		}else {
			bw.write("NO\n");
		}
		bw.close();
		br.close();
	}
	
	public static class Set {
		int arr[];
		Set(int size) {
			arr = new int[size];
			Arrays.fill(arr, -1);
		}
		
		public int find(int num) {
			if(arr[num] == -1) return num;
			return arr[num] = find(arr[num]);
		}
		
		public void union(int a, int b) {
			int pa = find(a);
			int pb = find(b);
			
			if(pa != pb) {
				arr[pa] = pb;
			}
		}
	}
}
