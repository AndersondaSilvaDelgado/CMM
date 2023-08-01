package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist

interface CloseCheckList {

    suspend operator fun invoke(): Boolean

}