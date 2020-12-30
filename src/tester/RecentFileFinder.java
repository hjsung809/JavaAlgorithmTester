package tester;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RecentFileFinder implements FileFinder{
	Path targetPath;
	File targetFile;
	
	public RecentFileFinder(Path targetPath) {
		this.targetPath = targetPath;
	}
	
	@Override
	public boolean findFile() {
		// TODO Auto-generated method stub
		File dir = targetPath.toFile();
		
		if (!dir.exists()) {
			System.out.println("해당 파일이 존재하지 않습니다.");
			return false;
		}
		
		if (!dir.isDirectory()) {
			System.out.println("해당 파일은 디렉토리가 아닙니다.");
			return false;
		}
		
		long recent = 0;
		File[] files = dir.listFiles();
		
		for (File file : files) {
			if(!file.getName().toLowerCase().endsWith(".java")) {
				continue;
			}
			
			if(file.lastModified() > recent) {
				targetFile = file;
				recent = file.lastModified();
			}
		}
		
		if (targetFile == null) {
			System.out.println("디렉토리에 유효한 파일이 존재하지 않습니다.");
			return false;
		}
		
		return true;
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		if (targetFile == null) {
			System.out.println("파일을 찾지 못했습니다.");
			return null;
		}
		
		return targetFile.getName();
	}

	@Override
	public String getClassName() {
		// TODO Auto-generated method stub		
		String fileName = getFileName();
		
		if (fileName == null) {
			return null;
		}
		
		if (!fileName.endsWith(".java")) {
			System.out.println("자바 클래스 파일이 아닙니다.");
		}
		
		return fileName.substring(0, fileName.length() - 5);
	}

	@Override
	public Path getPath() {
		String fileName = getFileName();
		
		if (fileName == null) {
			return null;
		}
		
		if (!fileName.endsWith(".java")) {
			System.out.println("자바 클래스 파일이 아닙니다.");
		}
		
		// TODO Auto-generated method stub
		return Paths.get(targetPath.toString(), fileName);
	}

}
