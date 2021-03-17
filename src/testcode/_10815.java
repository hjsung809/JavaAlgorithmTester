package testcode;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

import tester.Executable;

public class _10815 implements Executable {
	static int n, m;
//	static int[] ns, ms;
	static Set<Integer> set;
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		set = new TreeSet<>();
		
		n = Integer.parseInt(br.readLine());
//		ns = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
//			ns[i] = Integer.parseInt(st.nextToken());
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		m = Integer.parseInt(br.readLine());
//		ms = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
//			ms[i] = Integer.parseInt(st.nextToken());
			bw.write(set.contains(Integer.parseInt(st.nextToken())) ? "1 " : "0 ");
		}
		
		bw.close();
		br.close();
	}

}
