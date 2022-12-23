package br.com.usinasantafe.cmm.features.presenter.ui.apontmmfert.view

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.adapter.CustomAdapter
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.dialog.GenericDialogProgressBar
import br.com.usinasantafe.cmm.common.extension.showToast
import br.com.usinasantafe.cmm.common.utils.TypeNote
import br.com.usinasantafe.cmm.databinding.FragmentAtivApontBinding
import br.com.usinasantafe.cmm.features.domain.entities.stable.Atividade
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import br.com.usinasantafe.cmm.features.presenter.ui.apontmmfert.viewmodel.AtivApontFragmentState
import br.com.usinasantafe.cmm.features.presenter.ui.apontmmfert.viewmodel.AtivApontViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AtivApontFragment : BaseFragment<FragmentAtivApontBinding>(
    R.layout.fragment_ativ_apont,
    FragmentAtivApontBinding::bind
) {

    private val viewModel: AtivApontViewModel by viewModels()
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

    private fun viewList(ativList: List<Atividade>) {

        val ativListView = ativList.map { it.descrAtiv }

        val listAdapter = CustomAdapter(ativListView).apply {
            onItemClick = { _, pos ->
                viewModel.setIdAtiv(ativList[pos])
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

    private fun handleStateChange(state: AtivApontFragmentState){
        when(state){
            is AtivApontFragmentState.Init -> Unit
            is AtivApontFragmentState.ListAtiv -> handleAtivList(state.ativList)
            is AtivApontFragmentState.IsUpdateAtiv -> handleUpdate(state.isUpdateAtiv)
            is AtivApontFragmentState.CheckSetAtivApont -> handleCheckSetAtiv(state.typeNote)
        }
    }

    private fun handleAtivList(ativList: List<Atividade>) {
        viewList(ativList)
    }

    private fun handleStatusUpdate(resultUpdateDataBase: ResultUpdateDataBase?){
        resultUpdateDataBase?.let {
            genericDialogProgressBar.setValue(resultUpdateDataBase)
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

    private fun handleCheckSetAtiv(typeNote: TypeNote){
        when(typeNote){
            TypeNote.TRABALHANDO -> findNavController().navigate(R.id.action_ativApontFragment_to_menuApontFragment)
            TypeNote.PARADA -> findNavController().navigate(R.id.action_ativApontFragment_to_paradaApontFragment)
            TypeNote.FALHA -> showToast(getString(R.string.texto_falha_insercao_campo, "ATIVIDADE"), requireContext())
        }
    }

}