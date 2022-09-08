package br.com.usinasantafe.cmm.features.core.infra.datasource.web

interface EquipDatasourceWeb {

    suspend fun getDadosEquip(nroEquip: Long): List<Any>

}