package br.com.usinasantafe.cmm.features.infra.repositories.stable

import br.com.usinasantafe.cmm.features.domain.entities.OS
import br.com.usinasantafe.cmm.features.infra.models.toOS
import br.com.usinasantafe.cmm.features.infra.models.toOSModel
import br.com.usinasantafe.cmm.features.domain.repositories.stable.OSRepository
import br.com.usinasantafe.cmm.features.infra.datasource.room.OSDatasourceRoom
import br.com.usinasantafe.cmm.features.infra.datasource.webservice.OSDatasourceWebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class OSRepositoryImpl @Inject constructor(
    private val osDatasourceRoom: OSDatasourceRoom,
    private val osDatasourceWebService: OSDatasourceWebService
): OSRepository {

    override suspend fun addAllOS(osList: List<OS>) {
        for(os in osList){
            val osModel = os.toOSModel()
            osDatasourceRoom.addOS(osModel)
        }
    }

    override suspend fun deleteAllOS() {
        osDatasourceRoom.deleteAllOS()
    }

    override suspend fun getAllOS(): Flow<Result<List<OS>>> {
        return flow {
            osDatasourceWebService.getAllOS()
                .collect { result ->
                    result.onSuccess {osModelList ->
                        val osList = mutableListOf<OS>()
                        for (osModel in osModelList){
                            osList.add(osModel.toOS())
                        }
                        emit(Result.success(osList))
                    }
                }
        }
    }

}