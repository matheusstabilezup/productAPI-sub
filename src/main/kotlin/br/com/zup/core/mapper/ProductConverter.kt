package br.com.zup.core.mapper

import br.com.zup.database.entity.ProductEntity
import br.com.zup.core.model.EventProduct

class ProductConverter {
    companion object {
        fun toProductEvent(eventProduct: EventProduct) =
            EventProduct(eventProduct.id, eventProduct.name, eventProduct.category, eventProduct.price, eventProduct.stock)

        fun toEntity(eventProduct: EventProduct) =
            ProductEntity(eventProduct.id, eventProduct.name, eventProduct.category, eventProduct.price, eventProduct.stock)

        fun toProduct(productEntity: ProductEntity) = EventProduct(
            productEntity.id,
            productEntity.name,
            productEntity.category,
            productEntity.price,
            productEntity.stock
        )

        fun toProduct(eventProduct: EventProduct) =
            EventProduct(eventProduct.id, eventProduct.name, eventProduct.category, eventProduct.price, eventProduct.stock)

    }

}
