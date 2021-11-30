package science.involta.cryptocurrency.api.model

import com.google.gson.annotations.SerializedName
//описание данных с сервера https://www.coingecko.com/ru/api/documentation  coins/markets vs_currency USD
data class Coin (
    val id: String?,
    val symbol: String?,
    val name: String?,
    val image: String?,
    //
    @SerializedName("current_price") val price: Double?,
    @SerializedName("price_change_24h") val changePrice: Double?
)
