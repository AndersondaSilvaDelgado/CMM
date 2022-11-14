package br.com.usinasantafe.cmm.features.presenter.ui.config.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.usinasantafe.cmm.databinding.ActivityConfigBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConfigActivity : AppCompatActivity() {

    private lateinit var binding: ActivityConfigBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfigBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}