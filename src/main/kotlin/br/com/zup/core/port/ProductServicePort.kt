package br.com.zup.core.port

import br.com.zup.core.model.Event

interface ProductServicePort {
    fun execute(event: Event)
}