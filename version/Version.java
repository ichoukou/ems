import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <dl>
 * <dt>Version</dt>
 * <dd>Description:获取版本工具 
 * 该版本工具根据svn版本以及svn版本的提交日期来生成版本号 所以,除了末位的版本号之外(本月第几次提交),无需更改</dd>
 * <dd>Copyright: Copyright (C) 2006</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2015年2月2日</dd>
 * </dl>
 * 
 * @author 安宁
 */
public class Version {
	/**
	 * 版本初始年份,通过
	 */
	public static final int FIRST_YEAR = 2011;
	/**
	 * 常量,需配合pom.xml文件使用
	 */
	public static final String SVN_DATE_NAME = "SVN-Date";
	/**
	 * 常量,需配合pom.xml文件使用
	 */
	public static final String SVN_NUM_NAME = "SVN-Revision";
	/**
	 * 常量,需配合pom.xml文件使用
	 */
	public static final String PROJET_NAME = "artifactId";
	/**
	 * 项目的全路径
	 */
	public static final String SVN_PATH = "SVN-Path";
	/**
	 * 项目描述,可以修改
	 * 会填充进"?"号位置 gls-4.4.6.1  [?][2015-06-02] SVN:3504
	 */
	public static final String PROJECT_DESC = "CCOD4.5";
	/**
	 * 当前版本发布次数,每次发布前手动进行修改 TODO
	 * 会填充进"?"号位置 gls-4.4.6.?  [CCOD4.4][2015-06-02] SVN:3504
	 */
	public static final int DEPLOY_COUNT = 1;
	private static Map<String , String > map = new HashMap<String, String>();
	static{
		URL resource = Version.class.getResource("Version.class");
		File file = new File(resource.getFile());
		File parentFile = file.getParentFile().getParentFile().getParentFile();
		String manPath = parentFile.getAbsolutePath()+"/META-INF/MANIFEST.MF";
		File f = new File(manPath);
		FileInputStream is = null;
		InputStreamReader in = null;
		BufferedReader br = null;
		try {
			is = new FileInputStream(f);
			in = new InputStreamReader(is,"UTF-8");
			br = new BufferedReader(in);
			String line = null;
			while((line = br.readLine())!=null){
				if(line != null && line.contains(":")){
					int index =  line.indexOf(":");
					map.put(line.substring(0, index).trim(), line.substring(index+1,line.length()).trim());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(br != null){
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(in != null){
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(is != null){
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * @Description: 该方法会读取配置信息,并将信息输出,会输出的格式如下
	 * VERSION : gls-4.4.6.1  [CCOD4.4][2015-06-02] SVN:3506
	 * SVNADDRESS : http://10.130.24.253/svn/CC2/CCOD4/trunk/src/web/gls
	 * 可能需要你配置的 参数有两个
	 * 1,DEPLOY_COUNT.该参数对应的是每月发布的子版本数,也就是?所指  VERSION : gls-4.4.6.?
	 * 2,PROJECT_DESC ,该参数是对一个大版本项目描述,比如 CCOD4.4
	 * @param args
	 * @throws IOException void
	 * @throws
	 * @author 安宁 2015年6月2日
	 */
	public static void main(String[] args) throws IOException {
		String version = String.format("%s-%s  [%s][%s] SVN:%s",
				map.get(PROJET_NAME),
				getNow(DEPLOY_COUNT),
				PROJECT_DESC,
				getSVNDate(),
				map.get(SVN_NUM_NAME)
				);
		System.out.println("VERSION : "+version);
		System.out.println("SVNADDRESS : "+map.get(SVN_PATH));
	}
	private static String getSVNDate(){
		String dateStr = map.get(SVN_DATE_NAME);
		return dateStr.substring(0, dateStr.indexOf(" "));
	}
	/**
	 * @Description: 得到svn的版本号
	 * @param depoyCount 本月第几次提交
	 * @return String
	 * @throws
	 * @author 安宁 2015年2月2日
	 */
	private static String getNow(int depoyCount){
		String dateStr = map.get(SVN_DATE_NAME);
		String newDateStr = dateStr.substring(0, 19);
		Calendar ca = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = sdf.parse(newDateStr);
			ca = Calendar.getInstance();
			ca.setTime(date);
			int year = ca.get(Calendar.YEAR);
			int manth = ca.get(Calendar.MONTH)+1;
			int first = year - FIRST_YEAR;
			return String.format("%s.%s.%s.%s", 4,first,manth,depoyCount);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "error Time";
	}
}
