package top.howard85.code.generator.generation;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public enum ClazzEnum {

    STRING(1, String.class),
    SHORT(2, Short.class),
    INTEGER(3, Integer.class),
    LONG(4, Long.class),
    DOUBLE(5, Double.class),
    BIG_DECIMAL(6, BigDecimal.class),
    DATE(7, Date.class),
    INSTANT(8, Instant.class),
    LOCAL_DATE(9, LocalDate.class),
    LOCAL_DATE_TIME(10, LocalDateTime.class),
    ;

    private Integer code;
    private Class clazz;

    static Map<Integer, ClazzEnum> enumMap = new HashMap<>();
    static Map<Class, ClazzEnum> enumClazzMap = new HashMap<>();

    static {
        for (ClazzEnum type : ClazzEnum.values()) {
            enumMap.put(type.getCode(), type);
            enumClazzMap.put(type.getClazz(), type);
        }
    }

    ClazzEnum(Integer code, Class clazz) {
        this.code = code;
        this.clazz = clazz;
    }

    public Integer getCode() {
        return this.code;
    }

    public Class getClazz() {
        return this.clazz;
    }

    public static ClazzEnum getEnum(Integer code) {
        return null == code ? null : enumMap.get(code);
    }

    public static ClazzEnum getEnum(Class clazz) {
        return null == clazz ? null :enumClazzMap.get(clazz);
    }
}
