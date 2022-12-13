package br.com.usinasantafe.cmm.features.domain.entities.stable

import androidx.room.PrimaryKey

data class Componente (
    @PrimaryKey val idComponente: Long,
    val codComponente: String,
    val descrComponente: String
)