package com.taxation.bureau.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;

/**
 * <P>
 * 自定义Jackson对象序列化支持类
 * </p>
 * 
 * @since 1.0.0
 * @version 1.0.0
 * @author cuihc
 */
public class CustomObjectMapper extends ObjectMapper {
	/** 默认日期格式化表达式常量 */
	public static final String DEFAULT_DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/** 日期格式化表达式 */
	private String dateFormatPattern = DEFAULT_DATE_FORMAT_PATTERN;

	public CustomObjectMapper() {
		CustomSerializerFactory factory = new CustomSerializerFactory();
		// 日期类型序列化处理
		factory.addGenericMapping(Date.class, new JsonSerializer<Date>() {
			@Override
			public void serialize(Date value, JsonGenerator jsonGenerator, SerializerProvider provider)
					throws IOException, JsonProcessingException {
				SimpleDateFormat sdf = new SimpleDateFormat(dateFormatPattern);
				jsonGenerator.writeString(sdf.format(value));
			}
		});
		setSerializerFactory(factory);
	}

	/**
	 * @return the dateFormatPattern
	 */
	public String getDateFormatPattern() {
		return dateFormatPattern;
	}

	/**
	 * @param dateFormatPattern
	 *            the dateFormatPattern to set
	 */
	public void setDateFormatPattern(String dateFormatPattern) {
		this.dateFormatPattern = dateFormatPattern;
	}

}