package br.com.usinasantafe.cmm.features.presenter.boletimmmfert.datahora

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import br.com.usinasantafe.cmm.R
import br.com.usinasantafe.cmm.common.base.BaseFragment
import br.com.usinasantafe.cmm.databinding.FragmentDataHoraBinding
import dagger.hilt.android.AndroidEntryPoint
import java.util.*


@AndroidEntryPoint
class DataHoraFragment : BaseFragment<FragmentDataHoraBinding>(
    R.layout.fragment_data_hora,
    FragmentDataHoraBinding::bind
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textViewData.setOnClickListener {
            showDate()
        }
        binding.textViewHora.setOnClickListener {
            showHour()
        }

    }

    private fun showDate() {
        val c: Calendar = Calendar.getInstance()
        var mYear = c.get(Calendar.YEAR)
        var mMonth = c.get(Calendar.MONTH)
        var mDay = c.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(requireContext(),
            {
                _,
                year,
                monthOfYear,
                dayOfMonth ->
                binding.textViewData.text = dayOfMonth.toString() + "/" + String.format("%02d", (monthOfYear + 1)) + "/" + year
            },
            mYear,
            mMonth,
            mDay
        )
        datePickerDialog.show()
    }

    private fun showHour() {
        val c = Calendar.getInstance()
        var mHour = c[Calendar.HOUR_OF_DAY]
        var mMinute = c[Calendar.MINUTE]

        val timePickerDialog = TimePickerDialog(requireContext(),
            {
                _,
                hourOfDay,
                minute -> binding.textViewHora.text  = "$hourOfDay:$minute"
            },
            mHour,
            mMinute,
            true
        )
        timePickerDialog.show()
    }
}