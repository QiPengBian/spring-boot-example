package com.example.common.enums;

/**
 * @description: 数据有效性枚举
 * @author: bianqipeng
 * @date: 2020年05月26日 10:53:05
 */
public enum EnableEnum {

    INVALID(0, "无效"),
    VALID(1, "有效");

    private Integer key;

    private String value;

    EnableEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    /**
     * @description: 通过key获得枚举
     * @author: bianqipeng
     * @date: 2020年05月26日 11:36:00
     * @param: key
     * @return: EnableEnum
     */
    public static EnableEnum getEnumByKey(Integer key) {
        for (EnableEnum enums : EnableEnum.values()) {
            if (enums.key.equals(key)) {
                return enums;
            }
        }
        return null;
    }

    /**
     * @description: 通过value获得枚举
     * @author: bianqipeng
     * @date: 2020年05月26日 11:36:00
     * @param: value
     * @return: EnableEnum
     */
    public static EnableEnum getEnumByValue(String value) {
        for (EnableEnum enums : EnableEnum.values()) {
            if (enums.value.equals(value)) {
                return enums;
            }
        }
        return null;
    }

}
