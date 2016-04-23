package jiangxiaobai.com.whiteweather.util;

import android.text.TextUtils;

import jiangxiaobai.com.whiteweather.db.WhiteWeatherDB;
import jiangxiaobai.com.whiteweather.model.City;
import jiangxiaobai.com.whiteweather.model.County;
import jiangxiaobai.com.whiteweather.model.Province;

/**
 * Created by JYH on 2016/4/21.
 */
public class Utility {

    /**
     * 解析和处理服务器返回的省级数据
     */
    public synchronized static boolean handleProvinceResponse(WhiteWeatherDB whiteWeatherDB, String response) {
        if(!TextUtils.isEmpty(response)) {
            String[] allProvinces = response.split(",");
            if(allProvinces != null && allProvinces.length > 0) {
                for(String p : allProvinces) {
                    String[] array = p.split("\\|");
                    Province province = new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    whiteWeatherDB.saveProvince(province);
                }
                return true;
            }
         }
        return false;
    }

    /**
     * 解析和处理服务器返回的市级数据
     */
    public static boolean handleCitiesResponse(WhiteWeatherDB whiteWeatherDB, String response, int provinceId) {
        if(!TextUtils.isEmpty(response)) {
            String[] allCities = response.split(",");
            if(allCities != null && allCities.length > 0) {
                for(String c : allCities) {
                    String[] array = c.split("\\|");
                    City city = new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    whiteWeatherDB.saveCity(city);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountiesResponse(WhiteWeatherDB whiteWeatherDB, String response, int cityId) {
        if(!TextUtils.isEmpty(response)) {
            String[] allCounties = response.split(",");
            if(allCounties != null && allCounties.length > 0) {
                for(String c : allCounties) {
                    String[] array = c.split("\\|");
                    County county = new County();
                    county.setCountyCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(cityId);
                    whiteWeatherDB.saveCounty(county);
                }
                return true;
            }
        }
        return false;
    }


}
