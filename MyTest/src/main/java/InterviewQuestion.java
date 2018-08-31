import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InterviewQuestion {

	
	/**
	 * 根据制定的匹配格式查找匹配的文件
	 * @param file
	 * @param pattern
	 * @return
	 */
	public static List<File> searchMatchFile( File searchDir,String pattern ){
		//判断参数必须是文件夹，如果不是抛出异常
		if(searchDir.isFile()){
			throw new RuntimeException("传入参数必须为文件夹！");
		}
		
		List<File> fList = new ArrayList<File>();
		File fs[] = searchDir.listFiles();
		for( File f : fs ){
			//如果是文件夹则递归匹配,将结果放入返回值
			if( f.isDirectory() ){
				fList.addAll( searchMatchFile(f,pattern) );
				continue;
			}
			//如果是文件则进行匹配判断
			if( f.getName().matches(pattern) ){
				fList.add(f);
			}
		}
		
		return fList;
	}
	
	/**
	 * 图省事，直接返回list，里面有两个对象，没有新增对象
	 * 匹配步骤
	 * (1)按照文件长度分组，因为文件长度不同，肯定不会一模一样
	 * (2)对文件内容进行比较，如果内容不一致则退出
	 * @param fList
	 * @return
	 */
	public static List<File> getMatchFile( List<File> fList ){
		//保存返回值
		List<File> reList = new ArrayList<File>();
		
		//根据文件长度分组
		Map<Long,List<File>> fMap = new HashMap<Long,List<File>>();
		//保存文件对应的byte数组
		Map<Long,List<byte[]>> bytesMap = new HashMap<Long,List<byte[]>>();
		
		for( File f : fList ){
			Long key = Long.valueOf(f.length() ) ;
			//如果对应的key不存在
			if( !fMap.containsKey(key) ){
				List<File> tList = new ArrayList<File>();
				tList.add(f);
				fMap.put( key, tList );
				
			}else{
				fMap.get(Long.valueOf(f.length() ) );
				
			}
		}

		
		
		return reList;
	}
	
	public static void main( String args[] ){
		//查找文件格式为【数字.xls】的文件
		List<File> fList = searchMatchFile( new File("d:\\temp"),  "\\d+\\.xls" );
		for( File f : fList ){
			System.out.println(f.getAbsolutePath());
		}
		
		List<File> matchList = getMatchFile(fList);
		for( File f: matchList ){
			System.out.println("----"+f.getAbsolutePath());
		}
	}
	
}
