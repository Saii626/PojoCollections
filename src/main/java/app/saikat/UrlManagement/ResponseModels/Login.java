package app.saikat.UrlManagement.ResponseModels;

import com.google.gson.annotations.SerializedName;

public class Login {

    @SerializedName("status")
    public String status;

    @SerializedName("userId")
    public String userId;

    @SerializedName("error")
    public String error;
}
