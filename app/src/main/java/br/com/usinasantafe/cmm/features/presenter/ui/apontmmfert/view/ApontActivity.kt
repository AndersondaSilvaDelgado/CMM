package br.com.usinasantafe.cmm.features.presenter.ui.apontmmfert.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.usinasantafe.cmm.databinding.ActivityApontBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ApontActivity : AppCompatActivity() {

    private lateinit var binding: ActivityApontBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApontBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}