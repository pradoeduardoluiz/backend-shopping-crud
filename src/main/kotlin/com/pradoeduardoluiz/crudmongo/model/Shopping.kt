package com.pradoeduardoluiz.crudmongo.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Shopping(
        @Id
        val id: String? = null,
        val name: String,
        val amount: Int,
        val brand: String,
        val shelfLife: String
)