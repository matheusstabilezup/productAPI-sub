package br.com.zup.core.port

import br.com.zup.database.entity.ProductEntity

interface ProductEntityServicePort {

    fun save(productEntity: ProductEntity)
}