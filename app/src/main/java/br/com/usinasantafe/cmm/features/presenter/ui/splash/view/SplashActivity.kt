package br.com.usinasantafe.cmm.features.presenter.ui.splash.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.databinding.ActivitySplashBinding
import br.com.usinasantafe.cmm.features.presenter.ui.apontmmfert.view.ApontActivity
import br.com.usinasantafe.cmm.features.presenter.ui.config.view.ConfigActivity
import br.com.usinasantafe.cmm.features.presenter.ui.splash.viewmodel.SplashState
import br.com.usinasantafe.cmm.features.presenter.ui.splash.viewmodel.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    private val viewModel: SplashViewModel by viewModels()
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handler.post(runnable)

        observe()
        startEvents()

    }

    private fun observe() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiStateFlow.collect{
                        state -> handleStateChange(state)
                }
            }
        }
    }

    private fun startEvents() {
        viewModel.startSent()
    }

    private val runnable: Runnable
        get() = Runnable {
            binding.splashImg.animate()
                .alpha(0f)
                .setDuration(2000)
                .withEndAction{
                    binding.splashImg.animate()
                        .alpha(1f).duration = 2000
                }
            handler.postDelayed(runnable, 4000)
        }

    private fun handleStateChange(state: SplashState){
        when(state){
            is SplashState.Init -> Unit
            is SplashState.CheckData -> handleCheckData(state.checkData)
        }
    }

    private fun handleCheckData(checkData: Boolean){
        if(checkData){
            val intent = Intent(this, ApontActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        } else {
            val intent = Intent(this, ConfigActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }

    }
}