package br.com.usinasantafe.cmm.features.infra.datasource.memory

interface ApontMMFertDatasourceMemory {

    suspend fun startApont(tipo: Long, idBoletim: Long): Boolean

}