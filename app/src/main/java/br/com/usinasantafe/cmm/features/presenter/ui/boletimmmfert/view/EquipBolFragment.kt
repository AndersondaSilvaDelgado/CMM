package br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.databinding.FragmentEquipBolBinding
import br.com.usinasantafe.cmm.features.domain.entities.stable.Equip
import br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel.EquipBolFragmentState
import br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel.EquipBolViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EquipBolFragment : BaseFragment<FragmentEquipBolBinding>(
    R.layout.fragment_equip_bol,
    FragmentEquipBolBinding::bind
) {

    private val viewModel: EquipBolViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
        startEvents()
        setListener()

    }

    private fun observe() {
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

    private fun setListener() {
        with(binding){
            buttonOkEquip.setOnClickListener {
                findNavController().navigate(R.id.action_equipBolFragment_to_turnoBolFragment)
            }
            buttonCancEquip.setOnClickListener {
                findNavController().navigate(R.id.action_equipBolFragment_to_operadorBolFragment)
            }
        }
    }

    private fun startEvents() {
        viewModel.recoverNroEquip()
    }

    private fun handleStateChange(state: EquipBolFragmentState){
        when(state){
            is EquipBolFragmentState.Init -> Unit
            is EquipBolFragmentState.GetNroEquip -> handleEquip(state.equip)
        }
    }

    private fun handleEquip(equip: Equip) {
        with(binding){
            textViewCodEquip.text = equip.nroEquip.toString()
            textViewDescEquip.text = equip.descrClasseEquip
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
            }
        }
        requireActivity().onBackPressedDispatcher.addCallback(
            this, callback
        )
    }

}