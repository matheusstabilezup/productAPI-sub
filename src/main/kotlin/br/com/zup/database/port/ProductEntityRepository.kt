package br.com.zup.database.port

import br.com.zup.database.entity.ProductEntity

interface ProductEntityRepository {
    fun save(productEntity: ProductEntity)
    fun update(productEntity: ProductEntity)
    fun delete(productEntity: ProductEntity)
}