package spring.onconditonal;

import org.junit.After;  
import org.junit.Test;  
import org.springframework.context.annotation.AnnotationConfigApplicationContext;  
  

  
public class SpringConditionalTest {  
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);  
  
    @Test  
    public void contextTest() {  
        ListService listService = context.getBean(ListService.class);  
          
        System.out.println(context.getEnvironment().getProperty("os.name")   
                + "系统下的列表命令为："   
                + listService.showListCmd());;  
    }  
  
    @After  
    public void closeContext() {  
        context.close();  
    }  
  
}  