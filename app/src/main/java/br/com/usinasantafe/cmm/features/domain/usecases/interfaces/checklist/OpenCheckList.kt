package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist

interface OpenCheckList {

    suspend operator fun invoke(): Boolean

}