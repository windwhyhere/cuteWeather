package com.cuteweather.android.util;

import android.text.TextUtils;

import com.cuteweather.android.db.City;
import com.cuteweather.android.db.County;
import com.cuteweather.android.db.Province;
import com.cuteweather.android.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by admin on 2016/12/20.
 */

public class Utility {
    public static  boolean hanleProvinceResponse(String response){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allProvicnes=new JSONArray(response);
                for(int i=0;i<allProvicnes.length();i++){
                    JSONObject provinceObject=allProvicnes.getJSONObject(i);
                    Province province=new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public  static  boolean hanleCityResponse(String response,int provinceId){
       if (!TextUtils.isEmpty(response)){
           try {
               JSONArray allCityies=new JSONArray(response);
               for(int i=0;i<allCityies.length();i++){
                   JSONObject cityObject=allCityies.getJSONObject(i);
                   City city=new City();
                   city.setCityName(cityObject.getString("name"));
                   city.setCityCode(cityObject.getInt("id"));
                   city.setProvinceId(provinceId);
                   city.save();
               }
               return true;
           } catch (JSONException e) {
               e.printStackTrace();
           }
       }
        return false;
    }
    public  static  boolean handleCountyResponse(String response,int cityId){
        if(!TextUtils.isEmpty(response)){
            try {
                JSONArray allCounties=new JSONArray(response);
                for(int i=0;i<allCounties.length();i++){
                    JSONObject countyObject=allCounties.getJSONObject(i);
                    County county=new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return  true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
    public  static Weather handleWeatherResponse(String response){
        try {
            JSONObject jsonObject=new JSONObject(response);
            JSONArray jsonArray=jsonObject.getJSONArray("HeWeather");
            String weatherContent=jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
