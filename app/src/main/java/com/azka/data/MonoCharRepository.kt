package com.azka.data

import com.azka.model.MonoChar
import com.azka.model.MonoCharData

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