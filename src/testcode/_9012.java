package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import excute.Testable;

public class _9012 implements Testable{

	@Override
	public void main(InputStream in, OutputStream out) {
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
