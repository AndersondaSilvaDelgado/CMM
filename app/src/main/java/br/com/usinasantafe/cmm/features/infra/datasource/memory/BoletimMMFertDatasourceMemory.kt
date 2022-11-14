package br.com.usinasantafe.cmm.features.infra.datasource.memory

interface BoletimMMFertDatasourceMemory {

    suspend fun startBoletimMMFert()

    suspend fun setOperador(nroMatric: Long)

}