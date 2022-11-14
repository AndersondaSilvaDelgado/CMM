package br.com.usinasantafe.cmm.features.presenter.ui.apontmmfert.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.usinasantafe.cmm.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ApontActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apontamento)
    }
}