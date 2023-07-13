package br.com.usinasantafe.cmm.features.presenter.view.boletimmmfert

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.dialog.GenericDialogProgressBar
import br.com.usinasantafe.cmm.common.extension.onBackPressed
import br.com.usinasantafe.cmm.common.extension.setListenerButtonsGenericSUpdate
import br.com.usinasantafe.cmm.common.extension.showGenericAlertDialog
import br.com.usinasantafe.cmm.common.utils.StatusRecover
import br.com.usinasantafe.cmm.databinding.FragmentOsBolBinding
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert.OSBolFragmentState
import br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert.OSBolViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class OSBolFragment : BaseFragment<FragmentOsBolBinding>(
    R.layout.fragment_os_bol,
    FragmentOsBolBinding::bind
) {

    private val viewModel: OSBolViewModel by viewModels()
    private var genericDialogProgressBar: GenericDialogProgressBar? = null
    private lateinit var describeRecover: String
    private var fragmentAttachListenerBoletim: FragmentAttachListenerBoletim? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
        setListener()

    }

    private fun observe() {
        observeState()
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

    private fun handleStateChange(state: OSBolFragmentState) {
        when (state) {
            is OSBolFragmentState.Init -> Unit
            is OSBolFragmentState.CheckNroOS -> handleCheckNroOS(state.checkNroOS)
            is OSBolFragmentState.CheckSetNroOS -> fragmentAttachListenerBoletim?.goAtivBolFragment()
            is OSBolFragmentState.FeedbackUpdateOS -> handleFeedbackUpdateOS(state.statusRecover)
            is OSBolFragmentState.SetResultUpdate -> handleStatusUpdate(state.resultUpdateDatabase)
        }
    }

    private fun handleFeedbackUpdateOS(statusRecover: StatusRecover) {
        when(statusRecover){
            StatusRecover.SUCESSO -> {
                hideProgressBar()
                fragmentAttachListenerBoletim?.goAtivBolFragment()
            }
            StatusRecover.VAZIO -> {
                hideProgressBar()
                showGenericAlertDialog(getString(R.string.texto_dado_invalido, "OS"), requireContext())
            }
            StatusRecover.FALHA -> {
                hideProgressBar()
                showGenericAlertDialog(getString(R.string.texto_update_failure, describeRecover), requireContext())
            }
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

    private fun handleStatusUpdate(resultUpdateDatabase: ResultUpdateDatabase?) {
        resultUpdateDatabase?.let {
            describeRecover = resultUpdateDatabase.describe
            if(genericDialogProgressBar == null){
                showProgressBar()
            }
            genericDialogProgressBar!!.setValue(resultUpdateDatabase)
        }
    }

    private fun showProgressBar() {
        genericDialogProgressBar = GenericDialogProgressBar(requireContext())
        genericDialogProgressBar!!.show()
        genericDialogProgressBar!!.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
        )
    }

    private fun hideProgressBar() {
        if(genericDialogProgressBar != null){
            genericDialogProgressBar!!.cancel()
        }
        genericDialogProgressBar = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragmentAttachListenerBoletim){
            fragmentAttachListenerBoletim = context
        }
        onBackPressed {
            fragmentAttachListenerBoletim?.goTurnoBolFragment()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentAttachListenerBoletim = null
    }

}