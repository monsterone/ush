package online.qsx.test;

import org.hibernate.Session; 
import org.hibernate.SessionFactory; 
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import online.qsx.model.UserModel; 

public class Test { 
	public static void main(String[] args) {  
		//加载配置文件
		Configuration configuration=new Configuration(); 
		configuration.configure("hibernate.cfg.xml");    
		//注册标准服务 
        StandardServiceRegistryBuilder ssrb=new StandardServiceRegistryBuilder(); 
		StandardServiceRegistry ssr=ssrb.applySettings(configuration.getProperties()).build();   
		//通过标准服务加载配置文件后获得会话工厂  
		SessionFactory sf=configuration.buildSessionFactory(ssr);//二级缓存   
		//开启一个会话
        Session session=sf.openSession();//一级缓存    
       //操作  
        System.out.println("连接开启成功");   
        
        UserModel userModel=(UserModel)session.get(UserModel.class, 2); 
        
     
       //关闭 
        session.close();  
         sf.close();     
       System.out.println("连接关闭成功");  
 
     	} 
	}
