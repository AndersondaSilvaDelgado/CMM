package br.com.usinasantafe.cmm.features.presenter.checklist.pergatualchecklist

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.dialog.GenericDialogProgressBar
import br.com.usinasantafe.cmm.common.extension.onBackPressed
import br.com.usinasantafe.cmm.common.extension.showToast
import br.com.usinasantafe.cmm.common.utils.StatusUpdate
import br.com.usinasantafe.cmm.databinding.FragmentPergAtualCheckListBinding
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import br.com.usinasantafe.cmm.features.presenter.checklist.FragmentAttachListenerCheckList
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class PergAtualCheckListFragment : BaseFragment<FragmentPergAtualCheckListBinding>(
    R.layout.fragment_perg_atual_check_list,
    FragmentPergAtualCheckListBinding::bind
) {

    private val viewModel: PergAtualCheckListViewModel by viewModels()
    private var fragmentAttachListenerCheckList: FragmentAttachListenerCheckList? = null
    private var genericDialogProgressBar: GenericDialogProgressBar? = null
    private lateinit var describeUpdate: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeState()
        setListener()

    }

    private fun observeState(){
        viewModel.uiLiveData.observe(viewLifecycleOwner) {
            state -> handleStateChange(state)
        }
    }

    private fun setListener() {
        with(binding){
            buttonSimAtualizarChecklist.setOnClickListener {
                viewModel.updateDataCheckList()
            }
            buttonNaoAtualizarChecklist.setOnClickListener {
                fragmentAttachListenerCheckList?.goItemCheckListFragment()
            }
        }
    }

    private fun handleStateChange(state: PergAtualCheckListFragmentState) {
        when(state){
            is PergAtualCheckListFragmentState.FeedbackUpdate -> handleUpdate(state.statusUpdate)
            is PergAtualCheckListFragmentState.SetResultUpdate -> handleStatusUpdate(state.resultUpdateDatabase)
        }
    }

    private fun handleUpdate(statusUpdate: StatusUpdate) {
        when (statusUpdate) {
            StatusUpdate.ATUALIZADO -> {
                hideProgressBar()
                showToast(
                    getString(R.string.texto_msg_atualizacao, "CHECKLIST"),
                    requireContext()
                )
                fragmentAttachListenerCheckList?.goItemCheckListFragment()
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

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragmentAttachListenerCheckList){
            fragmentAttachListenerCheckList = context
        }
        onBackPressed {
            fragmentAttachListenerCheckList?.goItemCheckListFragment()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentAttachListenerCheckList = null
    }

}