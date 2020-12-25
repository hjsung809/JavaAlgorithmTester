package excute;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.Method;

public class Tester {
	FileFinder fileFinder;
	TestCaseManager testCaseManager;
	
	public Tester(FileFinder fileFinder, TestCaseManager testCaseManager) {
		this.fileFinder = fileFinder;
		this.testCaseManager = testCaseManager;
	}
	
	
	public boolean excute() {
		// 파일 찾기.
		if (!fileFinder.findFile()) {
			System.out.println("파일 검색에 실패하였습니다.");
			return false;
		}
		String targetFileName = fileFinder.getFileName();
		String targetClassName = targetFileName.substring(0, targetFileName.length() - 5);
		
		// 파일 실행
		System.out.println("다음 파일을 실행합니다. [" + targetClassName + "]");
		try {
			Class<?> targetClass = Class.forName("testcode." + targetClassName);
			Object obj = targetClass.getDeclaredConstructors()[0].newInstance();
			Method method = targetClass.getMethod("main", new Class[] { InputStream.class, OutputStream.class });
			
			
			 if(!testCaseManager.ready(targetClassName)) {
				 return false;
			 }
			 
			 while(testCaseManager.hasNext()) {
				 InputStream inputStream = testCaseManager.getNextInputStream();
				 OutputStream outputStream = testCaseManager.getNextOutputStream();
				 method.invoke(obj, inputStream, outputStream);
				 inputStream.close();
				 outputStream.close();
			 }
			 System.out.println("실행이 완료되었습니다.");
			 
			 if(!testCaseManager.markUp()) {
				 System.out.println("실행 결과에 문제가 있습니다.");
				 return true;
			 }
			 System.out.println("모든 테스트 케이스가 결과와 일치합니다.");
//			Object outcome = method.invoke(obj, new InputStreamReader(System.in));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public interface FileFinder{
		boolean findFile();
		String getFileName();
	}
}
