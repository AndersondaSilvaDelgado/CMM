package br.com.usinasantafe.cmm.features.presenter.models

data class ResultUpdateDatabase(
    val count: Int,
    val describe: String,
    val size: Int,
    var percentage: Int = ((count * 100) / size)
)
