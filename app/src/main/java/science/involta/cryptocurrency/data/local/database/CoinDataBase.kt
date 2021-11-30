package science.involta.cryptocurrency.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database (entities = [CoinsListEntity::class], version = 1, exportSchema = false)
abstract class CoinDataBase: RoomDatabase() {
    abstract fun coinsListDao(): CoinsListDao

    companion object {
        fun buildDataBase(context: Context): CoinDataBase {
            return Room.databaseBuilder(context, CoinDataBase::class.java,"Coins").build()
        }
    }
}