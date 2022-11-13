package utils;

import static constant.URLConstant.DEFAULT_URL;

public class URL {
    private static String BaseURL = DEFAULT_URL;

    public static String getBaseURL(){
        return BaseURL;
    }

    public static void setBaseURL(String url){
        BaseURL = url;
    }

}
