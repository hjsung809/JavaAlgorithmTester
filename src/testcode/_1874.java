package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Stack;

import excute.Executable;


public class _1874 implements Executable{

	@Override
	public void main(InputStream in, OutputStream out) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		
		
		int n;
		int c = 1;
		Stack<Integer> stack = new Stack<>();
		StringBuffer sb = new StringBuffer();
		
		try {
			n = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < n; i++) {
				int tmp = Integer.parseInt(br.readLine());
				
				for(;c <= tmp; c++) {
					stack.add(c);
					sb.append("+\n");
				}
				
				if(!stack.empty() && stack.lastElement() == tmp) {
					stack.pop();
					sb.append("-\n");
				} else {
					sb = new StringBuffer().append("NO\n");
					break;
				}
			}
			bw.write(sb.toString());
			bw.flush();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
