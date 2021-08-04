package br.com.zup.database.port

import br.com.zup.database.entity.ProductEntity
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import java.util.UUID
import javax.inject.Singleton

@Singleton
class ProductEntityRepositoryImpl(private val cqlSession: CqlSession) : ProductEntityRepository {

    override fun save(productEntity: ProductEntity) {
        productEntity.id = UUID.randomUUID()
        cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "INSERT INTO product VALUES (?,?,?,?,?)",
                    productEntity.id,
                    productEntity.name,
                    productEntity.category,
                    productEntity.price,
                    productEntity.stock
                )
        )
    }
}