package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert

interface SetIdParadaApontMMFert {

    suspend operator fun invoke(idParada: Long): Boolean

}