package br.com.usinasantafe.cmm.features.presenter.ui.splash.view

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handler.post(runnable)

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
}