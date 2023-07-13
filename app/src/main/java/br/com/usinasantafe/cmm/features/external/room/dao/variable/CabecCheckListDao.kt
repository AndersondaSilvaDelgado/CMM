package br.com.usinasantafe.cmm.features.external.room.dao.variable

import androidx.room.Dao
import androidx.room.Insert
import br.com.usinasantafe.cmm.features.infra.models.room.variable.CabecCheckListRoomModel

@Dao
interface CabecCheckListDao {

    @Insert
    suspend fun insert(cabecCheckListRoomModel: CabecCheckListRoomModel): Long

}