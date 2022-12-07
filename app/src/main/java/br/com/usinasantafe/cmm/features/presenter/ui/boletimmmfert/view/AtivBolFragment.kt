package br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.view

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.adapter.CustomAdapter
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.dialog.GenericDialogProgressBar
import br.com.usinasantafe.cmm.common.extension.showToast
import br.com.usinasantafe.cmm.databinding.FragmentAtivBolBinding
import br.com.usinasantafe.cmm.features.domain.entities.Atividade
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel.AtivBolFragmentState
import br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel.AtivBolViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class AtivBolFragment : BaseFragment<FragmentAtivBolBinding>(
    R.layout.fragment_ativ_bol,
    FragmentAtivBolBinding::bind
) {

    private val viewModel: AtivBolViewModel by viewModels()
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
        viewModel.uiStateFlow.flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
            .onEach { state -> handleStateChange(state) }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun observeResult(){
        viewModel.resultUpdateDataBase.flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
            .onEach { state -> handleStatusUpdate(state) }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun viewList(ativList: List<Atividade>) {

        val ativListView = ativList.map { it.descrAtiv }

        val listAdapter = CustomAdapter(ativListView).apply {
            onItemClick = { text, pos ->
                viewModel.setIdAtiv(ativList[pos])
                findNavController().navigate(R.id.action_ativBolFragment_to_horimetroBolFragment)
            }
        }
        binding.listAtividade.run {
            setHasFixedSize(true)
            adapter = listAdapter
        }
    }

    private fun setListener() {
        with(binding){
            buttonAtualAtividade.setOnClickListener {
                viewModel.updateDataAtiv()
            }
            buttonRetAtividade.setOnClickListener {
                findNavController().navigate(R.id.action_ativBolFragment_to_OSBolFragment)
            }
        }
    }

    private fun startEvents() {
        viewModel.recoverListAtiv()
    }

    private fun handleStateChange(state: AtivBolFragmentState){
        when(state){
            is AtivBolFragmentState.Init -> Unit
            is AtivBolFragmentState.ListAtiv -> handleAtivList(state.ativList)
            is AtivBolFragmentState.IsUpdateAtiv -> handleUpdate(state.isUpdateAtiv)
        }
    }

    private fun handleAtivList(ativList: List<Atividade>) {
        viewList(ativList)
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