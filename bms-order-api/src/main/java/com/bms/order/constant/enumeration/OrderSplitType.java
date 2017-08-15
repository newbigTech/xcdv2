package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Map;

/**
 * 买家订单类型
 * 
 * @author li_huiqian
 *
 */
public enum OrderSplitType {

    SPLIT_BY_ORDER("001", "按订单分拆"), SPLIT_BY_BATCH_ORDER("002", "按分批订单分拆");

    private String code;

    private String name;

    private OrderSplitType(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static String findName(String code) {
        for (OrderSplitType item : values()) {
            if (item.code.equals(code))
                return item.name;
        }
        return null;
    }

    public static OrderSplitType getInstance(String code) {
        for (OrderSplitType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(OrderSplitType[] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (OrderSplitType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(OrderSplitType.values());
    }

}
