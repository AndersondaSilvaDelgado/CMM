package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist

interface RecoverItemCheckList {

    suspend operator fun invoke() : String

}