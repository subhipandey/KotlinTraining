package com.subhipandey.android.spacingout

import io.mockk.*
import junit.framework.Assert
import org.junit.Assert.*
import org.junit.Test
import org.mockito.ArgumentMatchers.any

class SpacingAnalyticsTest {
    @Test
    fun `New analytic arguments are added before events are sent along`() {
        mockkObject(ThirdPartyAnalyticsProvider)

        val slot = slot<Map<String, String>>()

        every { ThirdPartyAnalyticsProvider.logEvent(any(), capture(slot)) } just runs

        SpacingAnalytics().logEvent("Test", mapOf("attribute" to "value"))

        val expected = mapOf(
            "attribute" to "value",
            "client_type" to "Android",
            "version" to "1"
        )

        Assert.assertEquals(expected, slot.captured)


    }
}