package testcode;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Arrays;

import tester.Executable;

public class _11650 implements Executable {
	
	@Override
	public void main(InputStream in, OutputStream out) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out));
		br.readLine();
		
		br.lines()
			.map(s->s.split(" "))
			.map(s-> Arrays.stream(s).mapToInt(Integer::parseInt).toArray())
			.sorted((a,b) -> { 
					if(a[0] == b[0]) { 
						return a[1]  - b[1];
					} else {
						return a[0] - b[0];
					}
				}
			 )
			.forEach(a -> {
				try {
					bw.write(a[0] + " " + a[1] + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				}
			});

		bw.close();
		br.close();
	}

}
