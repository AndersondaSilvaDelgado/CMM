package br.com.usinasantafe.cmm.features.domain.repositories.variable

interface BoletimMMFertRepository {

    suspend fun clearBoletimMMFert()

    suspend fun getAtiv(): Long

    suspend fun getIdBoletim(): Long

    suspend fun getOS(): Long

    suspend fun insertBoletimMMFert(): Boolean

    suspend fun sentBoletimMMAbertoFert(): Boolean

    suspend fun setHorimetroInicialBoletimMMFert(horimetroInicial: String): Boolean

    suspend fun setIdAtivBoletimMMFert(idAtiv: Long): Boolean

    suspend fun setMatricFuncBoletimMMFert(matricOperador: String): Boolean

    suspend fun setIdTurnoBoletimMMFert(idTurno: Long): Boolean

    suspend fun setNroOSBoletimMMFert(nroOS: String): Boolean

    suspend fun startBoletimMMFert(): Boolean

}