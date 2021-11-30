package science.involta.cryptocurrency.data.local.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface CoinsListDao {
    @Query("SELECT * FROM coins_list")
    fun coinsList(): LiveData<List<CoinsListEntity>>

    @Query("SELECT * FROM coins_list WHERE symbol = :symbol")
    fun coinLiveDataFromSymbol(symbol: String): CoinsListEntity?

    @Query("SELECT * FROM coins_list WHERE isFavorite = 1")
    fun favoriteCoins(): LiveData<List<CoinsListEntity>>

    @Query("SELECT symbol FROM coins_list WHERE isFavorite = 1")
    suspend fun favoriteSymbols(): List<String>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(list: List<CoinsListEntity>)

    @Update
    suspend fun updateCoinsListEntity(data: CoinsListEntity): Int

    @Query("DELETE FROM coins_list")
    suspend fun deleteAll()
}