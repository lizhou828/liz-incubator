package com.liz.ocjpJava6.advanced.reflection.demo1;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * Created by lizhou on 2016/9/29.
 */
public class BaseBean {
    public String toString() {
        StringBuffer sb = new StringBuffer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Class<?> cls = this.getClass();
        Field[] fields = cls.getDeclaredFields();
        sb.append(cls.getName() + "{");
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                sb.append(field.getName());
                sb.append("=");
                sb.append(field.get(this));
                sb.append(" ");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
