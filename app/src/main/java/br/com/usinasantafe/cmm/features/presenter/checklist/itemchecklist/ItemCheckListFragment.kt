package br.com.usinasantafe.cmm.features.presenter.checklist.itemchecklist

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.extension.onBackPressed
import br.com.usinasantafe.cmm.databinding.FragmentItemCheckListBinding
import br.com.usinasantafe.cmm.features.presenter.checklist.FragmentAttachListenerCheckList
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ItemCheckListFragment : BaseFragment<FragmentItemCheckListBinding>(
    R.layout.fragment_item_check_list,
    FragmentItemCheckListBinding::bind
) {

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
        TODO("Not yet implemented")
    }

    private fun startEvents() {

    }

    private fun handleStateChange(state: ItemCheckListFragmentState) {

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