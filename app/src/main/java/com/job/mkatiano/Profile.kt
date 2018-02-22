package com.job.mkatiano

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by JOB on 2/22/2018.
 */
class Profile {

    @SerializedName("name")
    @Expose
    var name: String? = null

    @SerializedName("url")
    @Expose
    var imageUrl: String? = null

    @SerializedName("age")
    @Expose
    var age: Int? = null

    @SerializedName("location")
    @Expose
    var location: String? = null
}