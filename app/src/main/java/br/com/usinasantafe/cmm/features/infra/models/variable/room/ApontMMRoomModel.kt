package br.com.usinasantafe.cmm.features.infra.models.variable.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.StatusConnection
import br.com.usinasantafe.cmm.common.utils.TB_APONT_MM
import br.com.usinasantafe.cmm.features.domain.entities.variable.ApontMM

@Entity(tableName = TB_APONT_MM)
data class ApontMMModel(
    @PrimaryKey(autoGenerate = true)
    var idApontMM: Long? = null,
    var idBolApontMM: Long,
    var osApontMM: Long,
    var ativApontMM: Long,
    var paradaApontMM: Long,
    var transbApontMM: Long,
    var dthrApontLongMM: Long,
    var statusConApontMM: StatusConnection,
    var longitudeApontMM: Double,
    var latitudeApontMM: Double,
    var idFrenteApontMM: Long,
    var idProprApontMM: Long,
)

fun ApontMM.toApontMMModel(): ApontMMModel{
    return with(this){
        ApontMMModel(
            idBolApontMM = this.idBolApont,
            osApontMM =  this.osApont!!,
            ativApontMM =  this.ativApont!!,
            paradaApontMM = this.paradaApont!!,
            transbApontMM = this.transbApont!!,
            dthrApontLongMM = this.dthrApontLong!!,
            statusConApontMM = this.statusConApont!!,
            longitudeApontMM = this.longitudeApont!!,
            latitudeApontMM = this.latitudeApont!!,
            idFrenteApontMM = this.idFrenteApont!!,
            idProprApontMM = this.idProprApont!!
        )
    }
}