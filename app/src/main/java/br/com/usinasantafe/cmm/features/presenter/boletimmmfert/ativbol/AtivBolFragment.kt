package br.com.usinasantafe.cmm.features.presenter.boletimmmfert.ativbol

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
import br.com.usinasantafe.cmm.common.extension.showGenericAlertDialog
import br.com.usinasantafe.cmm.common.extension.showToast
import br.com.usinasantafe.cmm.databinding.FragmentAtivBolBinding
import br.com.usinasantafe.cmm.features.domain.entities.stable.Ativ
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import br.com.usinasantafe.cmm.features.presenter.boletimmmfert.FragmentAttachListenerBoletim
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AtivBolFragment : BaseFragment<FragmentAtivBolBinding>(
    R.layout.fragment_ativ_bol,
    FragmentAtivBolBinding::bind
) {

    private val viewModel: AtivBolViewModel by viewModels()
    private lateinit var genericDialogProgressBar: GenericDialogProgressBar
    private var fragmentAttachListenerBoletim: FragmentAttachListenerBoletim? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeState()
        startEvents()
        setListener()

    }

    private fun observeState(){
        viewModel.uiLiveData.observe(viewLifecycleOwner) {
            state -> handleStateChange(state)
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
                fragmentAttachListenerBoletim?.goOSBolFragment()
            }
        }
    }

    private fun startEvents() {
        viewModel.recoverListAtiv()
    }

    private fun handleStateChange(state: AtivBolFragmentState){
        when(state){
            is AtivBolFragmentState.ListAtiv -> handleAtivList(state.ativList)
            is AtivBolFragmentState.IsUpdateAtiv -> handleUpdate(state.isUpdateAtiv)
            is AtivBolFragmentState.SetResultUpdate -> handleStatusUpdate(state.resultUpdateDatabase)
            is AtivBolFragmentState.CheckSetAtiv -> handleCheckSetAtiv(state.check)
        }
    }

    private fun handleCheckSetAtiv(checkSetTurno: Boolean) {
        if(checkSetTurno){
            fragmentAttachListenerBoletim?.goHorimetroBolFragment()
        } else {
            showGenericAlertDialog(getString(R.string.texto_falha_insercao_campo, "HORIMETRO INICIAL"), requireContext())
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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragmentAttachListenerBoletim){
            fragmentAttachListenerBoletim = context
        }
        onBackPressed {
            fragmentAttachListenerBoletim?.goOSBolFragment()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentAttachListenerBoletim = null
    }

}