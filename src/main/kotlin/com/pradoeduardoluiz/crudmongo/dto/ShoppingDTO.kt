package com.pradoeduardoluiz.crudmongo.dto

import com.pradoeduardoluiz.crudmongo.common.Errors
import javax.validation.constraints.NotEmpty

data class ShoppingDTO(
        val id: String?,
        @get:NotEmpty(message = Errors.SHOPPING_NAME_INVALID)
        val name: String,
        val amount: Int,
        val brand: String,
        val shelfLife: String
)