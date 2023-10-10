package com.example.contentandoconapi.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.contentandoconapi.data.entities.DatosUsuarioDto
import com.example.contentandoconapi.domain.RegistroUsuarioUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegistroUsuarioViewModel @Inject constructor(

    private val registroUsuarioUseCase: RegistroUsuarioUseCase,
) : ViewModel() {

    lateinit var datosUsuarioDto: DatosUsuarioDto

    private val _loading = MutableLiveData<Boolean>()
    val loading : LiveData<Boolean> get() = _loading

    private val _resultadoServidor = MutableLiveData<Boolean>()
    val resultadoServidor : LiveData<Boolean>get() = _resultadoServidor

    fun onCreate() {
        onProgressBar()

        viewModelScope.launch {

            val result = registroUsuarioUseCase.invoke(datosUsuarioDto)

            if(result.exitoso){
                _resultadoServidor.postValue(result.exitoso)
            }
            else{_resultadoServidor.postValue(false)}
            offProgresBar()
        }

    }

    fun setDataUser(datosUsuarioDto: DatosUsuarioDto){
        this.datosUsuarioDto = datosUsuarioDto
        onCreate()
    }

    private fun onProgressBar() = _loading.postValue(true)

    private fun offProgresBar() = _loading.postValue(false)

}