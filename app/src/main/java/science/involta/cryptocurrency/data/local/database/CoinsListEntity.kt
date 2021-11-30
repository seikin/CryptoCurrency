package science.involta.cryptocurrency.data.local.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "coins_list")
data class CoinsListEntity(
    val id: String?,
    @PrimaryKey val symbol: String?,
    val name: String?,
    val image: String?,
    val price: Double?,
    val changePrice: Double?,
    val isFavorite: Boolean = false
)