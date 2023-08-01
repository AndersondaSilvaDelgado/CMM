package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist

interface CheckOpenCheckList {

    suspend operator fun invoke(): Boolean

}