package br.com.usinasantafe.cmm.features.presenter.view.config

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.dialog.GenericDialogProgressBar
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.extension.showGenericAlertDialog
import br.com.usinasantafe.cmm.common.utils.StatusRecover
import br.com.usinasantafe.cmm.common.utils.StatusUpdate
import br.com.usinasantafe.cmm.databinding.FragmentConfigBinding
import br.com.usinasantafe.cmm.features.domain.entities.variable.Config
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import br.com.usinasantafe.cmm.features.presenter.viewmodel.config.ConfigFragmentState
import br.com.usinasantafe.cmm.features.presenter.viewmodel.config.ConfigViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class ConfigFragment : BaseFragment<FragmentConfigBinding>(
    R.layout.fragment_config,
    FragmentConfigBinding::bind
) {

    private val viewModel: ConfigViewModel by viewModels()
    private var genericDialogProgressBar: GenericDialogProgressBar? = null
    private var typeUpdate: Boolean = true
    private var fragmentAttachListenerConfig: FragmentAttachListenerConfig? = null
    private lateinit var describeRecover: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
        startEvents()
        setListener()

    }

    private fun observe() {
        observeState()
    }

    private fun observeState(){
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
            buttonAtualBaseDados.setOnClickListener {
                typeUpdate = true
                textStatusAtualDados.isVisible = true
                progressBarAtualDados.isVisible = true
                viewModel.updateDataBaseInitial()
            }
            buttonSalvarConfig.setOnClickListener {
                val nroEquip = editTextEquipConfig.text.toString().trim()
                val senha = editTextSenhaConfig.text.toString().trim()
                if(validate(nroEquip, senha)){
                    typeUpdate = false
                    viewModel.saveDataConfig(nroEquip, senha)
                } else {
                    showGenericAlertDialog(getString(R.string.texto_config_invalida), requireContext())
                }
            }
            buttonCancConfig.setOnClickListener {
                fragmentAttachListenerConfig?.goMenuInicial()
            }
        }
    }

    private fun startEvents() {
        with(binding) {
            buttonSalvarConfig.isEnabled = false
            textStatusAtualDados.isVisible = false
            progressBarAtualDados.isVisible = false
        }
        viewModel.recoverDataConfig()
        viewModel.checkUpdateData()
    }

    private fun validate(nroEquip: String, senha: String) : Boolean {
        return (nroEquip.isNotEmpty() && senha.isNotEmpty())
    }

    private fun handleStateChange(state: ConfigFragmentState){
        when(state){
            is ConfigFragmentState.Init -> Unit
            is ConfigFragmentState.RecoverConfig -> handleConfig(state.config)
            is ConfigFragmentState.FeedbackLoadingDataBase -> handleLoadingDataBase(state.statusUpdateDataBase)
            is ConfigFragmentState.FeedbackLoadingEquip -> handleLoadingEquip(state.statusUpdateEquip)
            is ConfigFragmentState.IsCheckUpdate -> binding.buttonSalvarConfig.isEnabled = state.isCheckUpdate
            is ConfigFragmentState.SetResultUpdate -> handleStatus(state.resultUpdateDataBase)
        }
    }

    private fun handleConfig(config: Config){
        with(binding) {
            editTextEquipConfig.setText(config.equipConfig.toString())
            editTextSenhaConfig.setText(config.senhaConfig)
        }
    }

    private fun handleStatus(resultUpdateDataBase: ResultUpdateDataBase?){
        with(binding) {
            resultUpdateDataBase?.let {
                if(typeUpdate){
                    textStatusAtualDados.text = resultUpdateDataBase.describe
                    progressBarAtualDados.progress = resultUpdateDataBase.percentage
                } else {
                    if(genericDialogProgressBar == null){
                        showProgressBar()
                    }
                    describeRecover = resultUpdateDataBase.describe
                    genericDialogProgressBar!!.setValue(resultUpdateDataBase)
                }
            }
        }
    }

    private fun handleLoadingDataBase(statusUpdate: StatusUpdate){
        when(statusUpdate){
            StatusUpdate.ATUALIZADO -> handleCheckUpdate(true)
            StatusUpdate.FALHA -> handleCheckUpdate(false)
        }
    }

    private fun handleLoadingEquip(statusRecover: StatusRecover){
        when(statusRecover){
            StatusRecover.SUCESSO -> {
                hideProgressBar()
                fragmentAttachListenerConfig?.goMenuInicial()
            }
            StatusRecover.FALHA -> {
                hideProgressBar()
                showGenericAlertDialog(getString(R.string.texto_update_failure, describeRecover), requireContext())
            }
            StatusRecover.VAZIO -> {
                hideProgressBar()
                showGenericAlertDialog(getString(R.string.texto_dado_invalido, "EQUIPAMENTO"), requireContext())
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
        if(genericDialogProgressBar != null){
            genericDialogProgressBar!!.cancel()
        }
        genericDialogProgressBar = null
    }

    private fun handleCheckUpdate(isCheckUpdate: Boolean){
        with(binding) {
            if(isCheckUpdate){
                showGenericAlertDialog(getString(R.string.texto_update_sucess), requireContext())
            } else {
                showGenericAlertDialog(getString(R.string.texto_update_failure, textStatusAtualDados.text), requireContext())
            }
            buttonSalvarConfig.isEnabled = isCheckUpdate
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragmentAttachListenerConfig){
            fragmentAttachListenerConfig = context
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentAttachListenerConfig = null
    }

}