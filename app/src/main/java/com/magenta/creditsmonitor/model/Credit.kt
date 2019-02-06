package com.magenta.creditsmonitor.model

import androidx.annotation.DrawableRes

data class Credit(val id: Int, val name: String, val date: String, val amount: String, val status: DataProvider.Status,
                  @DrawableRes val imageId: Int) : BaseModel()