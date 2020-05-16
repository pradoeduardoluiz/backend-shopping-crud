package com.pradoeduardoluiz.crudmongo.repositories

import com.pradoeduardoluiz.crudmongo.model.Shopping
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ShoppingRepository : MongoRepository<Shopping, String> {

    fun findByName(name: String): Shopping?

}