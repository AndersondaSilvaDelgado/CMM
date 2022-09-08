package br.com.usinasantafe.cmm.features.core.infra.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.usinasantafe.cmm.features.core.domain.entities.Produto
import kotlinx.serialization.Serializable

@Serializable
@Entity(tableName = "tbprodutoest")
data class ProdutoModel(
    @PrimaryKey val idProduto: Long,
    val codProduto: String,
    val descrProduto: String
)

fun Produto.toProdutoModel(): ProdutoModel{
    return with(this){
        ProdutoModel(
            idProduto = this.idProduto,
            codProduto = this.codProduto,
            descrProduto = this.descrProduto
        )
    }
}

fun ProdutoModel.toProduto(): Produto {
    return with(this){
        Produto(
            idProduto = this.idProduto,
            codProduto = this.codProduto,
            descrProduto = this.descrProduto
        )
    }
}