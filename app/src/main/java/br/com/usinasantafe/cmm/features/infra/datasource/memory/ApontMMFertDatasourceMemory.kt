package br.com.usinasantafe.cmm.features.infra.datasource.memory

import br.com.usinasantafe.cmm.common.utils.TypeNote

interface ApontMMFertDatasourceMemory {

    suspend fun setIdAtiv(idAtiv: Long): Boolean

    suspend fun setIdParada(idParada: Long): Boolean

    suspend fun setNroOS(nroOS: Long): Boolean

    suspend fun startApont(typeNote: TypeNote, idBoletim: Long): Boolean

}