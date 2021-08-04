package br.com.zup.database.service

import br.com.zup.core.port.ProductEntityServicePort
import br.com.zup.database.entity.ProductEntity
import br.com.zup.database.port.ProductEntityRepository
import javax.inject.Singleton

@Singleton
class ProductEntityService(private val repository: ProductEntityRepository) : ProductEntityServicePort {

    override fun save(productEntity: ProductEntity) = repository.save(productEntity)
}