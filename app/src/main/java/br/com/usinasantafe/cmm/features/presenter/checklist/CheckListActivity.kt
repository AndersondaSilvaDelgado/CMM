package br.com.usinasantafe.cmm.features.presenter.checklist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.extension.replaceFragment
import br.com.usinasantafe.cmm.databinding.ActivityCheckListBinding
import br.com.usinasantafe.cmm.features.presenter.apontmmfert.ApontActivity
import br.com.usinasantafe.cmm.features.presenter.checklist.itemchecklist.ItemCheckListFragment
import br.com.usinasantafe.cmm.features.presenter.checklist.pergatualchecklist.PergAtualCheckListFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CheckListActivity : AppCompatActivity(), FragmentAttachListenerCheckList {

    private val viewModel: CheckListViewModel by viewModels()

    private lateinit var binding: ActivityCheckListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        observeState()
        startEvents()

    }

    private fun observeState(){
        viewModel.uiLiveData.observe(this) {
            state -> handleStateChange(state)
        }
    }

    private fun startEvents() {
        viewModel.checkBoletim()
    }

    private fun handleStateChange(state: CheckListViewState){
        when(state){
            CheckListViewState.PergAtualCheckList -> handlePergAtualCheckList()
            CheckListViewState.ItemCheckList -> handleItemCheckList()
        }
    }

    private fun handlePergAtualCheckList() {
        goPergAtualCheckListFragment()
    }

    private fun handleItemCheckList() {
        goItemCheckListFragment()
    }

    private fun replaceFragment(fragment: Fragment){
        replaceFragment(R.id.check_list_manager_fragment, fragment)
    }

    override fun goItemCheckListFragment() {
        replaceFragment(ItemCheckListFragment())
    }

    override fun goPergAtualCheckListFragment() {
        replaceFragment(PergAtualCheckListFragment())
    }

    override fun goAtivMMFert() {
        val intent = Intent(this, ApontActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

}