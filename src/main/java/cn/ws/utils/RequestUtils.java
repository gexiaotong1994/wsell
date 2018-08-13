package cn.ws.utils;


import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

    public static String get(HttpServletRequest request, String key) {
        return request.getParameter(key);
    }

    public static int getInt(HttpServletRequest request, String key) {
        String value = get(request, key);
        if (StringUtils.isBlank(value)) {
            return -1;
        }
        try {
            return Integer.valueOf(value);
        } catch (Exception e) {
            return -1;
        }

    }

}
