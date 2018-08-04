package spring.onconditonal;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean; 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AService implements InitializingBean,BeanFactoryAware{

	
	public AService(){
		System.out.println("AService");
	}
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("ddd");
		
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("beanFactory");
		
	}
	

}
