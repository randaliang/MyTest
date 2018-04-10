package jdk8.fileoper;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileOperator {

	public void read(){
		byte[] data;
		try {
			data = Files.readAllBytes(Paths.get("/home/biezhi/a.txt"));
			String content = new String(data, StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			List<String> lines = Files.readAllLines(Paths.get("/home/biezhi/a.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			Path path = Paths.get("/home/biezhi/a.txt");
			OutputStream ops = Files.newOutputStream(path);
			Reader reader = Files.newBufferedReader(path);
			Writer writer = Files.newBufferedWriter(path);
			InputStream ins = Files.newInputStream(path);
			Files.createTempFile(null, null, null);
			Files.copy(null, null);
			Files.move(null, null, null);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public void test(){
	
	}
}
