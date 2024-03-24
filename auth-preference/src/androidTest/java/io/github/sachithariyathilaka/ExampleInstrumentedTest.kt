package io.github.sachithariyathilaka

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.github.sachithariyathilaka.resource.Headers
import io.github.sachithariyathilaka.resource.UserDetail

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test for the library.
 *
 * @author  Sachith Ariyathilaka
 * @version 1.0.0
 * @since   2024/03/24
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {

    private var appContext: Context = InstrumentationRegistry.getInstrumentation().targetContext
    private var userDetail: UserDetail = UserDetail("USER-01", true)
    private var headers: List<Headers> = listOf(Headers("meta", "This is meta data"))

    /**
     * Save user detail test.
     */
    @Test
    fun saveUserDetailsTest() {
        AuthPreference.saveUserDetails(appContext, userDetail)
    }

    /**
     * Get user detail test.
     */
    @Test
    fun getUserDetailsTest() {
        assertNotNull(AuthPreference.getUserDetails(appContext))
    }

    /**
     * Save user header test.
     */
    @Test
    fun saveUserHeaderTest() {
        AuthPreference.saveHeaders(appContext, headers)
    }

    /**
     * Get user header test.
     */
    @Test
    fun getHeaderTest() {
        assertNotNull(AuthPreference.getHeaders(appContext, listOf("meta")))
    }
}