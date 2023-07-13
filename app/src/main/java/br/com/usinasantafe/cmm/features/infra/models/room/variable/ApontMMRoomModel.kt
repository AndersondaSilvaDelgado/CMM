package br.com.usinasantafe.cmm.features.infra.models.room.variable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.*
import br.com.usinasantafe.cmm.features.domain.entities.variable.ApontMM
import java.util.*

@Entity(tableName = TB_APONT_MM)
data class ApontMMRoomModel(
    @PrimaryKey(autoGenerate = true)
    var idApontMM: Long? = null,
    var idBolApontMM: Long,
    var nroOSApontMM: Long,
    var idAtivApontMM: Long,
    var idParadaApontMM: Long?,
    var nroTransbApontMM: Long?,
    var dthrApontMM: Long,
    var statusApontMM: StatusData,
    var statusConApontMM: StatusConnection,
    var statusEnvioApontMM: StatusSend,
    var longitudeApontMM: Double,
    var latitudeApontMM: Double,
    var idFrenteApontMM: Long?,
    var idProprApontMM: Long?,
)

fun ApontMM.toApontMMRoomModel(): ApontMMRoomModel{
    return with(this){
        ApontMMRoomModel(
            idApontMM = this.idApont,
            idBolApontMM = this.idBolApont ?: 0,
            nroOSApontMM =  this.nroOSApont ?: 0,
            idAtivApontMM =  this.idAtivApont ?: 0,
            idParadaApontMM = this.idParadaApont,
            nroTransbApontMM = this.nroTransbApont,
            dthrApontMM = Date().time,
            statusApontMM = StatusData.FECHADO,
            statusConApontMM = StatusConnection.ONLINE,
            statusEnvioApontMM = StatusSend.ENVIAR,
            longitudeApontMM = 0.0,
            latitudeApontMM = 0.0,
            idFrenteApontMM = this.idFrenteApont,
            idProprApontMM = this.idProprApont
        )
    }
}

fun ApontMMRoomModel.toApontMM(): ApontMM{
    return with(this){
        ApontMM(
            idApont = this.idApontMM,
            idBolApont = this.idBolApontMM,
            tipoApont = TypeNote.values()[if(idParadaApontMM == null) 1 else 2],
            nroOSApont =  this.nroOSApontMM,
            idAtivApont =  this.idAtivApontMM,
            idParadaApont = this.idParadaApontMM,
            nroTransbApont = this.nroTransbApontMM,
            dthrApont = Date(this.dthrApontMM),
            statusApont = this.statusApontMM,
            statusConApont = this.statusConApontMM,
            statusEnvioApont = this.statusEnvioApontMM,
            longitudeApont = this.longitudeApontMM,
            latitudeApont = this.latitudeApontMM,
            idFrenteApont = this.idFrenteApontMM,
            idProprApont = this.idProprApontMM
        )
    }
}