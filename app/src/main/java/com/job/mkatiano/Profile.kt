package com.job.mkatiano

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by JOB on 2/22/2018.
 *
 * @SerializedName annotation belongs to gson class
 * and used to read json file variable and bind it to the model variable.
 * @Expose is used to make the variable readable to the gson
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