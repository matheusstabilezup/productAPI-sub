package br.com.zup.database.repository

import br.com.zup.database.entity.ProductEntity
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.UUID
import javax.inject.Singleton

@Singleton
class ProductEntityRepositoryImpl(private val cqlSession: CqlSession) : ProductEntityRepository {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    override fun save(productEntity: ProductEntity) {
        productEntity.id = UUID.randomUUID()

        cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "INSERT INTO product.product(id, name, category, price, stock) VALUES (?,?,?,?,?)",
                    productEntity.id,
                    productEntity.name,
                    productEntity.category,
                    productEntity.price,
                    productEntity.stock
                )
        )

        logger.info("Product saved on database: $productEntity")
    }

    override fun update(productEntity: ProductEntity) {
        cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "UPDATE product SET name = ?, category = ?, price = ?, stock = ? WHERE id = ? IF EXISTS",
                    productEntity.name,
                    productEntity.category,
                    productEntity.price,
                    productEntity.stock,
                    productEntity.id
                )
        )
        logger.info("Product updated on database: $productEntity")
    }

    override fun delete(productEntity: ProductEntity) {
        cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "DELETE FROM product WHERE id = ? IF EXISTS",
                    productEntity.id
                )
        )
        logger.info("Product with id: ${productEntity.id} deleted from database")
    }

}