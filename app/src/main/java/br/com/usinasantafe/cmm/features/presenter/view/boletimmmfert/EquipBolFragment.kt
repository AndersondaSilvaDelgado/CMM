package br.com.usinasantafe.cmm.features.presenter.view.boletimmmfert

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.databinding.FragmentEquipBolBinding
import br.com.usinasantafe.cmm.features.domain.entities.stable.Equip
import br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert.EquipBolFragmentState
import br.com.usinasantafe.cmm.features.presenter.viewmodel.boletimmmfert.EquipBolViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class EquipBolFragment : BaseFragment<FragmentEquipBolBinding>(
    R.layout.fragment_equip_bol,
    FragmentEquipBolBinding::bind
) {

    private val viewModel: EquipBolViewModel by viewModels()
    private var fragmentAttachListenerBoletim: FragmentAttachListenerBoletim? = null

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
                fragmentAttachListenerBoletim?.goTurnoBolFragment()
            }
            buttonCancEquip.setOnClickListener {
                fragmentAttachListenerBoletim?.popBackStack()
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
        if(context is FragmentAttachListenerBoletim){
            fragmentAttachListenerBoletim = context
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentAttachListenerBoletim = null
    }

}