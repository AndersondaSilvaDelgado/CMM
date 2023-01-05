package br.com.usinasantafe.cmm.common.base

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import br.com.usinasantafe.cmm.features.presenter.view.config.FragmentAttachListenerConfig

abstract class BaseFragment<T>(
    @LayoutRes layoutId: Int,
    val bind: (View) -> T,
): Fragment(layoutId) {

    private var _binding: T? = null
    protected val binding get() = _binding!!

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = bind(view)
    }

}
