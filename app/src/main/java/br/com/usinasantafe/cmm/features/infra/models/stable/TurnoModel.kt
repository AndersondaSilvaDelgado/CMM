package br.com.usinasantafe.cmm.features.infra.models.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_TURNO
import br.com.usinasantafe.cmm.features.domain.entities.stable.Turno
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_TURNO)
data class TurnoModel(
    @PrimaryKey val idTurno: Long,
    val codTurno: Long,
    val nroTurno: Long,
    val descrTurno: String
)

fun TurnoModel.toTurno(): Turno {
    return with(this){
        Turno(
            idTurno = this.idTurno,
            codTurno = this.codTurno,
            nroTurno = this.nroTurno,
            descrTurno = this.descrTurno
        )
    }
}

fun Turno.toTurnoModel(): TurnoModel{
    return with(this){
        TurnoModel(
            idTurno = this.idTurno,
            codTurno = this.codTurno,
            nroTurno = this.nroTurno,
            descrTurno = this.descrTurno
        )
    }
}
