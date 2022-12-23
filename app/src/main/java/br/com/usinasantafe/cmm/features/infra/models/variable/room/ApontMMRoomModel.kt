package br.com.usinasantafe.cmm.features.infra.models.variable.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.StatusConnection
import br.com.usinasantafe.cmm.common.utils.TB_APONT_MM
import br.com.usinasantafe.cmm.common.utils.TypeNote
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
    var statusConApontMM: Long,
    var longitudeApontMM: Double,
    var latitudeApontMM: Double,
    var idFrenteApontMM: Long?,
    var idProprApontMM: Long?,
)

fun ApontMM.toApontMMRoomModel(): ApontMMRoomModel{
    return with(this){
        ApontMMRoomModel(
            idBolApontMM = this.idBolApont,
            nroOSApontMM =  this.nroOSApont!!,
            idAtivApontMM =  this.idAtivApont!!,
            idParadaApontMM = this.idParadaApont,
            nroTransbApontMM = this.nroTransbApont,
            dthrApontMM = Date().time,
            statusConApontMM = StatusConnection.ONLINE.ordinal.toLong(),
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
            statusConApont = StatusConnection.values()[this.statusConApontMM.toInt()],
            longitudeApont = this.longitudeApontMM,
            latitudeApont = this.latitudeApontMM,
            idFrenteApont = this.idFrenteApontMM,
            idProprApont = this.idProprApontMM
        )
    }
}