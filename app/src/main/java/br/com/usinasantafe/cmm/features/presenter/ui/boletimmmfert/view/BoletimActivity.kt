package br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import br.com.usinasantafe.cmm.databinding.ActivityBoletimBinding
import br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel.BoletimViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BoletimActivity : AppCompatActivity() {

    private val viewModel: BoletimViewModel by viewModels()

    private lateinit var binding: ActivityBoletimBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBoletimBinding.inflate(layoutInflater)
        setContentView(binding.root)

        startEvents()

    }

    private fun startEvents() {
        viewModel.startBoletim()
    }

}