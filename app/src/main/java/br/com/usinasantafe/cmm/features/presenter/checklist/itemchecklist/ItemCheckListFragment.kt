package br.com.usinasantafe.cmm.features.presenter.checklist.itemchecklist

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.extension.onBackPressed
import br.com.usinasantafe.cmm.common.utils.ChoiceCheckList
import br.com.usinasantafe.cmm.databinding.FragmentItemCheckListBinding
import br.com.usinasantafe.cmm.features.presenter.checklist.FragmentAttachListenerCheckList
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemCheckListFragment : BaseFragment<FragmentItemCheckListBinding>(
    R.layout.fragment_item_check_list,
    FragmentItemCheckListBinding::bind
) {

    private var position = 0
    private val viewModel: ItemCheckListViewModel by viewModels()
    private var fragmentAttachListenerCheckList: FragmentAttachListenerCheckList? = null

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

    private fun setListener() {
        with(binding){
            buttonConforme.setOnClickListener {
                viewModel.checkAddRespItemCheckList(ChoiceCheckList.CONFORME, position)
            }
            buttonReparo.setOnClickListener {
                viewModel.checkAddRespItemCheckList(ChoiceCheckList.REPARO, position)
            }
            buttonNaoConforme.setOnClickListener {
                viewModel.checkAddRespItemCheckList(ChoiceCheckList.NAOCONFORME, position)
            }
            buttonCancChecklist.setOnClickListener {
                viewModel.checkDeleteRespItemCheckList(--position)
            }
        }
    }

    private fun startEvents() {
        viewModel.recoverItemCheckList(++position)
    }

    private fun handleStateChange(state: ItemCheckListFragmentState) {
        when(state) {
            is ItemCheckListFragmentState.GetItemCheckList -> displayItemCheckList(state.descrItemCheckList)
            is ItemCheckListFragmentState.CheckAddItemCheckList -> handleAddItemCheckList()
            is ItemCheckListFragmentState.CheckLastItemCheckList -> handleLastRespItemCheckList(state.checkLastItemCheckList)
            is ItemCheckListFragmentState.CheckDeleteItemCheckList -> handleDeleteRespItemCheckList()
            is ItemCheckListFragmentState.CheckCloseCheckList -> handleCloseCheckList()
        }
    }

    private fun handleAddItemCheckList(){
        viewModel.checkLastRespItemCheckList()
    }

    private fun handleCloseCheckList(){
        fragmentAttachListenerCheckList?.goAtivMMFert()
    }

    private fun handleDeleteRespItemCheckList(){
        viewModel.recoverItemCheckList(position)
    }

    private fun handleLastRespItemCheckList(checkLastItemCheckList: Boolean){
        if(checkLastItemCheckList){
            viewModel.checkCloseCheckList()
        } else {
            viewModel.recoverItemCheckList(++position)
        }
    }

    private fun displayItemCheckList(descrItemCheckList: String){
        binding.textViewItemChecklist.text = "$position - $descrItemCheckList"
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragmentAttachListenerCheckList){
            fragmentAttachListenerCheckList = context
        }
        onBackPressed {}
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentAttachListenerCheckList = null
    }

}