package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.checklist

interface GetDescrItemCheckList {

    suspend operator fun invoke(position: Int): String

}