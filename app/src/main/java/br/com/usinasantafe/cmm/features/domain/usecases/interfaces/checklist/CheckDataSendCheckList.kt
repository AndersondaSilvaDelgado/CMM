package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist

interface CheckDataSendCheckList {

    suspend operator fun invoke(): Boolean

}