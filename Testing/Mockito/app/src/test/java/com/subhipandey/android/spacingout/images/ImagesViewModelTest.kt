package com.subhipandey.android.spacingout.images

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.subhipandey.android.spacingout.CoroutinesTestRule
import com.subhipandey.android.spacingout.SpacingAnalytics
import io.mockk.every
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test


class ImagesViewModelTest {

    @ExperimentalCoroutinesApi
    @get:Rule
    val coroutinesTestRule: CoroutinesTestRule()

    @get:Rule
    val instantTaskExecutorRule: = InstantTaskExecutorRule()



    @Test
    fun `An analytics call is made when images are loaded`(){
        val provider = mockk<ImageListProvider>()
        val analytics = spyk<SpacingAnalytics>()

        every { analytics.logEvent(any(), any()) } answers {
            print("you've changed the underlying logEvent method!")
        }

        val viewModel = ImagesViewModel(provider, analytics)
        verify(exactly = 1) {analytics.logEvent("fetching images")}

    }
}