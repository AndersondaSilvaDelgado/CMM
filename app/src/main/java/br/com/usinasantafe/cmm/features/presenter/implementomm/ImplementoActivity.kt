package br.com.usinasantafe.cmm.features.presenter.implementomm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.extension.replaceFragment
import br.com.usinasantafe.cmm.databinding.ActivityImplementoBinding
import br.com.usinasantafe.cmm.features.presenter.apontmmfert.ApontActivity
import br.com.usinasantafe.cmm.features.presenter.implementomm.implemento.ImplementoFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImplementoActivity : AppCompatActivity(), FragmentAttachListenerImplemento {

    private lateinit var binding: ActivityImplementoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImplementoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        goImplemento()

    }

    override fun goAtivMMFert() {
        val intent = Intent(this, ApontActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun goImplemento() {
        replaceFragment(ImplementoFragment())
    }

    private fun replaceFragment(fragment: Fragment){
        replaceFragment(R.id.implemento_manager_fragment, fragment)
    }

}