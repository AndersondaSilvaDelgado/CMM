package br.com.usinasantafe.cmm.features.core.domain.entities

import androidx.room.PrimaryKey

data class Componente (
    @PrimaryKey val idComponente: Long,
    val codComponente: Long,
    val descrComponente: String
)