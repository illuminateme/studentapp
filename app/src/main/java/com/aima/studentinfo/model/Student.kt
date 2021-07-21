package com.aima.studentinfo.model

import com.google.gson.annotations.SerializedName

data class Student(
   var name: String,
   var seat : String,
   @SerializedName("Class")
   var className: String
)