

package com.subhipandey.markme.feature.view.ui

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.subhipandey.markme.R
import com.subhipandey.markme.feature.FeatureContract
import com.subhipandey.markme.feature.presenter.FeaturePresenter
import com.subhipandey.markme.feature.view.adapter.FeatureAttendanceAdapter
import com.subhipandey.markme.feature.view.adapter.FeatureGradingAdapter
import com.subhipandey.markme.feature.view.adapter.SpAdapter
import com.subhipandey.markme.main.view.ui.FEATURE_CATEGORY
import com.subhipandey.markme.model.Student
import com.subhipandey.markme.model.studentList
import com.subhipandey.markme.utils.ClassSection
import kotlinx.android.synthetic.main.activity_feature.*
import org.jetbrains.anko.toast
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class FeatureActivity : AppCompatActivity(), FeatureContract.View<Student> {

    private val labelTitle: TextView? by lazy { activity_feature__label__category }
    private val rvItems: RecyclerView? by lazy { activity_feature__rv__list }
    private val btnSave: Button? by lazy { activity_feature__btn__save }
    private val classList = studentList.map { Student(uid = null, name = it, attendance = false, grade = -1) }
    private val featurePresenter: FeatureContract.Presenter<Student> by inject { parametersOf(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature)

        actionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onResume() {
        super.onResume()

        val featureType = intent.getParcelableExtra<ClassSection>(FEATURE_CATEGORY)
        featureType?.let { feature ->
            labelTitle?.text = feature.sectionName
            labelTitle?.background = ContextCompat.getDrawable(this, feature.color)
            // Set up UI elements
            setupSaveButton(feature)
            setupRecyclerView(feature)
            // Load persisted data if any
            featurePresenter.loadPersistedData(data = classList, featureType = feature)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                NavUtils.navigateUpFromSameTask(this)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun showToastMessage(msg: String) {
        toast(msg)
    }

    override fun onPersistedDataLoaded(data: List<Student>) {
        @Suppress("UNCHECKED_CAST")
        (rvItems?.adapter as? SpAdapter<Student>)?.updateData(data)
    }

    private fun setupSaveButton(feature: ClassSection) {
        btnSave?.text = if (feature == ClassSection.ATTENDANCE) "Save to prefs" else "Save to db"
        btnSave?.setOnClickListener {
            when (feature) {
                ClassSection.ATTENDANCE -> {
                    @Suppress("UNCHECKED_CAST")
                    featurePresenter.onSave2PrefsClick((rvItems?.adapter as? SpAdapter<Student>)?.getData())
                }
                ClassSection.GRADING -> {
                    hideSoftKeyboard()
                    rvItems?.requestFocus()   // Get focus to update 'dataList'
                    @Suppress("UNCHECKED_CAST")
                    featurePresenter.onSave2DbClick((rvItems?.adapter as? SpAdapter<Student>)?.getData())
                }
            }
        }
    }

    private fun setupRecyclerView(feature: ClassSection) {
        rvItems?.apply {
            layoutManager = LinearLayoutManager(this@FeatureActivity, LinearLayout.VERTICAL, false)
            adapter = when (feature) {
                ClassSection.ATTENDANCE ->
                    FeatureAttendanceAdapter(dataList = classList)
                ClassSection.GRADING ->
                    FeatureGradingAdapter(dataList = classList)
            }
        }
    }

    private fun hideSoftKeyboard() {
        val inputMethodManager: InputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentFocus?.windowToken, 0)
    }
}