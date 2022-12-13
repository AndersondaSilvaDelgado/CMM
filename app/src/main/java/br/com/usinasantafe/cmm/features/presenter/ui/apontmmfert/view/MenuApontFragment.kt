package br.com.usinasantafe.cmm.features.presenter.ui.apontmmfert.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.adapter.CustomAdapter
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.common.extension.showGenericAlertDialog
import br.com.usinasantafe.cmm.databinding.FragmentMenuApontBinding
import br.com.usinasantafe.cmm.features.presenter.ui.apontmmfert.viewmodel.MenuApontFragmentState
import br.com.usinasantafe.cmm.features.presenter.ui.apontmmfert.viewmodel.MenuApontViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MenuApontFragment : BaseFragment<FragmentMenuApontBinding>(
    R.layout.fragment_menu_apont,
    FragmentMenuApontBinding::bind
) {

    private val viewModel: MenuApontViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
        startEvents()

    }

    private fun observe() {
        observeState()
    }

    private fun observeState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiStateFlow.collect { state ->
                    handleStateChange(state)
                }
            }
        }
    }

    private fun viewList(menuApontList: List<String>) {

        val listAdapter = CustomAdapter(menuApontList).apply {
            onItemClick = { _, pos ->
                viewModel.setOpcaoMenu(pos)
            }
        }
        binding.listMenuPrinc.run {
            setHasFixedSize(true)
            adapter = listAdapter
        }
    }

    private fun handleStateChange(state: MenuApontFragmentState) {
        when (state) {
            is MenuApontFragmentState.Init -> Unit
            is MenuApontFragmentState.ListMenuApont -> opcaoMenu(state.menuApontList)
            is MenuApontFragmentState.SetApontTrab -> setApontTrab(state.apontTrab)
        }
    }

    private fun opcaoMenu(menuApontList: List<String>) {
        viewList(menuApontList)
    }

    private fun startEvents() {
        viewModel.recoverListMenuApont()
    }

    private fun setApontTrab(setApontTrab: Boolean) {
        if (setApontTrab) {
            findNavController().navigate(R.id.action_menuApontFragment_to_OSApontFragment)
        } else {
            showGenericAlertDialog(
                getString(R.string.texto_falha_acesso_processo, "TRABALHANDO"),
                requireContext()
            )
        }
    }

}