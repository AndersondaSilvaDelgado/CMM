package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist

interface CheckLastItemCheckList {

    suspend operator fun invoke(): Boolean

}