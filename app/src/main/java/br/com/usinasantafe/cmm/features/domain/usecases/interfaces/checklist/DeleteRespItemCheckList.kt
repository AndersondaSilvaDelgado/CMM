package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist

interface DeleteRespItemCheckList {

    suspend operator fun invoke(position: Int): Boolean

}