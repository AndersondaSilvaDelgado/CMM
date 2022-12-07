package br.com.usinasantafe.cmm.features.domain.repositories.variable

import br.com.usinasantafe.cmm.features.domain.entities.BoletimMMFert

interface BoletimMMFertRepository {

    suspend fun getBoletimMMFert(): BoletimMMFert

    suspend fun setIdAtivBoletimMMFert(idAtiv: Long): Boolean

    suspend fun setMatricFuncBoletimMMFert(matricOperador: String): Boolean

    suspend fun setIdEquipBoletimMMFert(idEquip: Long): Boolean

    suspend fun setIdTurnoBoletimMMFert(idTurno: Long): Boolean

    suspend fun setNroOSBoletimMMFert(nroOS: String): Boolean

    suspend fun startBoletimMMFert(): Boolean

}