package com.cuteweather.android.db;

import org.litepal.crud.DataSupport;

/**
 * Created by admin on 2016/12/19.
 */

public class County extends DataSupport {
    private  int id;
    private  String  CountyName;

    public String getWeatherId() {
        return WeatherId;
    }

    public void setWeatherId(String weatherId) {
        WeatherId = weatherId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountyName() {
        return CountyName;
    }

    public void setCountyName(String countyName) {
        CountyName = countyName;
    }

    public int getCityId() {
        return CityId;
    }

    public void setCityId(int cityId) {
        CityId = cityId;
    }

    private  String  WeatherId;
    private  int CityId;
}
