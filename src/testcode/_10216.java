package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

import tester.Executable;

public class _10216 implements Executable {
	public static int[] set; 
	public static int  count;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		int t = Integer.parseInt(br.readLine());
		
		
		
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			set = new int[n];
			count = n;
			Arrays.fill(set, -1);
			ArrayList<int[]> list = new ArrayList<>();
			
			for(int i = 0 ; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int[] Ai = new int[3];
				Ai[0] = Integer.parseInt(st.nextToken());
				Ai[1] = Integer.parseInt(st.nextToken());
				Ai[2] = Integer.parseInt(st.nextToken());
				
				for(int j = 0; j < i; j++) {
					int[] Aj = list.get(j);
					if(calDistance(Ai, Aj) <= Ai[2] + Aj[2]) {
						union(i, j);
					}
				}
				list.add(Ai);
			}
			
			bw.write(String.valueOf(count) + '\n');
		}
		
		br.close();
		bw.close();
	}
	
	public static double calDistance(int[] A1, int[] A2) {
		return Math.sqrt((A1[0] - A2[0])* (A1[0] - A2[0]) + (A1[1] - A2[1])*(A1[1] - A2[1]));
	}
	
	public static int find(int num) {
		if(set[num] == -1) return num;
		return set[num] = find(set[num]);
	}
	
	public static void union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		
		if(pa != pb) {
			set[pb] = pa;
			count --;
		}
	}
}
