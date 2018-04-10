package jdk8.exception;

import java.io.FileInputStream;
import java.io.IOException;

public class NewException {

	public void newEx(){
		try {
		    Thread.sleep(20000);
		    FileInputStream fis = new FileInputStream("/a/b.txt");
		} catch (InterruptedException | IOException e) {
		    e.printStackTrace();
		}
	}
	
}
