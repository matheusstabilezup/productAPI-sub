package br.com.zup.database.service

import br.com.zup.core.port.ProductEntityServicePort
import br.com.zup.database.entity.ProductEntity
import br.com.zup.database.repository.ProductEntityRepository
import javax.inject.Singleton

@Singleton
class ProductEntityService(private val repository: ProductEntityRepository) : ProductEntityServicePort {

    override fun save(productEntity: ProductEntity) {

        repository.save(productEntity)
    }

    override fun update(productEntity: ProductEntity) {
        repository.update(productEntity)
    }

    override fun delete(productEntity: ProductEntity) {
        repository.delete(productEntity)
    }
}