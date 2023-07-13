package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist

interface CheckAtualCheckList {

    suspend operator fun invoke(): Boolean

}