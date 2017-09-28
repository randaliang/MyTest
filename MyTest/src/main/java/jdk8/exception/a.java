package jdk8.exception;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class a {

	public static void a(String args[]) {
		byte[] b = new byte[1024];

		try(FileInputStream fis = new FileInputStream("my.txt"); BufferedInputStream bis = new BufferedInputStream(fis);) {
		    int data = bis.read();
		    while (data != -1) {
		        data = fis.read(b);
		    }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(new String(b));
	}
}
