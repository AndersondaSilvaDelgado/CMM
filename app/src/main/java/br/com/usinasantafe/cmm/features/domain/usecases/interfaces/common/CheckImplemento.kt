package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common

interface CheckImplemento {

    suspend operator fun invoke(nroEquip: String): Boolean

}