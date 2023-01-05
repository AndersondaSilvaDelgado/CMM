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
    private lateinit var genericDialogProgressBar: GenericDialogProgressBar
    private var typeUpdate: Boolean = true
    private var fragmentAttachListenerConfig: FragmentAttachListenerConfig? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
        startEvents()
        setListener()

    }

    private fun observe() {
        observeState()
        observeResult()
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

    private fun observeResult(){
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.resultUpdateDataBase.collect{
                    state -> handleStatus(state)
                }
            }
        }
    }

    private fun setListener() {
        with(binding) {
            buttonAtualBaseDados.setOnClickListener {
                viewModel.updateDados()
            }
            buttonSalvarConfig.setOnClickListener {
                val nroEquip = editTextEquipConfig.text.toString().trim()
                val senha = editTextSenhaConfig.text.toString().trim()
                if(validate(nroEquip, senha)){
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
            is ConfigFragmentState.IsLoadingDataBase -> handleLoadingDataBase(state.isLoadingDataBase)
            is ConfigFragmentState.IsLoadingEquip -> handleLoadingEquip(state.isLoadingEquip)
            is ConfigFragmentState.IsCheckUpdate -> handleCheckUpdate(state.isCheckUpdate)
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
                    genericDialogProgressBar.setValue(resultUpdateDataBase)
                }
            }
        }
    }

    private fun handleLoadingDataBase(isLoading: Boolean){
        typeUpdate = true
        with(binding) {
            if(isLoading){
                textStatusAtualDados.isVisible = isLoading
                progressBarAtualDados.isVisible = isLoading
            } else {
                viewModel.checkUpdateData()
            }
        }
    }

    private fun handleLoadingEquip(isLoading: Boolean){
        typeUpdate = false
        if(isLoading){
            genericDialogProgressBar = GenericDialogProgressBar(requireContext())
            genericDialogProgressBar.show()
            genericDialogProgressBar.window?.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
            )
        } else {
            genericDialogProgressBar.cancel()
            fragmentAttachListenerConfig?.goMenuInicial()
        }
    }

    private fun handleCheckUpdate(isCheckUpdate: Boolean){
        with(binding) {
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