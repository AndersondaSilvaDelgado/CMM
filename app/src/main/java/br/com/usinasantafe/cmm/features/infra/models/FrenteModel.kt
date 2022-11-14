package br.com.usinasantafe.cmm.features.infra.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.features.domain.entities.Frente
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "tbfrenteest")
data class FrenteModel(
    @PrimaryKey val idFrente: Long,
    val codFrente: Long,
    val descrFrente: String
)

fun Frente.toFrenteModel(): FrenteModel{
    return with(this){
        FrenteModel(
            idFrente = this.idFrente,
            codFrente = this.codFrente,
            descrFrente = this.descrFrente
        )
    }
}

fun FrenteModel.toFrente(): Frente {
    return with(this){
        Frente(
            idFrente = this.idFrente,
            codFrente = this.codFrente,
            descrFrente = this.descrFrente
        )
    }
}
