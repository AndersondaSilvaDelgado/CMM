package br.com.usinasantafe.cmm.features.presenter.view.config

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.extension.replaceFragment
import br.com.usinasantafe.cmm.databinding.ActivityConfigBinding
import br.com.usinasantafe.cmm.features.presenter.view.boletimmmfert.BoletimActivity
import br.com.usinasantafe.cmm.features.presenter.view.splash.SplashActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConfigActivity : AppCompatActivity(), FragmentAttachListenerConfig {

    private lateinit var binding: ActivityConfigBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityConfigBinding.inflate(layoutInflater)
        setContentView(binding.root)

        goMenuInicial()

    }

    override fun popBackStack() {
        supportFragmentManager.popBackStack()
    }

    override fun goSenhaFragment() {
        replaceFragment(SenhaFragment())
    }

    override fun goConfigFragment() {
        replaceFragment(ConfigFragment())
    }

    override fun goMenuInicial() {
        replaceFragment(MenuInicialFragment())
    }

    override fun goBoletimMMFert() {
        val intent = Intent(this, BoletimActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun goSplash() {
        val intent = Intent(this, SplashActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    private fun replaceFragment(fragment: Fragment){
        replaceFragment(R.id.config_manager_fragment, fragment)
    }

}