package br.com.usinasantafe.cmm.features.infra.datasource.memory

import br.com.usinasantafe.cmm.features.domain.entities.BoletimMMFert

interface BoletimMMFertDatasourceMemory {

    suspend fun getBoletimMMFert(): BoletimMMFert

    suspend fun setIdAtiv(idAtiv: Long): Boolean

    suspend fun setIdEquip(idEquip: Long): Boolean

    suspend fun setIdTurno(idTurno: Long): Boolean

    suspend fun setMatricOperador(nroMatric: Long): Boolean

    suspend fun setNroOS(nroOS: Long): Boolean

    suspend fun startBoletimMMFert(): Boolean

}