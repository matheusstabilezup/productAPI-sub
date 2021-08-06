package br.com.zup.core.mapper

import br.com.zup.core.model.EventProduct
import br.com.zup.database.entity.ProductEntity

class ProductConverter {
    companion object {
        fun toEntity(eventProduct: EventProduct) =
            ProductEntity(
                eventProduct.id,
                eventProduct.name,
                eventProduct.category,
                eventProduct.price,
                eventProduct.stock
            )
    }
}
