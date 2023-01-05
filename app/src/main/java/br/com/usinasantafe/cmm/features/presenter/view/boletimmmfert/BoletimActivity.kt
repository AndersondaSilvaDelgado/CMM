package br.com.usinasantafe.cmm.features.presenter.view.boletimmmfert

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.extension.replaceFragment
import br.com.usinasantafe.cmm.databinding.ActivityBoletimBinding
import br.com.usinasantafe.cmm.features.presenter.view.apontmmfert.ApontActivity
import br.com.usinasantafe.cmm.features.presenter.view.config.ConfigActivity
import br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert.BoletimViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class BoletimActivity : AppCompatActivity(), FragmentAttachListenerBoletim {

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
        goOperadorBolFragment()
    }

    private fun replaceFragment(fragment: Fragment){
        replaceFragment(R.id.boletim_manager_fragment, fragment)
    }

    override fun popBackStack() {
        supportFragmentManager.popBackStack()
    }

    override fun goConfig() {
        val intent = Intent(this, ConfigActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun goAtivMMFert() {
        val intent = Intent(this, ApontActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun goOperadorBolFragment() {
        replaceFragment(OperadorBolFragment())
    }

    override fun goEquipBolFragment() {
        replaceFragment(EquipBolFragment())
    }

    override fun goTurnoBolFragment() {
        replaceFragment(TurnoBolFragment())
    }

    override fun goOSBolFragment() {
        replaceFragment(OSBolFragment())
    }

    override fun goAtivBolFragment() {
        replaceFragment(AtivBolFragment())
    }

    override fun goHorimetroBolFragment() {
        replaceFragment(HorimetroBolFragment())
    }

}