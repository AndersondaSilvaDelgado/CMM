package br.com.usinasantafe.cmm.features.infra.models.variable.webservice

import br.com.usinasantafe.cmm.common.utils.StatusConnection
import br.com.usinasantafe.cmm.features.domain.entities.variable.ApontMM
import br.com.usinasantafe.cmm.features.infra.models.variable.room.ApontMMRoomModel
import kotlinx.serialization.Serializable
import java.text.SimpleDateFormat
import java.util.*

@Serializable
data class ApontMMWebServiceModel (
    var idApontMM: Long,
    var idBolApontMM: Long,
    var nroOSApontMM: Long,
    var idAtivApontMM: Long,
    var idParadaApontMM: Long?,
    var nroTransbApontMM: Long?,
    var dthrApontMM: String,
    var statusConApontMM: Long,
    var longitudeApontMM: Double,
    var latitudeApontMM: Double,
    var idFrenteApontMM: Long?,
    var idProprApontMM: Long?,
)

fun ApontMM.toApontMMWebServiceModel(): ApontMMWebServiceModel {
    return with(this){
        ApontMMWebServiceModel(
            idApontMM = this.idApont!!,
            idBolApontMM = this.idBolApont,
            nroOSApontMM =  this.nroOSApont!!,
            idAtivApontMM =  this.idAtivApont!!,
            idParadaApontMM = this.idParadaApont,
            nroTransbApontMM = this.nroTransbApont,
            dthrApontMM = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale("pt", "BR")).format(this.dthrApont),
            statusConApontMM = statusConApont!!.ordinal.toLong(),
            longitudeApontMM = this.longitudeApont!!,
            latitudeApontMM = this.longitudeApont!!,
            idFrenteApontMM = this.idFrenteApont,
            idProprApontMM = this.idProprApont
        )
    }
}
