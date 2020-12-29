package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import tester.Executable;

public class _9012 implements Executable{

	@Override
	public void main(InputStream in, OutputStream out) throws Exception{
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		
		
		OutputStreamWriter osw = new OutputStreamWriter(out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String tmp = br.readLine();
			int n = Integer.parseInt(tmp);
			
			for(int i = 0; i < n; i++) {
				tmp = br.readLine();
				if(isVSR(tmp)) {
					bw.write("YES\n");
				} else {
					bw.write("NO\n");
				}
			}
			bw.flush();
			
			br.close();
			bw.close();
		} catch(Exception e) {
			e.printStackTrace();
		} 
	}
	
	private static boolean isVSR(String tmp) {
		int num = 0;
		
		for(int i = 0; i < tmp.length(); i++) {
			char c = tmp.charAt(i);
			
			if (c == '(') {
				num++;
			} else {
				num--;
			}
			
			if (num < 0) {
				return false;
			}
		}
		
		return num == 0;
	}
}
