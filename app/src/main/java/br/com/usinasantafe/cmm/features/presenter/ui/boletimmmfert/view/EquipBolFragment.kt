package br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.databinding.FragmentEquipBolBinding
import br.com.usinasantafe.cmm.features.domain.entities.Equip
import br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel.EquipBolFragmentState
import br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.viewmodel.EquipBolViewModel
import br.com.usinasantafe.cmm.features.presenter.ui.config.view.ConfigActivity
import br.com.usinasantafe.cmm.features.presenter.ui.config.viewmodel.ConfigFragmentState
import br.com.usinasantafe.cmm.features.presenter.ui.config.viewmodel.ConfigViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

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
        viewModel.uiStateFlow.flowWithLifecycle(viewLifecycleOwner.lifecycle, Lifecycle.State.STARTED)
            .onEach { state -> handleStateChange(state) }
            .launchIn(viewLifecycleOwner.lifecycleScope)
    }

    private fun setListener() {
        with(binding){
            buttonOkEquip.setOnClickListener {
                viewModel.setEquip()
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