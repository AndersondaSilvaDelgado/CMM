package br.com.usinasantafe.cmm.features.infra.models.webservice

import br.com.usinasantafe.cmm.features.domain.entities.variable.ApontMM
import kotlinx.serialization.Serializable
import java.text.SimpleDateFormat
import java.util.*

@Serializable
data class ApontMMWebServiceModelOutput (
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

@Serializable
data class ApontMMWebServiceModelInput (
    var idApontMM: Long,
)

fun ApontMM.toApontMMWebServiceModel(): ApontMMWebServiceModelOutput {
    return with(this){
        ApontMMWebServiceModelOutput(
            idApontMM = this.idApont!!,
            idBolApontMM = this.idBolApont!!,
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

fun ApontMMWebServiceModelInput.toApontMM(): ApontMM {
    return with(this){
        ApontMM(
            idApont = idApontMM
        )
    }
}
