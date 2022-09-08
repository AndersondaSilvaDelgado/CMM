package br.com.usinasantafe.cmm.features.core.infra.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.features.core.domain.entities.Config
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "tbconfigest")
data class ConfigModel(
    @PrimaryKey(autoGenerate = true)
    val idConfig: Long,
    val equipConfig: Long,
    val senhaConfig: String
)

fun Config.toConfigModel(): ConfigModel {
    return with(this){
        ConfigModel(
            idConfig = 0L,
            equipConfig = this.equipConfig,
            senhaConfig = this.senhaConfig
        )
    }
}

fun ConfigModel.toConfig(): Config {
    return with(this){
        Config(
            equipConfig = this.equipConfig,
            senhaConfig = this.senhaConfig
        )
    }
}
