package br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.view

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.dialog.GenericDialogProgressBar
import br.com.usinasantafe.cmm.common.extension.setListenerButtonsGenericSUpdate
import br.com.usinasantafe.cmm.common.extension.showGenericAlertDialog
import br.com.usinasantafe.cmm.common.extension.showToast
import br.com.usinasantafe.cmm.databinding.FragmentOsBolBinding
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel.OSBolFragmentState
import br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel.OSBolViewModel
import br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel.OperadorBolFragmentState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class OSBolFragment : BaseFragment<FragmentOsBolBinding>(
    R.layout.fragment_os_bol,
    FragmentOsBolBinding::bind
) {

    private val viewModel: OSBolViewModel by viewModels()
    private lateinit var genericDialogProgressBar: GenericDialogProgressBar
    private lateinit var describe: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
        setListener()

    }

    private fun observe() {
        observeState()
        observeResult()
    }

    private fun observeState(){
        viewModel.uiStateFlow.flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
            .onEach { state -> handleStateChange(state) }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun observeResult(){
        viewModel.resultUpdateDataBase.flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
            .onEach { state -> handleStatusUpdate(state) }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun setListener() {
        with(binding){
            setListenerButtonsGenericSUpdate(layoutBotoes, editTextPadrao)
            layoutBotoes.buttonOkPadrao.setOnClickListener {
                if(editTextPadrao.text.isNotEmpty()){
                    viewModel.checkDataNroOS(editTextPadrao.text.toString())
                } else {
                    showGenericAlertDialog(getString(R.string.texto_campo_vazio, "MATRICULA DO OPERADOR"), requireContext())
                }
            }
        }
    }

    private fun handleStateChange(state: OSBolFragmentState){
        when(state){
            is OSBolFragmentState.Init -> Unit
            is OSBolFragmentState.CheckNroOS -> handleCheckNroOS(state.checkNroOS)
            is OSBolFragmentState.CheckSetNroOS -> handleCheckSetNroOS(state.checkSetNroOS)
        }
    }

    private fun handleCheckNroOS(checkNroOS: Boolean) {
        with(binding){
            if(checkNroOS){
                viewModel.setNroOS(editTextPadrao.text.toString())
            } else {
                viewModel.recoverDataOS(editTextPadrao.text.toString())
            }
        }
    }

    private fun handleCheckSetNroOS(checkSetNroOS: Boolean) {
        if(checkSetNroOS){
            findNavController().navigate(R.id.action_OSBolFragment_to_ativBolFragment)
        } else {
            showGenericAlertDialog(getString(R.string.texto_falha_insercao_campo, "OS"), requireContext())
        }
    }

    private fun handleStatusUpdate(resultUpdateDataBase: ResultUpdateDataBase?){
        resultUpdateDataBase?.let {
            if(resultUpdateDataBase.count == 1){
                showProgressBar()
            }
            describe = resultUpdateDataBase.describe
            genericDialogProgressBar.setValue(resultUpdateDataBase)
            if(resultUpdateDataBase.percentage == 100){
                hideProgressBar()
            }
        }
    }

    private fun showProgressBar(){
        genericDialogProgressBar = GenericDialogProgressBar(requireContext())
        genericDialogProgressBar.show()
        genericDialogProgressBar.window?.setLayout(
            WindowManager.LayoutParams.MATCH_PARENT,
            WindowManager.LayoutParams.WRAP_CONTENT,
        )
    }

    private fun hideProgressBar(){
        genericDialogProgressBar.cancel()
        if(describe == "OS Inexistente!"){
            showGenericAlertDialog(getString(R.string.texto_dado_invalido, "OS"), requireContext())
        } else {
            viewModel.setNroOS(binding.editTextPadrao.text.toString())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                findNavController().navigate(R.id.action_OSBolFragment_to_turnoBolFragment)
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            this, callback
        )
    }

}