package br.com.zup.core.port

import br.com.zup.database.entity.ProductEntity

interface ProductEntityServicePort {
    fun save(productEntity: ProductEntity)
    fun update(productEntity: ProductEntity)
    fun delete(productEntity: ProductEntity)
}