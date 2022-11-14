package br.com.usinasantafe.cmm.common.extension

import android.content.Context
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.databinding.LayoutBotoesBinding

fun Fragment.showToast(message: String, context: Context){
    Toast.makeText(context, message, Toast.LENGTH_LONG).show()
}

fun Fragment.showGenericAlertDialog(message: String, context: Context){
    AlertDialog.Builder(context).apply {
        setMessage(message)
        setPositiveButton(getString(R.string.texto_padrao_ok)){ dialog, _ ->
            dialog.dismiss()
        }
    }.show()
}

fun Fragment.setListenerButtonsGeneric(layoutBotoesBinding: LayoutBotoesBinding, editText: EditText){
    layoutBotoesBinding.buttonNum0.setOnClickListener {
        editText.setText("${editText.text}0")
    }
    layoutBotoesBinding.buttonNum1.setOnClickListener {
        editText.setText("${editText.text}1")
    }
    layoutBotoesBinding.buttonNum2.setOnClickListener {
        editText.setText("${editText.text}2")
    }
    layoutBotoesBinding.buttonNum3.setOnClickListener {
        editText.setText("${editText.text}3")
    }
    layoutBotoesBinding.buttonNum4.setOnClickListener {
        editText.setText("${editText.text}4")
    }
    layoutBotoesBinding.buttonNum5.setOnClickListener {
        editText.setText("${editText.text}5")
    }
    layoutBotoesBinding.buttonNum6.setOnClickListener {
        editText.setText("${editText.text}6")
    }
    layoutBotoesBinding.buttonNum7.setOnClickListener {
        editText.setText("${editText.text}7")
    }
    layoutBotoesBinding.buttonNum8.setOnClickListener {
        editText.setText("${editText.text}8")
    }
    layoutBotoesBinding.buttonNum9.setOnClickListener {
        editText.setText("${editText.text}9")
    }
    layoutBotoesBinding.buttonCancPadrao.setOnClickListener {
        if (editText.text.isNotEmpty()) {
            editText.setText(editText.text.substring(0, editText.text.length - 1))
        }
    }
}

interface BackPressHandler {
    fun onBackPressed(): Boolean
}