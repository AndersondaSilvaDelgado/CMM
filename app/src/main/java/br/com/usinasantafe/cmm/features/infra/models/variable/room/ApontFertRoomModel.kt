package br.com.usinasantafe.cmm.features.infra.models.variable.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.StatusConnection
import br.com.usinasantafe.cmm.common.utils.TB_APONT_FERT
import br.com.usinasantafe.cmm.features.domain.entities.variable.ApontFert

@Entity(tableName = TB_APONT_FERT)
data class ApontFertModel(
    @PrimaryKey(autoGenerate = true)
    var idApontFert: Long? = null,
    var idBolApontFert: Long,
    var osApontFert: Long,
    var ativApontFert: Long,
    var paradaApontFert: Long,
    var pressaoApontFert: Double,
    var velocApontFert: Long,
    var bocalApontFert: Long,
    var dthrApontLongFert: Long,
    var statusConApontFert: StatusConnection,
    var longitudeApontFert: Double,
    var latitudeApontFert: Double,
)

fun ApontFert.toApontFertModel(): ApontFertModel{
    return with(this){
        ApontFertModel(
            idBolApontFert = this.idBolApont,
            osApontFert =  this.osApont!!,
            ativApontFert =  this.ativApont!!,
            paradaApontFert = this.paradaApont!!,
            dthrApontLongFert = this.dthrApontLong!!,
            statusConApontFert = this.statusConApont!!,
            longitudeApontFert = this.longitudeApont!!,
            latitudeApontFert = this.latitudeApont!!,
            pressaoApontFert = this.pressaoApont!!,
            velocApontFert = this.velocApont!!,
            bocalApontFert = this.bocalApont!!
        )
    }
}

