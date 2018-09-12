package com.superhope.mvcconfig;


import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.filter.HttpPutFormContentFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableWebMvc
public class MvcConfiguration extends WebMvcConfigurerAdapter {
    
    /**
     * 支持PUT请求
     */
    @Bean
    public FilterRegistrationBean httpPutFormContentFilter() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setOrder(2);
        registrationBean.setFilter(new HttpPutFormContentFilter());
        registrationBean.addUrlPatterns("/*");
        registrationBean.addInitParameter("exclusions",
                "*.js,*.gif,*.jpg,*.png,*.css,*.ico,*.html");
        return registrationBean;
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration addInterceptor = registry.addInterceptor(new LogHandlerInterceptor());
//	   	 // 排除配置
		 addInterceptor.excludePathPatterns("/info");
	     addInterceptor.excludePathPatterns("/swagger**/**");
	     addInterceptor.excludePathPatterns("/error");
        super.addInterceptors(registry);
    };

    /**
     * 跨域请求
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*").allowedHeaders("*")
                .allowCredentials(true).maxAge(3600).allowedMethods("OPTIONS",
                        "OPTIONS", "GET", "POST", "DELETE", "PUT");
        super.addCorsMappings(registry);
    }
    
    @Bean
	public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
    	//json 日期转换
		ObjectMapper objectMapper = new CustomObjectMapper();
		//忽略没有的字段
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		MappingJackson2HttpMessageConverter mappingJsonpHttpMessageConverter = new MappingJackson2HttpMessageConverter(
				objectMapper);
		return mappingJsonpHttpMessageConverter;
	}
    
    @Override
    public void configureMessageConverters(
            List<HttpMessageConverter<?>> converters) {
    	converters.add(0, getMappingJackson2HttpMessageConverter());
        super.configureMessageConverters(converters);
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    

	@Override  
    public void addResourceHandlers(ResourceHandlerRegistry registry) {  
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/").setCachePeriod(0); 
	}
	
  
}