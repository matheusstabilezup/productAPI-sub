package br.com.zup.core.service

import br.com.zup.core.mapper.ProductConverter
import br.com.zup.core.model.EventInformation
import br.com.zup.core.model.EventType
import br.com.zup.core.port.ProductEntityServicePort
import br.com.zup.core.port.ProductServicePort
import javax.inject.Singleton

@Singleton
class ProductService(private val service: ProductEntityServicePort) : ProductServicePort {

    override fun execute(event: EventInformation) {
        val eventType = event.event
        val eventProduct = event.product

        when(eventType) {
            EventType.SAVE_PRODUCT -> service.save(ProductConverter.toEntity(eventProduct))
        }
    }


}