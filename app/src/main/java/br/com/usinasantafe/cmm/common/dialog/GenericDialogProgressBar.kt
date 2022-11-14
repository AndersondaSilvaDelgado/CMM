package br.com.usinasantafe.cmm.common.dialog

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import br.com.usinasantafe.cmm.common.extension.percentage
import br.com.usinasantafe.cmm.databinding.DialogProgressBarGenericBinding
import br.com.usinasantafe.cmm.features.presenter.models.ResultUpdateDataBase

class GenericDialogProgressBar(
    context: Context
): Dialog(context) {

    private lateinit var binding: DialogProgressBarGenericBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DialogProgressBarGenericBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun setValue(resultUpdateDataBase: ResultUpdateDataBase){
        with(binding) {
            dialogProgressBarTitle.text = resultUpdateDataBase.describe
            progressBarGeneric.progress = percentage(resultUpdateDataBase.count, resultUpdateDataBase.size)
        }
    }

}