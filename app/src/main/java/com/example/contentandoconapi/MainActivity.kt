package com.example.contentandoconapi

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.contentandoconapi.data.entities.DatosUsuarioDto
import com.example.contentandoconapi.databinding.ActivityMainBinding
import com.example.contentandoconapi.ui.viewmodel.RegistroUsuarioViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var datosUsuario: DatosUsuarioDto
    private lateinit var registroUsuarioViewModel: RegistroUsuarioViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        title="Prueba conexión QuickPay demostrando"

        registroUsuarioViewModel = ViewModelProvider(this).get(RegistroUsuarioViewModel::class.java)



        registroUsuarioViewModel.loading.observe(this, Observer { liveDataProgress ->

                binding.myProgressbar.isVisible = liveDataProgress

        })

        registroUsuarioViewModel.resultadoServidor.observe(this, Observer { result ->
            binding.respuestaServidor.text = result.toString()
        })

        binding.tvSaludo.setOnClickListener { borarCampo() }

        binding.loginButon.setOnClickListener { view -> enviarData() }


        datosUsuario = DatosUsuarioDto("Pedrito",
            (Integer(13748570)),
            "CC",
            Integer(31926531),
            "pedrito@mail.com",
            "2022-08-04",
            "mejorPass")


    }

    private fun borarCampo() {
        binding.respuestaServidor.text = ""
    }

    private fun enviarData() {
        datosUsuario.nombre = binding.textName.text.toString()
        registroUsuarioViewModel.setDataUser(datosUsuario)
    }


}