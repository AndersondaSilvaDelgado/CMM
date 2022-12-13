package br.com.usinasantafe.cmm.features.infra.datasource.memory

interface BoletimMMFertDatasourceMemory {

    suspend fun clearBoletim()

    suspend fun setHorimetroInicial(horimetroInicial: Double): Boolean

    suspend fun setIdAtiv(idAtiv: Long): Boolean

    suspend fun setIdTurno(idTurno: Long): Boolean

    suspend fun setMatricOperador(nroMatric: Long): Boolean

    suspend fun setNroOS(nroOS: Long): Boolean

    suspend fun startBoletim(idEquip: Long): Boolean

}