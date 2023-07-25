package br.com.usinasantafe.cmm.features.presenter.apontmmfert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.extension.replaceFragment
import br.com.usinasantafe.cmm.databinding.ActivityApontBinding
import br.com.usinasantafe.cmm.features.presenter.apontmmfert.ativapont.AtivApontFragment
import br.com.usinasantafe.cmm.features.presenter.apontmmfert.menuapont.MenuApontFragment
import br.com.usinasantafe.cmm.features.presenter.apontmmfert.osapont.OSApontFragment
import br.com.usinasantafe.cmm.features.presenter.apontmmfert.paradaapont.ParadaApontFragment
import br.com.usinasantafe.cmm.features.presenter.boletimmmfert.BoletimActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ApontActivity : AppCompatActivity(), FragmentAttachListenerApont {

    private lateinit var binding: ActivityApontBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityApontBinding.inflate(layoutInflater)
        setContentView(binding.root)

        goMenuApontFragment()

    }

    private fun replaceFragment(fragment: Fragment){
        replaceFragment(R.id.apont_manager_fragment, fragment)
    }

    override fun popBackStack() {
        supportFragmentManager.popBackStack()
    }

    override fun goBoletimMMFert() {
        val intent = Intent(this, BoletimActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun goMenuApontFragment() {
        replaceFragment(MenuApontFragment())
    }

    override fun goOSApontFragment() {
        replaceFragment(OSApontFragment())
    }

    override fun goAtivApontFragment() {
        replaceFragment(AtivApontFragment())
    }

    override fun goParadaApontFragment() {
        replaceFragment(ParadaApontFragment())
    }

}