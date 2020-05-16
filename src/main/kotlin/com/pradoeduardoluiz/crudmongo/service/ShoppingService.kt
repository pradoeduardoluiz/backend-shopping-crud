package com.pradoeduardoluiz.crudmongo.service

import com.pradoeduardoluiz.crudmongo.model.Shopping

interface ShoppingService {

    fun persist(shopping: Shopping): Shopping

    fun findById(id: String): Shopping?

    fun getAll(): List<Shopping>

    fun deleteById(id: String)

}