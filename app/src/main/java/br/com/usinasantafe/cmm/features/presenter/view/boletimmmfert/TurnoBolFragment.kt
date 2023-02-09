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
import br.com.usinasantafe.cmm.common.adapter.CustomAdapter
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.dialog.GenericDialogProgressBar
import br.com.usinasantafe.cmm.common.extension.showToast
import br.com.usinasantafe.cmm.common.utils.StatusUpdate
import br.com.usinasantafe.cmm.databinding.FragmentTurnoBolBinding
import br.com.usinasantafe.cmm.features.domain.entities.stable.Turno
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert.TurnoBolFragmentState
import br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert.TurnoBolViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TurnoBolFragment : BaseFragment<FragmentTurnoBolBinding>(
    R.layout.fragment_turno_bol,
    FragmentTurnoBolBinding::bind
) {

    private val viewModel: TurnoBolViewModel by viewModels()
    private var genericDialogProgressBar: GenericDialogProgressBar? = null
    private var fragmentAttachListenerBoletim: FragmentAttachListenerBoletim? = null
    private lateinit var describeUpdate: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
        startEvents()
        setListener()

    }

    fun observe() {
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

    private fun viewList(turnoList: List<Turno>) {

        val turnoListView = turnoList.map { it.descrTurno }

        val listAdapter = CustomAdapter(turnoListView).apply {
            onItemClick = { _, pos ->
                viewModel.setIdTurno(turnoList[pos])
                fragmentAttachListenerBoletim?.goOSBolFragment()
            }
        }
        binding.listTurno.run {
            setHasFixedSize(true)
            adapter = listAdapter
        }
    }

    private fun setListener() {
        with(binding) {
            buttonAtualTurno.setOnClickListener {
                viewModel.updateDataTurno()
            }
            buttonRetTurno.setOnClickListener {
                fragmentAttachListenerBoletim?.popBackStack()
            }
        }
    }

    private fun startEvents() {
        viewModel.recoverListTurno()
    }

    private fun handleStateChange(state: TurnoBolFragmentState) {
        when (state) {
            is TurnoBolFragmentState.Init -> Unit
            is TurnoBolFragmentState.ListTurno -> handleTurnoList(state.turnoList)
            is TurnoBolFragmentState.FeedbackUpdateTurno -> handleUpdate(state.statusUpdate)
            is TurnoBolFragmentState.SetResultUpdate -> handleStatusUpdate(state.resultUpdateDataBase)
        }
    }

    private fun handleTurnoList(turnoList: List<Turno>) {
        viewList(turnoList)
    }

    private fun handleStatusUpdate(resultUpdateDataBase: ResultUpdateDataBase?) {
        resultUpdateDataBase?.let {
            if(genericDialogProgressBar == null){
                showProgressBar()
            }
            describeUpdate = resultUpdateDataBase.describe
            genericDialogProgressBar!!.setValue(resultUpdateDataBase)
        }
    }

    private fun handleUpdate(statusUpdate: StatusUpdate) {
        when(statusUpdate){
            StatusUpdate.ATUALIZADO -> {
                hideProgressBar()
                showToast(getString(R.string.texto_msg_atualizacao, "COLABORADORES"), requireContext())
            }
            StatusUpdate.FALHA -> {
                hideProgressBar()
                showToast(getString(R.string.texto_update_failure, describeUpdate), requireContext())
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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragmentAttachListenerBoletim){
            fragmentAttachListenerBoletim = context
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentAttachListenerBoletim = null
    }

}