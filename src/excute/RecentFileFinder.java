package excute;

import java.io.File;
import java.nio.file.Path;

import excute.Tester.FileFinder;

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
		return targetFile.getName();
	}

}
