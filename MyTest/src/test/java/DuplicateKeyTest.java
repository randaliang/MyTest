import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class DuplicateKeyTest {

	public static void test(File file) {

		String key = "poll对应的sequence的值为--";
		Set map = new HashSet();
		try (BufferedReader br = new BufferedReader( new InputStreamReader(new FileInputStream(file), "UTF-8") ) ) {
			String str = null;
			while ( ( str = br.readLine() ) != null ) {
				if( !str.contains( key ) ){
					continue;
				}
				String s   = str.substring(str.indexOf(key) +key.length());
				if( map.contains(s) ){
					System.out.println("======" +s);
				}else{
					System.out.println("++++++" +s);
					map.add(s);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main( String args[] ) {
		String arg = "D:\\temp\\D2C2018-V01103-01023.log";
		test( new File(arg) );
	}
}
