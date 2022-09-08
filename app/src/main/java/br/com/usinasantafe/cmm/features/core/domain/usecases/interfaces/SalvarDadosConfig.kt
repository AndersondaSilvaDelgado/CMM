package br.com.usinasantafe.cmm.features.core.domain.usecases.interfaces

import android.net.Uri

interface SalvarDadosConfig {

    suspend operator fun invoke(nroEquip: Long, senha: String)

}