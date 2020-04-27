package com.subhipandey.android.spacingout.lookup

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.subhipandey.android.spacingout.CoroutinesTestRule
import com.subhipandey.android.spacingout.logEvent
import com.subhipandey.android.spacingout.models.EarthImage
import com.subhipandey.android.spacingout.network.SpacingOutApi
import io.mockk.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test

class LookupViewModelTest{
    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesTestRule = CoroutinesTestRule()

            @get:Rule
            val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun `A Image is sent through to the view after cooridnates are input`(){
        val mockApi = mockk<SpacingOutApi>()

        mockkObject(SpacingOutApi)
        every{ SpacingOutApi.create()} returns mockApi
        coEvery { mockApi.getEarthImagery(any(), any()) } returns EarthImage("testurl")
        val viewModel = LookupViewModel()
        viewModel.latLongInput(10f,10f)
        assertEquals("testurl", viewModel.imageLiveData.value)
    }

    @Test
    fun `An event is logged wheneveer cooridinates are input`(){
        val mockApi = mockk<SpacingOutApi>()

        mockkObject(SpacingOutApi)
        mockkStatic("com.subhipandey.android.spacingout.UtilsKt")

        every { SpacingOutApi.create() } returns mockApi
        coEvery { mockApi.getEarthImagery(any(), any()) } returns EarthImage("testurl")

        val viewModel = LookupViewModel()
        viewModel.latLongInput(10f,10f)
        verify(exactly = 1) { viewModel.logEvent("image retrieved", mapOf("latitude" to "10.0", "longitude" to "10.0" ))  }
    }

}