package br.com.zup.entrypoint.subscriber

import br.com.zup.core.model.EventInformation
import br.com.zup.core.port.ProductServicePort
import io.micronaut.nats.annotation.NatsClient
import io.micronaut.nats.annotation.Subject
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@NatsClient
class NatsListener(private val service: ProductServicePort) {
    val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @Subject("products")
    fun listen(event: EventInformation) {
        logger.info("OI")
        service.execute(event)
        logger.info("FOI")
    }
}