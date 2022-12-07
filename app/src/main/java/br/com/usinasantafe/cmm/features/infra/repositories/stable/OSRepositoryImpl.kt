package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.OS
import br.com.usinasantafe.cmm.features.infra.models.toOS
import br.com.usinasantafe.cmm.features.infra.models.toOSModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.OSRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.OSDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.OSDatasourceWebService
import br.com.usinasantafe.cmm.features.infra.models.toMotoMecModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OSRepositoryImpl @Inject constructor(
    private val osDatasourceRoom: OSDatasourceRoom,
    private val osDatasourceWebService: OSDatasourceWebService
): OSRepository {

    override suspend fun addAllOS(osList: List<OS>) {
        osDatasourceRoom.addAllOS(*osList.map { it.toOSModel() }.toTypedArray())
    }

    override suspend fun deleteAllOS() {
        osDatasourceRoom.deleteAllOS()
    }

    override suspend fun recoverAllOS(): Flow<Result<List<OS>>> {
        return flow {
            osDatasourceWebService.getAllOS()
                .collect { result ->
                    result.onSuccess {osModelList ->
                        emit(Result.success(osModelList.map { it.toOS() }))
                    }
                }
        }
    }

    override suspend fun checkOS(nroOS: String): Boolean {
        return osDatasourceRoom.checkOS(nroOS.toLong())
    }

    override suspend fun getOSNro(nroOS: Long): OS {
        return osDatasourceRoom.getOSNro(nroOS).toOS()
    }

    override suspend fun recoverOS(nroOS: String): Flow<Result<List<OS>>> {
        return flow {
            osDatasourceWebService.recoverOS(nroOS)
                .collect { result ->
                    result.onSuccess {osModelList ->
                        emit(Result.success(osModelList.map { it.toOS() }))
                    }
                }
        }
    }

}