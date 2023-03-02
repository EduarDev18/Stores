package com.example.stores
import androidx.room.*



@Dao
interface StoreDao {
    @Query( value =  "SELECT * FROM StoreEntity")
    fun getAllStores(): MutableList<StoreEntity>

    @Insert
    fun addStore(storeEntity:StoreEntity)

    @Update
    fun updateStore(store:StoreEntity)

    @Delete
    fun deleteStore(store:StoreEntity)
}