package org.wandaima.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * eq,le,lt,ge,gt,like<br/>
 * 这四个方法使用"xx-name"作为conditionMap的key,防止key重复
 * @author lmkang25@163.com
 *
 */
public class Criteria {

	private static String[] SPECIAL_CHARS = {"!", "@", "#", "%", "^", "&", 
			"*", "(", ")", "-", "_", "+", "=", "'", "\"", ";", ":", "<", ">", 
			".", "/", "?", "~", "`", "|", "{", "}", "[", "]", ","};
	private Map<String, String> conditionMap = new HashMap<String, String>();
	private Map<String, String> orderByMap = new HashMap<String, String>();
	private Set<String> fkProperty = new HashSet<String>();
	
	public Criteria eq(String name, Object value) {
		if(value != null) {
			if(name != null) {
				String[] names = name.split("\\.");
				if(names.length == 2) {
					fkProperty.add(names[0]);
				}
				setValue("eq-" + name, value, "=");// 使用"xx-name"方式防止key重复
			}
		}
		return this;
	}
	
	public Criteria le(String name, Object value) {
		if(value != null) {
			if(name != null) {
				String[] names = name.split("\\.");
				if(names.length == 2) {
					fkProperty.add(names[0]);
				}
				setValue("le-" + name, value, "<=");
			}
		}
		return this;
	}
	
	public Criteria lt(String name, Object value) {
		if(value != null) {
			if(name != null) {
				String[] names = name.split("\\.");
				if(names.length == 2) {
					fkProperty.add(names[0]);
				}
				setValue("lt-" + name, value, "<");
			}
		}
		return this;
	}
	
	public Criteria ge(String name, Object value) {
		if(value != null) {
			if(name != null) {
				String[] names = name.split("\\.");
				if(names.length == 2) {
					fkProperty.add(names[0]);
				}
				setValue("ge-" + name, value, ">=");
			}
		}
		return this;
	}
	
	public Criteria gt(String name, Object value) {
		if(value != null) {
			if(name != null) {
				String[] names = name.split("\\.");
				if(names.length == 2) {
					fkProperty.add(names[0]);
				}
				setValue("gt-" + name, value, ">");
			}
		}
		return this;
	}
	
	public Criteria like(String name, String value) {
		if(value != null && value.trim().length() > 0) {
			if(name != null) {
				String[] names = name.split("\\.");
				if(names.length == 2) {
					fkProperty.add(names[0]);
				}
				value = escape(value);
				conditionMap.put("like-" + name, " LIKE '%" + value + "%'");
			}
		}
		return this;
	}
	
	public Criteria orderBy(String name, String value) {
		if("asc".equalsIgnoreCase(value) || "desc".equalsIgnoreCase(value)) {
			if(name != null) {
				String[] names = name.split("\\.");
				if(names.length == 2) {
					fkProperty.add(names[0]);
				}
				orderByMap.put(name, value);
			}
		}
		return this;
	}
	
	public Map<String, String> getConditionMap() {
		return this.conditionMap;
	}
	
	public Map<String, String> getOrderByMap() {
		return this.orderByMap;
	}
	
	public Set<String> getFkProperty() {
		return this.fkProperty;
	}
	
	public boolean hasJoin() {
		return this.fkProperty != null && this.fkProperty.size() > 0;
	}
	
	private String escape(String value) {
		if(value != null) {
			for(String str : SPECIAL_CHARS) {
				if(value.contains(str)) {
					value = value.replaceAll("\\" + str, "\\\\" + str);
				}
			}
		}
		return value;
	}
	
	private boolean isNumber(Object value) {
		if(value == null) {
			return false;
		}
		boolean result = false;
		Class<?> clazz = value.getClass();
		if(Integer.class.equals(clazz) || int.class.equals(clazz)) {
			result = true;
		} else if(Long.class.equals(clazz) || long.class.equals(clazz)) {
			result = true;
		} else if(Short.class.equals(clazz) || short.class.equals(clazz)) {
			result = true;
		} else if(Double.class.equals(clazz) || double.class.equals(clazz)) {
			result = true;
		} else if(Float.class.equals(clazz) || float.class.equals(clazz)) {
			result = true;
		} else {
			result = false;
		}
		return result;
	}
	
	private void setValue(String name, Object value, String operator) {
		if(Date.class.equals(value.getClass())) {// Date
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = (Date) value;
			conditionMap.put(name, String.format(" %s '%s'", operator, sdf.format(date)));
		} else if(String.class.equals(value.getClass())){// String
			String str = (String) value;
			str = escape(str);
			conditionMap.put(name, String.format(" %s '%s'", operator, str));
		} else if(isNumber(value)) {// Number
			conditionMap.put(name, String.format(" %s %s", operator, value));
		} else {
			throw new RuntimeException("don't support this type.");
		}
	}
}
