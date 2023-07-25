package br.com.usinasantafe.cmm.features.presenter.apontmmfert.osapont

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
import br.com.usinasantafe.cmm.common.extension.setListenerButtonsGenericSUpdate
import br.com.usinasantafe.cmm.common.extension.showGenericAlertDialog
import br.com.usinasantafe.cmm.common.utils.StatusRecover
import br.com.usinasantafe.cmm.databinding.FragmentOsApontBinding
import br.com.usinasantafe.cmm.common.utils.ResultUpdateDatabase
import br.com.usinasantafe.cmm.features.presenter.apontmmfert.FragmentAttachListenerApont
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class OSApontFragment : BaseFragment<FragmentOsApontBinding>(
    R.layout.fragment_os_apont,
    FragmentOsApontBinding::bind
) {

    private val viewModel: OSApontViewModel by viewModels()
    private var genericDialogProgressBar: GenericDialogProgressBar? = null
    private lateinit var describeRecover: String
    private var fragmentAttachListenerApont: FragmentAttachListenerApont? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeState()
        setListener()

    }

    private fun observeState() {
        viewModel.uiLiveData.observe(viewLifecycleOwner) {
            state -> handleStateChange(state)
        }
    }

    private fun setListener() {
        with(binding) {
            setListenerButtonsGenericSUpdate(layoutBotoes, editTextPadrao)
            layoutBotoes.buttonOkPadrao.setOnClickListener {
                if (editTextPadrao.text.isNotEmpty()) {
                    viewModel.checkDataNroOS(editTextPadrao.text.toString())
                } else {
                    showGenericAlertDialog(
                        getString(
                            R.string.texto_campo_vazio,
                            "MATRICULA DO OPERADOR"
                        ), requireContext()
                    )
                }
            }
        }
    }

    private fun handleStateChange(state: OSApontFragmentState) {
        when (state) {
            is OSApontFragmentState.CheckNroOS -> handleCheckNroOS(state.checkNroOS)
            is OSApontFragmentState.CheckSetNroOS -> fragmentAttachListenerApont?.goAtivApontFragment()
            is OSApontFragmentState.FeedbackUpdateOS -> handleFeedbackUpdateOS(state.statusRecover)
            is OSApontFragmentState.SetResultUpdate -> handleStatusUpdate(state.resultUpdateDatabase)
        }
    }

    private fun handleFeedbackUpdateOS(statusRecover: StatusRecover) {
        when (statusRecover) {
            StatusRecover.SUCESSO -> {
                hideProgressBar()
                fragmentAttachListenerApont?.goAtivApontFragment()
            }
            StatusRecover.VAZIO -> {
                hideProgressBar()
                showGenericAlertDialog(
                    getString(R.string.texto_dado_invalido, "OS"),
                    requireContext()
                )
            }
            StatusRecover.FALHA -> {
                hideProgressBar()
                showGenericAlertDialog(
                    getString(R.string.texto_update_failure, describeRecover),
                    requireContext()
                )
            }
        }
    }

    private fun handleCheckNroOS(checkNroOS: Boolean) {
        with(binding) {
            if (checkNroOS) {
                viewModel.setNroOS(editTextPadrao.text.toString())
            } else {
                viewModel.recoverDataOS(editTextPadrao.text.toString())
            }
        }
    }

    private fun handleStatusUpdate(resultUpdateDatabase: ResultUpdateDatabase?) {
        resultUpdateDatabase?.let {
            if (genericDialogProgressBar == null) {
                showProgressBar()
            }
            describeRecover = resultUpdateDatabase.describe
            genericDialogProgressBar!!.setValue(resultUpdateDatabase)
            if (resultUpdateDatabase.percentage == 100) {
                finishProgressBar()
            }
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

    private fun finishProgressBar() {
        hideProgressBar()
        if (describeRecover == "OS Inexistente!") {
            showGenericAlertDialog(getString(R.string.texto_dado_invalido, "OS"), requireContext())
        } else {
            viewModel.setNroOS(binding.editTextPadrao.text.toString())
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentAttachListenerApont) {
            fragmentAttachListenerApont = context
        }
        onBackPressed {
            fragmentAttachListenerApont?.goMenuApontFragment()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        fragmentAttachListenerApont = null
    }

}