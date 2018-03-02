package online.qsx.dialect;

import org.hibernate.dialect.MySQL5Dialect;

public class MySQL5MyISAMUTF8Dialect extends MySQL5Dialect  {
	
	@Override  public String getTableTypeString() {  
		return "ENGINE=MyISAM CHARSET=utf8"; 
		
	}   

}
