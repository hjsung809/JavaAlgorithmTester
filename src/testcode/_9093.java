package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import tester.Executable;

public class _9093 implements Executable{

	@Override
	public void main(InputStream in, OutputStream out) throws Exception{
		// TODO Auto-generated method stub
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		
		OutputStreamWriter osw = new OutputStreamWriter(out);
		BufferedWriter bw = new BufferedWriter(osw);
		
		try {
			String str = br.readLine();
			String[] words;
			int n = Integer.parseInt(str);
			
			for(int i = 0; i < n; i++) {
				str = br.readLine();
				
				words = str.split(" ");
				
				StringBuffer stringBuffer = new StringBuffer(); 
				for(int j = 0; j < words.length; j++) {
					StringBuffer stringBuffer2 = new StringBuffer(); 
					stringBuffer2.append(words[j]);
					stringBuffer.append(stringBuffer2.reverse().append(" ").toString());
				}
				stringBuffer.append('\n');
				bw.write(stringBuffer.toString());
				bw.flush();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
