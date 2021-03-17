package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

import tester.Executable;

public class _11723 implements Executable {

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		int n = Integer.parseInt(br.readLine());
		boolean[] set = new boolean[21];
		
		while(n-- > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String command = st.nextToken();
			
			switch(command) {
				case "all" :
					for(int i = 1; i <= 20; i++) set[i] = true;
					continue;
				case "empty" :
					for(int i = 1; i <= 20; i++) set[i] = false;
					continue;
			}
			
			int x = Integer.parseInt(st.nextToken());
			switch(command) {
				case "add" : set[x] = true; break;
				case "remove" : set[x] = false; break;
				case "check" : bw.write(set[x] ? "1\n" : "0\n");break;
				case "toggle" : set[x] = !set[x]; break;
			}
		}
		bw.close();
		br.close();
	}
}
