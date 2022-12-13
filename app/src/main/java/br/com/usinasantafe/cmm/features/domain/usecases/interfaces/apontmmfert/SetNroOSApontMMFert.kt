package br.com.usinasantafe.cmm.features.domain.usecases.interfaces.apontmmfert

interface SetNroOSApontMMFert {

    suspend operator fun invoke(nroOS: String): Boolean

}