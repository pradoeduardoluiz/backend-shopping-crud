package com.pradoeduardoluiz.crudmongo.mappers

import com.pradoeduardoluiz.crudmongo.dto.ShoppingDTO
import com.pradoeduardoluiz.crudmongo.model.Shopping

fun ShoppingDTO.toModel() = Shopping(
        id = id,
        name = name,
        amount = amount,
        brand = brand,
        shelfLife = shelfLife
)

fun Shopping.toDto() = ShoppingDTO(
        id = id,
        name = name,
        amount = amount,
        brand = brand,
        shelfLife = shelfLife
)