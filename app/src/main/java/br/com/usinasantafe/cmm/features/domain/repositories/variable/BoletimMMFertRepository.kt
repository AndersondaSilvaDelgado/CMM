package br.com.usinasantafe.cmm.features.domain.repositories.variable

import br.com.usinasantafe.cmm.features.domain.entities.variable.BoletimMM

interface BoletimMMFertRepository {

    suspend fun checkAbertoBoletimMMFert(): Boolean

    suspend fun checkBoletimSend(): Boolean

    suspend fun finishBoletimMMFert(): Boolean

    suspend fun getAtiv(): Long

    suspend fun getIdBoletim(): Long

    suspend fun getOS(): Long

    suspend fun insertBoletimMMFert(): Boolean

    suspend fun sendBoletimMMFert(): Result<List<BoletimMM>>

    suspend fun sentBoletimMMFert(boletimMMList: List<BoletimMM>)

    suspend fun setHorimetroFinalBoletimMMFert(horimetroFinal: String): Boolean

    suspend fun setHorimetroInicialBoletimMMFert(horimetroInicial: String): Boolean

    suspend fun setIdAtivBoletimMMFert(idAtiv: Long): Boolean

    suspend fun setMatricFuncBoletimMMFert(matricOperador: String): Boolean

    suspend fun setIdTurnoBoletimMMFert(idTurno: Long): Boolean

    suspend fun setNroOSBoletimMMFert(nroOS: String): Boolean

    suspend fun setStatusEnviarBoletimMM(idBol: Long): Boolean

    suspend fun startBoletimMMFert(): Boolean

}