package com.azka.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MonoChar(
    val id: String,
    val name: String,
    val photoUrl: String,
    val description: String,
    val Age: String,
): Parcelable