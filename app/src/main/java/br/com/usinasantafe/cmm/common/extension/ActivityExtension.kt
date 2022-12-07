package br.com.usinasantafe.cmm.common.extension

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.Activity
import android.content.Context
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.databinding.LayoutBotoesBinding
import br.com.usinasantafe.cmm.databinding.LayoutBotoesSAtualBinding
import br.com.usinasantafe.cmm.databinding.LayoutBotoesVirgulaBinding

fun showToast(message: String, context: Context){
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

fun Activity.animationEnd(callback: () -> Unit): AnimatorListenerAdapter {
    return object : AnimatorListenerAdapter(){
        override fun onAnimationEnd(animation: Animator?) {
            callback.invoke()
        }
    }
}

fun setListenerButtonsGeneric(layoutBotoesBinding: LayoutBotoesBinding, editText: EditText){
    with(layoutBotoesBinding){
        buttonNum0.setOnClickListener {
            editText.setText("${editText.text}0")
        }
        buttonNum1.setOnClickListener {
            editText.setText("${editText.text}1")
        }
        buttonNum2.setOnClickListener {
            editText.setText("${editText.text}2")
        }
        buttonNum3.setOnClickListener {
            editText.setText("${editText.text}3")
        }
        buttonNum4.setOnClickListener {
            editText.setText("${editText.text}4")
        }
        buttonNum5.setOnClickListener {
            editText.setText("${editText.text}5")
        }
        buttonNum6.setOnClickListener {
            editText.setText("${editText.text}6")
        }
        buttonNum7.setOnClickListener {
            editText.setText("${editText.text}7")
        }
        buttonNum8.setOnClickListener {
            editText.setText("${editText.text}8")
        }
        buttonNum9.setOnClickListener {
            editText.setText("${editText.text}9")
        }
        buttonCancPadrao.setOnClickListener {
            if (editText.text.isNotEmpty()) {
                editText.setText(editText.text.substring(0, editText.text.length - 1))
            }
        }
    }
}

fun setListenerButtonsGenericSUpdate(layoutBotoesSAtualBinding: LayoutBotoesSAtualBinding, editText: EditText){
    with(layoutBotoesSAtualBinding) {
        buttonNum0.setOnClickListener {
            editText.setText("${editText.text}0")
        }
        buttonNum1.setOnClickListener {
            editText.setText("${editText.text}1")
        }
        buttonNum2.setOnClickListener {
            editText.setText("${editText.text}2")
        }
        buttonNum3.setOnClickListener {
            editText.setText("${editText.text}3")
        }
        buttonNum4.setOnClickListener {
            editText.setText("${editText.text}4")
        }
        buttonNum5.setOnClickListener {
            editText.setText("${editText.text}5")
        }
        buttonNum6.setOnClickListener {
            editText.setText("${editText.text}6")
        }
        buttonNum7.setOnClickListener {
            editText.setText("${editText.text}7")
        }
        buttonNum8.setOnClickListener {
            editText.setText("${editText.text}8")
        }
        buttonNum9.setOnClickListener {
            editText.setText("${editText.text}9")
        }
        buttonCancPadrao.setOnClickListener {
            if (editText.text.isNotEmpty()) {
                editText.setText(editText.text.substring(0, editText.text.length - 1))
            }
        }
    }
}

fun setListenerButtonsGenericCVirgula(layoutBotoesVirgulaBinding: LayoutBotoesVirgulaBinding, editText: EditText){
    with(layoutBotoesVirgulaBinding) {
        buttonNum0.setOnClickListener {
            editText.setText("${editText.text.toString().replace(",", "")},0")
        }
        buttonNum1.setOnClickListener {
            editText.setText("${editText.text.toString().replace(",", "")},1")
        }
        buttonNum2.setOnClickListener {
            editText.setText("${editText.text.toString().replace(",", "")},2")
        }
        buttonNum3.setOnClickListener {
            editText.setText("${editText.text.toString().replace(",", "")},3")
        }
        buttonNum4.setOnClickListener {
            editText.setText("${editText.text.toString().replace(",", "")},4")
        }
        buttonNum5.setOnClickListener {
            editText.setText("${editText.text.toString().replace(",", "")},5")
        }
        buttonNum6.setOnClickListener {
            editText.setText("${editText.text.toString().replace(",", "")},6")
        }
        buttonNum7.setOnClickListener {
            editText.setText("${editText.text.toString().replace(",", "")},7")
        }
        buttonNum8.setOnClickListener {
            editText.setText("${editText.text.toString().replace(",", "")},8")
        }
        buttonNum9.setOnClickListener {
            editText.setText("${editText.text.toString().replace(",", "")},9")
        }
        buttonCancPadrao.setOnClickListener {
            if (editText.text.isNotEmpty()) {
                var value = editText.text.substring(0, editText.text.length - 1)
                value = value.substring(0, editText.text.length - 1) + ',' + value.substring(editText.text.length - 1)
                editText.setText(value)
            }
        }
    }
}