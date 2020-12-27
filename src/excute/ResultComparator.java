package excute;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.List;

public class ResultComparator {	
	public int compare(List<Path> outputPaths, List<Path> answerPaths) {
		int successCount = 0;
		
		if (outputPaths.size() != answerPaths.size()) {
			System.out.println("출력 파일과 정답 파일의 수가 다릅니다.");
		}
		
		for(int i = 0; i < outputPaths.size(); i++) {
			File outputFile = outputPaths.get(i).toFile();
			File answerFile = answerPaths.get(i).toFile();
			
			if(!outputFile.exists() || !answerFile.exists()) {
				System.out.println("");
				continue;
			}
			
			if (compareFile(outputFile, answerFile, i)) {
				successCount++;
				System.out.println((i + 1) + "번째 테스트가 성공했습니다.");
			} else {
				System.out.println((i + 1) + "번째 테스트가 실패했습니다.");
			}
		}
		
		return successCount;
	}
	
	private boolean compareFile(File outputFile, File answerFile, int index) {

		try {
			BufferedReader tbr = new BufferedReader(new FileReader(outputFile));
			BufferedReader abr = new BufferedReader(new FileReader(answerFile));
			
			int lineNum = 1;
			String tbrLine = tbr.readLine();
			String abrLine = abr.readLine();
			
			while(tbrLine != null && abrLine != null) {
				tbrLine = tbrLine.trim();
				abrLine = abrLine.trim();
				
				if(!tbrLine.equals(abrLine)) {
					System.out.println("!" + (index + 1) + "번째 테스트 케이스의 " + lineNum + "번째 줄이 다릅니다.");
					System.out.println("출력 [" + tbrLine + "]");
					System.out.println("정답 [" + abrLine + "]");
					tbr.close();
					abr.close();
					return false;
				}
				
				lineNum++;
				tbrLine = tbr.readLine();
				abrLine = abr.readLine();
			}
			tbr.close();
			abr.close();
			
			// 두 파일 모두 끝나지 않았 때.
			if(tbrLine != null || abrLine != null) {
				System.out.println("!" + (index + 1) + "번째 테스트 케이스의 비교 파일의 줄 수가 다릅니다." + tbrLine + "," + abrLine);
				return false;
			}
		} catch(Exception e) {
			System.out.println("!" + (index + 1) + "번째 테스트 케이스에서 예외가 발생했습니다.");
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
