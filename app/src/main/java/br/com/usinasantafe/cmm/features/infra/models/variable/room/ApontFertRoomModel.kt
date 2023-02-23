package br.com.usinasantafe.cmm.features.infra.models.variable.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.StatusConnection
import br.com.usinasantafe.cmm.common.utils.StatusData
import br.com.usinasantafe.cmm.common.utils.StatusSend
import br.com.usinasantafe.cmm.common.utils.TB_APONT_FERT
import br.com.usinasantafe.cmm.features.domain.entities.variable.ApontFert
import java.util.*

@Entity(tableName = TB_APONT_FERT)
data class ApontFertRoomModel(
    @PrimaryKey(autoGenerate = true)
    var idApontFert: Long? = null,
    var idBolApontFert: Long,
    var nroOSApontFert: Long,
    var idAtivApontFert: Long,
    var idParadaApontFert: Long,
    var pressaoApontFert: Double,
    var velocApontFert: Long,
    var bocalApontFert: Long,
    var dthrApontFert: Long,
    var statusApontFert: Long,
    var statusConApontFert: Long,
    var statusEnvioApontFert: Long,
    var longitudeApontFert: Double,
    var latitudeApontFert: Double,
)

fun ApontFert.toApontFertRoomModel(): ApontFertRoomModel{
    return with(this){
        ApontFertRoomModel(
            idBolApontFert = this.idBolApont!!,
            nroOSApontFert =  this.nroOSApont!!,
            idAtivApontFert =  this.idAtivApont!!,
            idParadaApontFert = this.idParadaApont!!,
            dthrApontFert = Date().time,
            statusApontFert = StatusData.FECHADO.ordinal.toLong(),
            statusConApontFert = StatusConnection.ONLINE.ordinal.toLong(),
            statusEnvioApontFert = StatusSend.ENVIAR.ordinal.toLong(),
            longitudeApontFert = this.longitudeApont!!,
            latitudeApontFert = this.latitudeApont!!,
            pressaoApontFert = this.pressaoApont!!,
            velocApontFert = this.velocApont!!,
            bocalApontFert = this.bocalApont!!
        )
    }
}

