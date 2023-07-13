package br.com.usinasantafe.cmm.features.infra.models.room.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_FRENTE
import br.com.usinasantafe.cmm.features.domain.entities.stable.Frente
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_FRENTE)
data class FrenteRoomModel(
    @PrimaryKey val idFrente: Long,
    val codFrente: Long,
    val descrFrente: String
)

fun Frente.toFrenteModel(): FrenteRoomModel{
    return with(this){
        FrenteRoomModel(
            idFrente = this.idFrente,
            codFrente = this.codFrente,
            descrFrente = this.descrFrente
        )
    }
}

fun FrenteRoomModel.toFrente(): Frente {
    return with(this){
        Frente(
            idFrente = this.idFrente,
            codFrente = this.codFrente,
            descrFrente = this.descrFrente
        )
    }
}
