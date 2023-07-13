package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist

interface CheckAberturaCheckList {

    suspend operator fun invoke(): Boolean

}