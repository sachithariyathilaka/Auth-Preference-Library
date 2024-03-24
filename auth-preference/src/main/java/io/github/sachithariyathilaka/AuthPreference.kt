package io.github.sachithariyathilaka

import android.content.Context
import io.github.sachithariyathilaka.resource.Headers
import io.github.sachithariyathilaka.resource.UserDetail

/**
 * Main class for the library.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/03/24
 */
object AuthPreference {

    /**
     * Static method for save user details.
     *
     * @param   context the context
     * @param   userDetail the user details
     */
    fun saveUserDetails(context: Context, userDetail: UserDetail) {
        val sharedPreferences = context.getSharedPreferences("User", Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()
        editor.putString("userId", userDetail.userId)
        editor.putBoolean("status", userDetail.status)

        editor.apply()
    }

    /**
     * Static method for save user headers.
     *
     * @param   context the context
     * @param   headers the header list
     */
    fun saveHeaders(context: Context, headers: List<Headers>) {
        val sharedPreferences = context.getSharedPreferences("User", Context.MODE_PRIVATE)

        val editor = sharedPreferences.edit()
        for (i in headers.indices)
            editor.putString(headers[i].header, headers[i].value)

        editor.apply()
    }

    /**
     * Static method for get user details.
     *
     * @param   context the context
     *
     * @return  the user details
     */
    fun getUserDetails(context: Context): UserDetail? {
        val sharedPreferences = context.getSharedPreferences("User", Context.MODE_PRIVATE)
        return sharedPreferences.getString("userId", "")?.let { UserDetail(it, sharedPreferences.getBoolean("status", false)) }
    }

    /**
     * Static method for get user headers.
     *
     * @param   context the context
     * @param   headerNames the header names
     *
     * @return  the headers
     */
    fun getHeaders(context: Context, headerNames: List<String?>): ArrayList<Headers> {
        val sharedPreferences = context.getSharedPreferences("User", Context.MODE_PRIVATE)
        val headers = ArrayList<Headers>()

        for (j in headerNames.indices) headers.add(
            Headers(
                headerNames[j]!!, sharedPreferences.getString(
                    headerNames[j], ""
                )!!
            )
        )

        return headers
    }
}
