package com.example.myfirsttestgitapp.presentation

import androidx.lifecycle.ViewModel
import com.example.myfirsttestgitapp.data.ShopListRepositoryImpl
import com.example.myfirsttestgitapp.domain.DeleteShopItemUseCase
import com.example.myfirsttestgitapp.domain.EditShopItemUseCase
import com.example.myfirsttestgitapp.domain.GetShopListUseCase
import com.example.myfirsttestgitapp.domain.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getSopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getSopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }

}
