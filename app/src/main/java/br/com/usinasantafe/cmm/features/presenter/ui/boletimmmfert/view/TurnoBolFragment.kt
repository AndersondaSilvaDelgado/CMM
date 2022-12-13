package br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.view

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.adapter.CustomAdapter
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.dialog.GenericDialogProgressBar
import br.com.usinasantafe.cmm.common.extension.showToast
import br.com.usinasantafe.cmm.databinding.FragmentTurnoBolBinding
import br.com.usinasantafe.cmm.features.domain.entities.stable.Turno
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel.TurnoBolFragmentState
import br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel.TurnoBolViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TurnoBolFragment : BaseFragment<FragmentTurnoBolBinding>(
    R.layout.fragment_turno_bol,
    FragmentTurnoBolBinding::bind
) {

    private val viewModel: TurnoBolViewModel by viewModels()
    private lateinit var genericDialogProgressBar: GenericDialogProgressBar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
        startEvents()
        setListener()

    }

    fun observe(){
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
                    state -> handleStatusUpdate(state)
                }
            }
        }
    }

    private fun viewList(turnoList: List<Turno>) {

        val turnoListView = turnoList.map { it.descrTurno }

        val listAdapter = CustomAdapter(turnoListView).apply {
            onItemClick = { _, pos ->
                viewModel.setIdTurno(turnoList[pos])
                findNavController().navigate(R.id.action_turnoBolFragment_to_OSBolFragment)
            }
        }
        binding.listTurno.run {
            setHasFixedSize(true)
            adapter = listAdapter
        }
    }

    private fun setListener() {
        with(binding){
            buttonAtualTurno.setOnClickListener {
                viewModel.updateDataTurno()
            }
            buttonRetTurno.setOnClickListener {
                findNavController().navigate(R.id.action_turnoBolFragment_to_equipBolFragment)
            }
        }
    }

    private fun startEvents() {
        viewModel.recoverListTurno()
    }

    private fun handleStateChange(state: TurnoBolFragmentState){
        when(state){
            is TurnoBolFragmentState.Init -> Unit
            is TurnoBolFragmentState.ListTurno -> handleTurnoList(state.turnoList)
            is TurnoBolFragmentState.IsUpdateTurno -> handleUpdate(state.isUpdateTurno)
        }
    }

    private fun handleTurnoList(turnoList: List<Turno>) {
        viewList(turnoList)
    }

    private fun handleStatusUpdate(resultUpdateDataBase: ResultUpdateDataBase?){
        with(binding) {
            resultUpdateDataBase?.let {
                genericDialogProgressBar.setValue(resultUpdateDataBase)
            }
        }
    }

    private fun handleUpdate(isUpdate: Boolean){
        if(isUpdate){
            genericDialogProgressBar = GenericDialogProgressBar(requireContext())
            genericDialogProgressBar.show()
            genericDialogProgressBar.window?.setLayout(
                WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
            )
        } else {
            genericDialogProgressBar.cancel()
            showToast(getString(R.string.texto_msg_atualizacao, "COLABORADORES"), requireContext())
        }
    }

}