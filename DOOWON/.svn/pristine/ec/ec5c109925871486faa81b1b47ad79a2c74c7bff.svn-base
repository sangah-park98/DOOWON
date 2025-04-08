package egovframework.pf.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;




public class CollectionsUtil {
	
	/*
	 * vo를 map형식으로 변환해서 반환
	 * @param vo VO
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> voToMap(Object vo) throws Exception {
	    return domainToMapWithExcept(vo, null);
	}

	/**
	 * 특정 변수를 제외해서 vo를 map형식으로 변환해서 반환.
	 * @param vo VO
	 * @param arrExceptList 제외할 property 명 리스트
	 * @return
	 * @throws Exception
	 */
	public static Map<String, Object> domainToMapWithExcept(Object vo, String[] arrExceptList) throws Exception {
	    Map<String, Object> result = new HashMap<String, Object>();
	    BeanInfo info = Introspector.getBeanInfo(vo.getClass());
	    for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
	        Method reader = pd.getReadMethod();
	        if (reader != null) {
	            if(arrExceptList != null && arrExceptList.length > 0 && isContain(arrExceptList, pd.getName())) continue;
	            result.put(pd.getName(), reader.invoke(vo));
	        }
	    }
	    return result;
	}
	public static Boolean isContain(String[] arrList, String name) {
	    for (String arr : arrList) {
	        if (StringUtils.contains(arr, name))
	            return true;
	    }
	    return false;
	}
	
	
	
	/**
     * bean to map 함수
     *
     * @param bean
     * @return
     */
    public static Map<String, Object> beanToMap(Object bean) {
        Map<String, Object> map = new HashMap<String, Object>();
 
        putValues(bean, map, null, false, false);
 
        return map;
    }
 
    /**
     * bean to map 함수
     *
     * @param bean
     * @param prefixOverrides 제거할 prefix 문자열 (ex. sch_)
     * @return
     */
    public static Map<String, Object> beanToMap(Object bean, String prefixOverrides) {
        Map<String, Object> map = new HashMap<String, Object>();
 
        putValues(bean, map, prefixOverrides, false, false);
 
        return map;
    }
 
    /**
     * bean to map 함수 (key : 대문자)
     *
     * @param bean
     * @return
     */
    public static Map<String, Object> beanToMapKeyUpperCase(Object bean) {
        Map<String, Object> map = new HashMap<String, Object>();
 
        putValues(bean, map, null, true, false);
 
        return map;
    }
 
    /**
     * bean to map 함수 (key : 대문자)
     *
     * @param bean
     * @param prefixOverrides 제거할 prefix 문자열 (ex. sch_)
     * @return
     */
    public static Map<String, Object> beanToMapKeyUpperCase(Object bean, String prefixOverrides) {
        Map<String, Object> map = new HashMap<String, Object>();
 
        putValues(bean, map, prefixOverrides, true, false);
 
        return map;
    }
 
    /**
     * bean to map 함수 (key : camelCase)
     *
     * @param bean
     * @return
     */
    public static Map<String, Object> beanToMapKeyCamelCase(Object bean) {
        Map<String, Object> map = new HashMap<String, Object>();
 
        putValues(bean, map, null, false, true);
 
        return map;
    }
 
    /**
     * bean to map 함수 (key : camelCase)
     *
     * @param bean
     * @param prefixOverrides 제거할 prefix 문자열 (ex. sch_)
     * @return
     */
    public static Map<String, Object> beanToMapKeyCamelCase(Object bean, String prefixOverrides) {
        Map<String, Object> map = new HashMap<String, Object>();
 
        putValues(bean, map, prefixOverrides, false, true);
 
        return map;
    }
 
    /**
     * Map에 값 셋팅
     *
     * @param bean
     * @param map
     * @param prefixOverrides  제거할 prefix 문자열 (ex. sch_)
     * @param keyUpperCase
     * @param camelCase
     * @return
     */
    private static void putValues(Object bean, Map<String, Object> map, String prefixOverrides, boolean keyUpperCase, boolean camelCase) {
 
        Class<?> cls = bean.getClass();
 
        for (Field field : cls.getDeclaredFields()) {
            field.setAccessible(true);
 
            Object value = null;
            String key;
 
            try {
                value = field.get(bean);
            } catch (IllegalArgumentException e) {
                System.out.println("Exception position : CollectionsUtil - putValues(Object bean, Map<String, Object> map, String prefix)");
            } catch (IllegalAccessException e) {
                System.out.println("Exception position : CollectionsUtil - putValues(Object bean, Map<String, Object> map, String prefix)");
            }
 
            // 선행문자 제거
            if (prefixOverrides == null) {
                key = field.getName();
            } else {
                key = field.getName().replaceFirst(prefixOverrides, "");
            }
 
            // key 대문자로 변경
            if (keyUpperCase) {
                key = key.toUpperCase();
            }
 
            // key camelCase로 변경
            if (camelCase) {
                StringBuffer buffer = new StringBuffer();
                for (String token : key.toLowerCase().split("_")) {
                    buffer.append(StringUtils.capitalize(token));
                }
                key = StringUtils.uncapitalize(buffer.toString());
            }
 
            if (isValue(value)) {
                map.put(key, value);
            } else if (value instanceof BigDecimal) {
                map.put(key, value);
            } else {
                putValues(value, map, key, keyUpperCase, camelCase);
            }
        }
    }
 
    private static final Set<Class<?>> valueClasses = (Collections.unmodifiableSet(new HashSet<>(Arrays.asList(Object.class, String.class, Boolean.class,
            Character.class, Byte.class, Short.class, Integer.class, Long.class, Float.class, Double.class))));
 
    private static boolean isValue(Object value) {
        return value == null || valueClasses.contains(value.getClass());
    }
    
}
