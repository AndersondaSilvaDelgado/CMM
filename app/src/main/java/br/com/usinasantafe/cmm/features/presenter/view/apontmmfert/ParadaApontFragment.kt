package br.com.usinasantafe.cmm.features.presenter.view.apontmmfert

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
import br.com.usinasantafe.cmm.common.extension.onBackPressed
import br.com.usinasantafe.cmm.common.extension.showToast
import br.com.usinasantafe.cmm.databinding.FragmentParadaApontBinding
import br.com.usinasantafe.cmm.features.domain.entities.stable.Parada
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase
import br.com.usinasantafe.cmm.features.presenter.viewmodel.apontmmfert.ParadaApontFragmentState
import br.com.usinasantafe.cmm.features.presenter.viewmodel.apontmmfert.ParadaApontViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ParadaApontFragment : BaseFragment<FragmentParadaApontBinding>(
    R.layout.fragment_parada_apont,
    FragmentParadaApontBinding::bind
) {
    private val viewModel: ParadaApontViewModel by viewModels()
    private lateinit var genericDialogProgressBar: GenericDialogProgressBar
    private var fragmentAttachListenerApont: FragmentAttachListenerApont? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
        startEvents()
        setListener()

    }

    fun observe(){
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

    private fun handleStateChange(state: ParadaApontFragmentState){
        when(state){
            is ParadaApontFragmentState.Init -> Unit
            is ParadaApontFragmentState.CheckSetParadaApont -> handleCheckSetParada(state.check)
            is ParadaApontFragmentState.IsUpdateParada -> handleUpdate(state.isUpdateParada)
            is ParadaApontFragmentState.ListParada -> handleParadaList(state.paradaList)
            is ParadaApontFragmentState.SetResultUpdate -> handleStatusUpdate(state.resultUpdateDataBase)
        }
    }

    private fun startEvents() {
        viewModel.recoverListParada()
    }

    private fun handleParadaList(paradaList: List<Parada>) {
        viewList(paradaList)
    }

    private fun viewList(paradaList: List<Parada>) {

        val paradaListView = paradaList.map { it.descrParada }

        val listAdapter = CustomAdapter(paradaListView).apply {
            onItemClick = { _, pos ->
                viewModel.setIdParada(paradaList[pos])
            }
        }
        binding.listViewMotParada.run {
            setHasFixedSize(true)
            adapter = listAdapter
        }
    }

    private fun handleCheckSetParada(check: Boolean){
        if(check){
            fragmentAttachListenerApont?.goMenuApontFragment()
        } else {
            showToast(getString(R.string.texto_falha_insercao_campo, "PARADA"), requireContext())
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

    private fun handleStatusUpdate(resultUpdateDataBase: ResultUpdateDataBase?){
        resultUpdateDataBase?.let {
            genericDialogProgressBar.setValue(resultUpdateDataBase)
        }
    }

    private fun setListener() {
        with(binding){
            buttonAtualParada.setOnClickListener {
                viewModel.updateDataParada()
            }
            buttonRetMenuParada.setOnClickListener {
                fragmentAttachListenerApont?.goAtivApontFragment()
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentAttachListenerApont) {
            fragmentAttachListenerApont = context
        }
        onBackPressed {
            fragmentAttachListenerApont?.goAtivApontFragment()
        }
    }
    override fun onDestroy() {
        super.onDestroy()
        fragmentAttachListenerApont = null
    }

}