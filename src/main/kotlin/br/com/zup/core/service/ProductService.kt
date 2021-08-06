package br.com.zup.core.service

import br.com.zup.core.mapper.ProductConverter
import br.com.zup.core.model.Event
import br.com.zup.core.model.EventType
import br.com.zup.core.port.ProductEntityServicePort
import br.com.zup.core.port.ProductServicePort
import javax.inject.Singleton

@Singleton
class ProductService(private val service: ProductEntityServicePort) : ProductServicePort {
    override fun execute(event: Event) {
        val eventType = event.eventType
        val productEntity = ProductConverter.toEntity(event.eventProduct)

        when (eventType) {
            EventType.SAVE_PRODUCT -> service.save(productEntity)
            EventType.UPDATE_PRODUCT -> service.update(productEntity)
            EventType.DELETE_PRODUCT -> service.delete(productEntity)
        }
    }
}