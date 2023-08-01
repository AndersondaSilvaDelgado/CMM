package br.com.usinasantafe.cmm.features.presenter.boletimmmfert.horimetrobol

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.extension.onBackPressed
import br.com.usinasantafe.cmm.common.extension.setListenerButtonsGenericCVirgula
import br.com.usinasantafe.cmm.common.extension.showGenericAlertDialog
import br.com.usinasantafe.cmm.common.utils.ChoiceHorimetro
import br.com.usinasantafe.cmm.databinding.FragmentHorimetroBolBinding
import br.com.usinasantafe.cmm.features.presenter.boletimmmfert.FragmentAttachListenerBoletim
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HorimetroBolFragment : BaseFragment<FragmentHorimetroBolBinding>(
    R.layout.fragment_horimetro_bol,
    FragmentHorimetroBolBinding::bind
) {

    private val viewModel: HorimetroBolViewModel by viewModels()
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

    private fun startEvents() {
        viewModel.checkBoletim()
    }

    private fun setListener() {
        with(binding){
            setListenerButtonsGenericCVirgula(layoutBotoes, editTextPadrao)
            layoutBotoes.buttonOkPadrao.setOnClickListener {
                if(editTextPadrao.text.isNotEmpty()){
                    viewModel.checkHorimetro(editTextPadrao.text.toString())
                } else {
                    showGenericAlertDialog(getString(R.string.texto_campo_vazio, "HORIMETRO INICIAL"), requireContext())
                }
            }
        }
    }

    private fun handleStateChange(state: HorimetroBolFragmentState){
        when(state){
            is HorimetroBolFragmentState.Init -> Unit
            is HorimetroBolFragmentState.CheckSetHorimetroInicial -> handleCheckSetHorimetroInicial(state.choiceHorimetro)
            is HorimetroBolFragmentState.CheckSetHorimetroFinal -> handleCheckSetHorimetroFinal(state.checkSetHorimetroFinal)
            is HorimetroBolFragmentState.HorimetroInicial -> handleSetTitle("INICIAL")
            is HorimetroBolFragmentState.HorimetroFinal -> handleSetTitle("FINAL")
            is HorimetroBolFragmentState.CheckHorimetro -> handleCheckHorimetro(state.checkHorimetro)
            is HorimetroBolFragmentState.HorimetroNonCompliant -> showMessage(state.horimetro)
        }
    }

    private fun handleSetTitle(title: String){
        binding.textViewPadrao.text = getString(R.string.texto_horimetro, title)
    }

    private fun handleCheckHorimetro(checkHorimetro: Boolean) {
        if(checkHorimetro){
            setHorimetro()
        } else {
            recoverHorimetro()
        }
    }

    private fun handleCheckSetHorimetroInicial(choiceHorimetro: ChoiceHorimetro) {
        when(choiceHorimetro){
            ChoiceHorimetro.FALHA -> showGenericAlertDialog(getString(R.string.texto_falha_insercao_campo, "HORIMETRO INICIAL"), requireContext())
            ChoiceHorimetro.APONTAMENTO -> fragmentAttachListenerBoletim?.goAtivMMFert()
            ChoiceHorimetro.CHECKLIST -> fragmentAttachListenerBoletim?.goCheckList()
            ChoiceHorimetro.IMPLEMENTO -> fragmentAttachListenerBoletim?.goImplemento()
        }
    }

    private fun handleCheckSetHorimetroFinal(checkSetHorimetro: Boolean) {
        if(checkSetHorimetro){
            fragmentAttachListenerBoletim?.goConfig()
        } else {
            showGenericAlertDialog(getString(R.string.texto_falha_insercao_campo, "HORIMETRO FINAL"), requireContext())
        }
    }

    private fun setHorimetro() {
        viewModel.setHorimetro(binding.editTextPadrao.text.toString())
    }

    private fun recoverHorimetro() {
        viewModel.recoverHorimetro()
    }

    private fun showMessage(horimetro: String){
        with(binding) {
            AlertDialog.Builder(requireContext())
                .setMessage("O HODÔMETRO REGISTRADO ${editTextPadrao.text} É MENOR QUE O ANTERIOR DE ${horimetro}. DESEJA MANTÊ-LO?")
                .setPositiveButton("SIM") { _, _ ->
                    viewModel.setHorimetro(editTextPadrao.text.toString())
                }
                .setNegativeButton("NÃO", null)
                .create()
                .show()
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragmentAttachListenerBoletim){
            fragmentAttachListenerBoletim = context
        }
        onBackPressed {
            fragmentAttachListenerBoletim?.goAtivBolFragment()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentAttachListenerBoletim = null
    }

}