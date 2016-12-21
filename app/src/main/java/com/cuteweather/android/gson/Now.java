package com.cuteweather.android.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by admin on 2016/12/21.
 */

public class Now {
    @SerializedName("tmp")
    public String tempeture;

    @SerializedName("cond")
    public  More more;

    public class More{
        @SerializedName("txt")
        public String info;
    }
}
