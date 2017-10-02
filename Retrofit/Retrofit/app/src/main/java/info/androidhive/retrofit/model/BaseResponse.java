package info.androidhive.retrofit.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by daffer on 2017/9/23.
 */

public class BaseResponse {
    @SerializedName("page")
    protected int page;
    @SerializedName("total_results")
    protected int totalResults;
    @SerializedName("total_pages")
    protected int totalPages;
}
