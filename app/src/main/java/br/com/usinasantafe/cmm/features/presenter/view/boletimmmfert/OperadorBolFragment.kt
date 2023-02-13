package br.com.usinasantafe.cmm.features.presenter.view.boletimmmfert

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.dialog.GenericDialogProgressBar
import br.com.usinasantafe.cmm.common.extension.onBackPressed
import br.com.usinasantafe.cmm.common.extension.setListenerButtonsGeneric
import br.com.usinasantafe.cmm.common.extension.showGenericAlertDialog
import br.com.usinasantafe.cmm.common.extension.showToast
import br.com.usinasantafe.cmm.common.utils.StatusUpdate
import br.com.usinasantafe.cmm.databinding.FragmentOperadorBolBinding
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert.OperadorBolFragmentState
import br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert.OperadorBolViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch


@AndroidEntryPoint
class OperadorBolFragment : BaseFragment<FragmentOperadorBolBinding>(
    R.layout.fragment_operador_bol,
    FragmentOperadorBolBinding::bind
) {

    private val viewModel: OperadorBolViewModel by viewModels()
    private var genericDialogProgressBar: GenericDialogProgressBar? = null
    private var fragmentAttachListenerBoletim: FragmentAttachListenerBoletim? = null
    private lateinit var describeUpdate: String

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
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.uiStateFlow.collect{
                    state -> handleStateChange(state)
                }
            }
        }
    }

    private fun setListener() {
        with(binding) {
            setListenerButtonsGeneric(layoutBotoes, editTextPadrao)
            layoutBotoes.buttonOkPadrao.setOnClickListener {
                if (editTextPadrao.text.isNotEmpty()) {
                    viewModel.checkMatricFunc(editTextPadrao.text.toString())
                } else {
                    showGenericAlertDialog(
                        getString(
                            R.string.texto_campo_vazio,
                            "MATRICULA DO OPERADOR"
                        ), requireContext()
                    )
                }
            }
            layoutBotoes.buttonAtualPadrao.setOnClickListener {
                viewModel.updateDataFunc()
            }
        }

    }

    private fun handleStateChange(state: OperadorBolFragmentState) {
        when (state) {
            is OperadorBolFragmentState.Init -> Unit
            is OperadorBolFragmentState.CheckMatricFunc -> handleCheckMatricOperador(state.checkMatricOperador)
            is OperadorBolFragmentState.CheckSetMatricFunc -> handleCheckSetMatricOperador(state.checkSetMatricOperador)
            is OperadorBolFragmentState.FeedbackUpdateFunc -> handleUpdate(state.statusUpdate)
            is OperadorBolFragmentState.SetResultUpdate -> handleStatusUpdate(state.resultUpdateDataBase)
        }
    }

    private fun handleCheckMatricOperador(checkMatricOperador: Boolean) {
        if (checkMatricOperador) {
            viewModel.setMatricFunc(binding.editTextPadrao.text.toString())
        } else {
            showGenericAlertDialog(
                getString(
                    R.string.texto_dado_invalido_com_atual,
                    "MATRICULA DO OPERADOR"
                ), requireContext()
            )
        }
    }

    private fun handleCheckSetMatricOperador(checkSetMatricOperador: Boolean) {
        if (checkSetMatricOperador) {
            fragmentAttachListenerBoletim?.goEquipBolFragment()
        } else {
            showGenericAlertDialog(
                getString(
                    R.string.texto_falha_insercao_campo,
                    "MATRICULA DO OPERADOR"
                ), requireContext()
            )
        }
    }

    private fun handleStatusUpdate(resultUpdateDataBase: ResultUpdateDataBase?) {
        resultUpdateDataBase?.let {
            if (genericDialogProgressBar == null) {
                showProgressBar()
            }
            describeUpdate = resultUpdateDataBase.describe
            genericDialogProgressBar!!.setValue(resultUpdateDataBase)
        }
    }

    private fun handleUpdate(statusUpdate: StatusUpdate) {
        when (statusUpdate) {
            StatusUpdate.ATUALIZADO -> {
                hideProgressBar()
                showToast(
                    getString(R.string.texto_msg_atualizacao, "COLABORADORES"),
                    requireContext()
                )
            }
            StatusUpdate.FALHA -> {
                hideProgressBar()
                showToast(
                    getString(R.string.texto_update_failure, describeUpdate),
                    requireContext()
                )
            }
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
        if (genericDialogProgressBar != null) {
            genericDialogProgressBar!!.cancel()
        }
        genericDialogProgressBar = null
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentAttachListenerBoletim) {
            fragmentAttachListenerBoletim = context
        }
        onBackPressed {
            fragmentAttachListenerBoletim?.goConfig()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentAttachListenerBoletim = null
    }

}

