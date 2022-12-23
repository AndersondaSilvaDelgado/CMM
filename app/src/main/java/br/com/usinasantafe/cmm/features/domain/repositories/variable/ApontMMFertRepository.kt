package br.com.usinasantafe.cmm.features.domain.repositories.variable

import br.com.usinasantafe.cmm.common.utils.TypeNote

interface ApontMMFertRepository {

    suspend fun getOS(): Long

    suspend fun getTipo(): TypeNote

    suspend fun setIdAtivApontMMFert(idAtiv: Long): Boolean

    suspend fun setIdParadaApontMMFert(idParada: Long): Boolean

    suspend fun setNroOSApontMMFert(nroOS: String): Boolean

    suspend fun startApontMMFert(typeNote: TypeNote): Boolean

}