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
import br.com.usinasantafe.cmm.common.utils.TypeNote
import br.com.usinasantafe.cmm.databinding.FragmentAtivApontBinding
import br.com.usinasantafe.cmm.features.domain.entities.stable.Ativ
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDatabase
import br.com.usinasantafe.cmm.features.presenter.viewmodel.apontmmfert.AtivApontFragmentState
import br.com.usinasantafe.cmm.features.presenter.viewmodel.apontmmfert.AtivApontViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AtivApontFragment : BaseFragment<FragmentAtivApontBinding>(
    R.layout.fragment_ativ_apont,
    FragmentAtivApontBinding::bind
) {

    private val viewModel: AtivApontViewModel by viewModels()
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

    private fun viewList(ativList: List<Ativ>) {

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
                fragmentAttachListenerApont?.goOSApontFragment()
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
            is AtivApontFragmentState.SetResultUpdate -> handleStatusUpdate(state.resultUpdateDatabase)
        }
    }

    private fun handleAtivList(ativList: List<Ativ>) {
        viewList(ativList)
    }

    private fun handleStatusUpdate(resultUpdateDatabase: ResultUpdateDatabase?){
        resultUpdateDatabase?.let {
            genericDialogProgressBar.setValue(resultUpdateDatabase)
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
            TypeNote.TRABALHANDO -> fragmentAttachListenerApont?.goMenuApontFragment()
            TypeNote.PARADA -> fragmentAttachListenerApont?.goParadaApontFragment()
            TypeNote.FALHA -> showToast(getString(R.string.texto_falha_insercao_campo, "ATIVIDADE"), requireContext())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragmentAttachListenerApont){
            fragmentAttachListenerApont = context
        }
        onBackPressed {
            fragmentAttachListenerApont?.goOSApontFragment()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentAttachListenerApont = null
    }

}