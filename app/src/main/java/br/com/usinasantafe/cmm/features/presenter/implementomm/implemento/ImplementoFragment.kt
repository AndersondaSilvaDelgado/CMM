package br.com.usinasantafe.cmm.features.presenter.implementomm.implemento

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.dialog.GenericDialogProgressBar
import br.com.usinasantafe.cmm.common.extension.setListenerButtonsGeneric
import br.com.usinasantafe.cmm.common.extension.showGenericAlertDialog
import br.com.usinasantafe.cmm.common.extension.showToast
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import br.com.usinasantafe.cmm.common.utils.StatusImplemento
import br.com.usinasantafe.cmm.common.utils.StatusUpdate
import br.com.usinasantafe.cmm.databinding.FragmentImplementoBinding
import br.com.usinasantafe.cmm.features.presenter.implementomm.FragmentAttachListenerImplemento
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImplementoFragment : BaseFragment<FragmentImplementoBinding>(
    R.layout.fragment_implemento,
    FragmentImplementoBinding::bind
) {

    private var position = 0
    private val viewModel: ImplementoViewModel by viewModels()
    private var genericDialogProgressBar: GenericDialogProgressBar? = null
    private var fragmentAttachListenerImplemento: FragmentAttachListenerImplemento? = null
    private lateinit var describeUpdate: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeState()
        startEvents()
        setListener()

    }

    private fun observeState() {
        viewModel.uiLiveData.observe(viewLifecycleOwner) {
            state -> handleStateChange(state)
        }
    }

    private fun startEvents() {
        viewModel.checkPositionImplemento()
    }

    private fun setListener() {
        with(binding){
            setListenerButtonsGeneric(layoutBotoes, editTextPadrao)
            layoutBotoes.buttonOkPadrao.setOnClickListener {
                if(position == 1){
                    if(editTextPadrao.text.isNotEmpty()){
                        viewModel.checkEquipImplemento(editTextPadrao.text.toString())
                    } else {
                        showGenericAlertDialog(getString(R.string.texto_campo_vazio, "HORIMETRO INICIAL"), requireContext())
                    }
                } else {
                    if(editTextPadrao.text.isNotEmpty()){
                        viewModel.checkEquipImplemento(editTextPadrao.text.toString())
                    } else {
                        fragmentAttachListenerImplemento?.goAtivMMFert()
                    }
                }
            }
            layoutBotoes.buttonAtualPadrao.setOnClickListener {
                viewModel.updateDataEquipSeg()
            }
        }
    }

    private fun handleStateChange(state: ImplementoFragmentState) {
        when (state) {
            is ImplementoFragmentState.CheckPositionImplemento -> handleSetTitle(state.position)
            is ImplementoFragmentState.CheckImplemento -> handleCheckImplemento(state.checkImplemento)
            is ImplementoFragmentState.CheckAddImplemento -> handleAddImplemento(state.checkAddImplemento)
            is ImplementoFragmentState.FeedbackUpdate -> handleUpdate(state.statusUpdate)
            is ImplementoFragmentState.SetResultUpdate -> handleStatusUpdate(state.resultUpdateDatabase)
            is ImplementoFragmentState.ReturnImplemento -> handleReturn(state.returnImplemento)
        }
    }

    private fun handleCheckImplemento(checkImplemento: StatusImplemento){
        when(checkImplemento){
            StatusImplemento.OK -> addImplemento()
            StatusImplemento.INEXISTENTE -> showMsgEquipNonExistent()
            StatusImplemento.REPETIDO -> showMsgImplementoRepeated()
        }
    }

    private fun handleSetTitle(position: Int){
        this.position = position
        binding.textViewImplemento.text = getString(R.string.texto_implemento, position.toString())
    }

    private fun showMsgEquipNonExistent(){
        showGenericAlertDialog(getString(R.string.texto_equip_invalido, "IMPLEMENTO"), requireContext())
    }

    private fun showMsgImplementoRepeated(){
        showGenericAlertDialog(getString(R.string.texto_implemento_repeated), requireContext())
    }

    private fun addImplemento(){
        viewModel.checkAddImplemento(binding.editTextPadrao.text.toString())
    }

    private fun handleAddImplemento(checkAddImplemento: Boolean) {
        if (checkAddImplemento) {
            if(position == 1){
                fragmentAttachListenerImplemento?.goImplemento()
            } else {
                fragmentAttachListenerImplemento?.goAtivMMFert()
            }
        } else {
            showGenericAlertDialog(getString(R.string.texto_falha_insercao_campo, "IMPLEMENTO"), requireContext())
        }
    }

    private fun handleUpdate(statusUpdate: StatusUpdate) {
        when (statusUpdate) {
            StatusUpdate.ATUALIZADO -> {
                hideProgressBar()
                showToast(
                    getString(R.string.texto_msg_atualizacao, "IMPLEMENTOS"),
                    requireContext()
                )
            }
            StatusUpdate.FALHA -> {
                hideProgressBar()
                showToast(
                    getString(R.string.texto_update_failure, describeUpdate),
                    requireContext()
                )
            }
        }
    }

    private fun handleStatusUpdate(resultUpdateDatabase: ResultUpdateDatabase?) {
        resultUpdateDatabase?.let {
            if (genericDialogProgressBar == null) {
                showProgressBar()
            }
            describeUpdate = resultUpdateDatabase.describe
            genericDialogProgressBar!!.setValue(resultUpdateDatabase)
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
        if (genericDialogProgressBar != null) {
            genericDialogProgressBar!!.cancel()
        }
        genericDialogProgressBar = null
    }

    private fun handleReturn(returnImplemento: Boolean){
        if(returnImplemento){
            viewModel.checkPositionImplemento()
        } else {
            getString(R.string.texto_falha_acesso_processo, "RETORNO DE IMPLEMENTO")
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragmentAttachListenerImplemento){
            fragmentAttachListenerImplemento = context
        }
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if(position == 2){
                    viewModel.returnImplemento()
                }
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            this, callback
        )
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentAttachListenerImplemento = null
    }

}