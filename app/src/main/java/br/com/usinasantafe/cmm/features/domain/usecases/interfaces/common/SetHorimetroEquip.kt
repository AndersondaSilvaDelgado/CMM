package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.common

interface SetHorimetroEquip {

    suspend operator fun invoke(horimetro: String): Boolean

}