package tester;

import java.io.InputStream;
import java.io.OutputStream;

public interface Executable {
	public void main(InputStream in, OutputStream out) throws Exception;
}
