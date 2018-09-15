package com.tavares.kaique.kaiquetavaresrm79173.model

import com.google.gson.annotations.SerializedName

data class Pokemon (
        @SerializedName("name") val nome:String,
        @SerializedName("sprites") val sprite:Sprites)
