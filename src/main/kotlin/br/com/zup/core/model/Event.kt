package br.com.zup.core.model

data class Event(
    val eventType: EventType = EventType.SAVE_PRODUCT,
    val eventProduct: EventProduct = EventProduct()
)