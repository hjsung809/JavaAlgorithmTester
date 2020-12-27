package excute;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.nio.file.Path;
import java.util.List;

public class Executor {	
	private String pakageName;
	
	public Executor(String pakageName) {
		this.pakageName = pakageName;
	}
	
	
	public boolean excute(String targetClassName, List<Path> inputPaths, List<Path> outputPaths) {
		if (inputPaths.size() != outputPaths.size()) {
			System.out.println("잘못된 테스트 케이스 경로입니다.");
			return false;
		}
		
		// 실행
		try {
			Class<?> targetClass = Class.forName(pakageName + "." + targetClassName);
			Object obj = targetClass.getDeclaredConstructors()[0].newInstance();
			Method method = targetClass.getMethod("main", new Class[] { InputStream.class, OutputStream.class });
			
			for(int i = 0; i < inputPaths.size(); i++) {
				InputStream inputStream = new FileInputStream(inputPaths.get(i).toFile());
				OutputStream outputStream = new FileOutputStream(outputPaths.get(i).toFile());
				method.invoke(obj, inputStream, outputStream);
				inputStream.close();
				outputStream.close();
			}
			
//			 System.out.println("실행이 완료되었습니다.");
//			 
//			 if(!testCaseManager.markUp()) {
//				 System.out.println("실행 결과에 문제가 있습니다.");
//				 return true;
//			 }
//			 System.out.println("모든 테스트 케이스가 결과와 일치합니다.");
//			Object outcome = method.invoke(obj, new InputStreamReader(System.in));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
