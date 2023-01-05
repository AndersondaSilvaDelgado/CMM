package br.com.usinasantafe.cmm.features.presenter.view.apontmmfert

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.dialog.GenericDialogProgressBar
import br.com.usinasantafe.cmm.common.extension.setListenerButtonsGenericSUpdate
import br.com.usinasantafe.cmm.common.extension.showGenericAlertDialog
import br.com.usinasantafe.cmm.databinding.FragmentOsApontBinding
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import br.com.usinasantafe.cmm.features.presenter.viewmodel.apontmmfert.OSApontFragmentState
import br.com.usinasantafe.cmm.features.presenter.viewmodel.apontmmfert.OSApontViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class OSApontFragment : BaseFragment<FragmentOsApontBinding>(
    R.layout.fragment_os_apont,
    FragmentOsApontBinding::bind
) {

    private val viewModel: OSApontViewModel by viewModels()
    private lateinit var genericDialogProgressBar: GenericDialogProgressBar
    private lateinit var describe: String
    private var fragmentAttachListenerApont: FragmentAttachListenerApont? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
        setListener()

    }

    private fun observe() {
        observeState()
        observeResult()
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiStateFlow.collect { state ->
                    handleStateChange(state)
                }
            }
        }
    }

    private fun observeResult() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.resultUpdateDataBase.collect { state ->
                    handleStatusUpdate(state)
                }
            }
        }
    }

    private fun setListener() {
        with(binding) {
            setListenerButtonsGenericSUpdate(layoutBotoes, editTextPadrao)
            layoutBotoes.buttonOkPadrao.setOnClickListener {
                if (editTextPadrao.text.isNotEmpty()) {
                    viewModel.checkDataNroOS(editTextPadrao.text.toString())
                } else {
                    showGenericAlertDialog(
                        getString(
                            R.string.texto_campo_vazio,
                            "MATRICULA DO OPERADOR"
                        ), requireContext()
                    )
                }
            }
        }
    }

    private fun handleStateChange(state: OSApontFragmentState) {
        when (state) {
            is OSApontFragmentState.Init -> Unit
            is OSApontFragmentState.CheckNroOS -> handleCheckNroOS(state.checkNroOS)
            is OSApontFragmentState.CheckSetNroOS -> handleCheckSetNroOS(state.checkSetNroOS)
        }
    }

    private fun handleCheckNroOS(checkNroOS: Boolean) {
        with(binding) {
            if (checkNroOS) {
                viewModel.setNroOS(editTextPadrao.text.toString())
            } else {
                viewModel.recoverDataOS(editTextPadrao.text.toString())
            }
        }
    }

    private fun handleCheckSetNroOS(checkSetNroOS: Boolean) {
        if (checkSetNroOS) {
            fragmentAttachListenerApont?.goAtivApontFragment()
        } else {
            showGenericAlertDialog(
                getString(R.string.texto_falha_insercao_campo, "OS"),
                requireContext()
            )
        }
    }

    private fun handleStatusUpdate(resultUpdateDataBase: ResultUpdateDataBase?) {
        resultUpdateDataBase?.let {
            if(resultUpdateDataBase.count == 1){
                showProgressBar()
            }
            describe = resultUpdateDataBase.describe
            genericDialogProgressBar.setValue(resultUpdateDataBase)
            if (resultUpdateDataBase.percentage == 100) {
                hideProgressBar()
            }
        }
    }

    private fun showProgressBar() {
        genericDialogProgressBar = GenericDialogProgressBar(requireContext())
        genericDialogProgressBar.show()
        genericDialogProgressBar.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
        )
    }

    private fun hideProgressBar() {
        genericDialogProgressBar.cancel()
        if (describe == "OS Inexistente!") {
            showGenericAlertDialog(getString(R.string.texto_dado_invalido, "OS"), requireContext())
        } else {
            viewModel.setNroOS(binding.editTextPadrao.text.toString())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragmentAttachListenerApont){
            fragmentAttachListenerApont = context
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentAttachListenerApont = null
    }

}