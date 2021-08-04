package br.com.zup.core.model

data class EventInformation(
    val event: EventType = EventType.SAVE_PRODUCT,
    val product: EventProduct = EventProduct()
)