package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist

import br.com.usinasantafe.cmm.features.domain.entities.variable.CabecCheckList

interface SendDataCheckList {

    suspend operator fun invoke(): Result<List<CabecCheckList>>

}