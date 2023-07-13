package br.com.usinasantafe.cmm.features.infra.models.room.stable

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.common.utils.TB_PRODUTO
import br.com.usinasantafe.cmm.features.domain.entities.stable.Produto
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = TB_PRODUTO)
data class ProdutoRoomModel(
    @PrimaryKey val idProduto: Long,
    val codProduto: String,
    val descrProduto: String
)

fun Produto.toProdutoModel(): ProdutoRoomModel{
    return with(this){
        ProdutoRoomModel(
            idProduto = this.idProduto,
            codProduto = this.codProduto,
            descrProduto = this.descrProduto
        )
    }
}

fun ProdutoRoomModel.toProduto(): Produto {
    return with(this){
        Produto(
            idProduto = this.idProduto,
            codProduto = this.codProduto,
            descrProduto = this.descrProduto
        )
    }
}