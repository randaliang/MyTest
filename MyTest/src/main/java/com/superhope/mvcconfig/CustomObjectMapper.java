package com.superhope.mvcconfig;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

/**
 * json日期转换
 * 
 * @author hui
 *
 */
public class CustomObjectMapper extends ObjectMapper {
	
	/**
     * 
     */
    private static final long serialVersionUID = 1725608671662296536L;
	private static final DateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	private static final DateFormat TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public CustomObjectMapper() {
		super();
		configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
		configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		setDateFormat(DATE_FORMAT);
		SimpleModule simpleModule = new SimpleModule();
		simpleModule.addSerializer(Date.class, new DateSerializer(false, TIME_FORMAT));
		this.registerModule(simpleModule);
	}
}
