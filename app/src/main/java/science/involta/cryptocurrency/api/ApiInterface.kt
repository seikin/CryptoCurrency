package science.involta.cryptocurrency.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import science.involta.cryptocurrency.api.model.Coin
import science.involta.cryptocurrency.api.model.HistoryPriceResponse

interface ApiInterface {
    @GET("coins/markets")
    //vs_currency
    suspend fun coinsList(@Query("vs_currency")targetCurrency: String): Response<List<Coin>>

    @GET("coins/bitcoin/market_chart")
    suspend fun historicalPrice(
        @Path("id") id: String,
        @Query("vs_currency") targetCurrency: String,
        @Query("days") days: Int,
    ): Response<HistoryPriceResponse>

}