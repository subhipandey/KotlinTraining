

package com.subhipandey.markme

import com.nhaarman.mockito_kotlin.argumentCaptor
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.mock
import com.subhipandey.markme.di.applicationModule
import com.subhipandey.markme.feature.FeatureContract
import com.subhipandey.markme.model.Student
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.koin.core.parameter.parametersOf
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.StandAloneContext.stopKoin
import org.koin.standalone.inject
import org.koin.test.KoinTest
import org.koin.test.declareMock
import org.mockito.Mockito

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class FeaturePresenterTest : KoinTest {

    private val view: FeatureContract.View<Student> = mock()
    private val repository: FeatureContract.Model<Student> by inject()
    private val presenter: FeatureContract.Presenter<Student> by inject { parametersOf(view) }

    @Before
    fun before() {
        startKoin(listOf(applicationModule))
        declareMock<FeatureContract.Model<Student>>()
    }

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun `check that onSave2DbClick invokes a repository callback`() {
        val studentList = listOf(
                Student(0, "Pablo", true, 8),
                Student(1, "Irene", false, 10))
        val dummyCallback = argumentCaptor<(String) -> Unit>()

        presenter.onSave2DbClick(studentList)
        Mockito.verify(repository).add2Db(data = eq(studentList), callback = dummyCallback.capture())
    }
}
