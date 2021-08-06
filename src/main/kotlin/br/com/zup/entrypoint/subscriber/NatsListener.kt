package br.com.zup.entrypoint.subscriber

import br.com.zup.core.model.Event
import br.com.zup.core.port.ProductServicePort
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject
import org.slf4j.Logger
import org.slf4j.LoggerFactory

@NatsListener
class NatsListener(private val service: ProductServicePort) {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @Subject("products")
    fun received(event: Event) {
        logger.info("Msg recebida: ${event.toString()}")
        service.execute(event)
    }
}