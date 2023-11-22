package com.azka.composesubmission.ui

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.azka.composesubmission.data.MonoCharRepository
import com.azka.composesubmission.model.MonoChar
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MonoCharViewModel(private val repository: MonoCharRepository) : ViewModel() {
    private val _groupedMonoChar = MutableStateFlow(
        repository.getMonoChar()
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    )
    val groupedMonoChar: StateFlow<Map<Char, List<MonoChar>>> get() = _groupedMonoChar

    private val _query = mutableStateOf("")
    val query: State<String> get() = _query

    fun search(newQuery: String) {
        _query.value = newQuery
        _groupedMonoChar.value = repository.searchMonoChar(_query.value)
            .sortedBy { it.name }
            .groupBy { it.name[0] }
    }

    private val _detailChar = MutableStateFlow<MonoChar?>(null)
    val detailChar: StateFlow<MonoChar?> get() = _detailChar
    fun searchByID(idQuery: String){
        _detailChar.value = repository.getCharById(idQuery)
    }
}


class ViewModelFactory(private val repository: MonoCharRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MonoCharViewModel::class.java)) {
            return MonoCharViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }

}