package br.com.zup.database.entity

import java.math.BigDecimal
import java.util.UUID

data class ProductEntity(
    var id: UUID?,
    val name: String,
    val category: String,
    val price: BigDecimal,
    val stock: Int
)
