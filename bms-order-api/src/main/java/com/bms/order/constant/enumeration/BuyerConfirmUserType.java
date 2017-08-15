package com.bms.order.constant.enumeration;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * 买家退货确认人身份
 * 
 * @author li_huiqian
 *
 */
public enum BuyerConfirmUserType {

	BUYER("001", "Buyer", "买家"),
	SA("002", "Sa", "管家"),
	PLATFORM_STAFF("003", "Platform Staff", "平台订单员");

    private String code;

    private String enDesc;
    
    private String cnDesc;

    private BuyerConfirmUserType (String code, String enDesc, String cnDesc) {
        this.code = code;
        this.enDesc = enDesc;
        this.cnDesc = cnDesc;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
    	Locale locale = Locale.getDefault();
        return getName(locale);
    }
    
    public String getName(Locale locale) {
    	if (locale == Locale.SIMPLIFIED_CHINESE)
    		return cnDesc;
    	else 
    		return enDesc;
    }

    public static BuyerConfirmUserType getInstance(String code) {
        for (BuyerConfirmUserType item : values()) {
            if (item.code.equals(code))
                return item;
        }
        return null;
    }

    public static Map<String, String> getMap(BuyerConfirmUserType [] values) {
        if (values == null)
            return null;

        Map<String, String> map = new HashMap<>();
        for (BuyerConfirmUserType value : values) {
            map.put(value.getCode(), value.getName());
        }
        return map;
    }

    public static Map<String, String> getMap() {
        return getMap(BuyerConfirmUserType.values());
    }

}
