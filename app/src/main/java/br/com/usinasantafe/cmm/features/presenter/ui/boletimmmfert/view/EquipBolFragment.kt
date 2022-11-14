package br.com.usinasantafe.cmm.features.presenter.ui.boletimmmfert.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.usinasantafe.cmm.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EquipBolFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_equip_bol, container, false)
    }

}