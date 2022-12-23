package br.com.usinasantafe.cmm.features.external.room.dao.variable

import androidx.room.Dao
import androidx.room.Insert
import br.com.usinasantafe.cmm.features.infra.models.variable.room.ApontFertRoomModel

@Dao
interface ApontFertDao {

    @Insert
    suspend fun insert(apontFertRoomModel: ApontFertRoomModel): Long

}