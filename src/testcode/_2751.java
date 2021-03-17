package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import tester.Executable;

public class _2751 implements Executable {

	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		StringBuilder sb = new StringBuilder();
		br.readLine();
		br.lines()
			.mapToInt(Integer::parseInt)
			.sorted()
			.forEach(s-> sb.append(s).append('\n'));
		bw.write(sb.toString());
		bw.close();
		br.close();
	}

}
