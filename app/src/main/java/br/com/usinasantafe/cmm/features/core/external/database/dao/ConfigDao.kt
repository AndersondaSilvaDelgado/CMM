package br.com.usinasantafe.cmm.features.core.external.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import br.com.usinasantafe.cmm.features.core.infra.models.ConfigModel

@Dao
interface ConfigDao {

    @Insert
    suspend fun insert(configModel: ConfigModel): Long

    @Query("SELECT count(idConfig) FROM tbconfigest")
    suspend fun size(): Long

    @Query("DELETE FROM tbconfigest")
    suspend fun deleteAll()

    @Query("SELECT * FROM tbconfigest LIMIT 1")
    suspend fun get(): ConfigModel

    @Query("SELECT * FROM tbconfigest WHERE senhaConfig like :senha  LIMIT 1")
    suspend fun get(senha: String): ConfigModel

}