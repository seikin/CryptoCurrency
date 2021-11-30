package science.involta.cryptocurrency.api

import com.google.gson.Gson
import okhttp3.ResponseBody
import retrofit2.Response
import science.involta.cryptocurrency.api.model.GenericResponse
import kotlin.Exception

abstract class BaseRemoteDataSource {
    val genericError = "Произошла непредвиденная ошибка"

    suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()

            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Result.Success(body)
            } else if (response.errorBody() != null) {
                val errorBody = getErrorBody(response.errorBody())
                return error(errorBody?.message ?: genericError)
            }

            return error(genericError)
        } catch (e: Exception) {
            return error(e.message ?:e.toString())
        }
    }


    private fun error(message: String): Result.Error = Result.Error(message)

    private fun getErrorBody(responseBody: ResponseBody?): GenericResponse? {
        return try {
            return Gson().fromJson(responseBody?.charStream(),GenericResponse::class.java)
        } catch (e: Exception) {
            null
        }
    }
}