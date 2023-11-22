package com.azka.composesubmission.data

import com.azka.composesubmission.model.MonoChar
import com.azka.composesubmission.model.MonoCharData

class MonoCharRepository {
    fun getMonoChar(): List<MonoChar> {
        return MonoCharData.monoChar
    }

    fun searchMonoChar(query: String): List<MonoChar> {
        return MonoCharData.monoChar.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }

    fun getCharById(query: String): MonoChar?{
        return MonoCharData.monoChar.firstOrNull{
            it.id == query
        }
    }
}