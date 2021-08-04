package br.com.zup.core.port

import br.com.zup.core.model.EventInformation

interface ProductServicePort {

    fun execute(event: EventInformation)
}