package tester;

import java.nio.file.Path;

public interface FileFinder {
	boolean findFile();
	String getFileName();
	String getClassName();
	Path getPath();
}
