

package com.subhipandey.android.w00tze.ui.repos


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.subhipandey.android.w00tze.R
import com.subhipandey.android.w00tze.model.ApiError
import com.subhipandey.android.w00tze.model.Either
import com.subhipandey.android.w00tze.model.Repo
import com.subhipandey.android.w00tze.model.Status
import com.subhipandey.android.w00tze.viewmodel.ReposViewModel
import kotlinx.android.synthetic.main.fragment_repos.*


class ReposFragment : Fragment() {

  private lateinit var reposViewModel: ReposViewModel

  private val adapter = RepoAdapter(mutableListOf())

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    val view = inflater.inflate(R.layout.fragment_repos, container, false)

    reposViewModel = ViewModelProviders.of(this).get(ReposViewModel::class.java)

    return view
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)


    reposViewModel.getRepos().observe(this, Observer<Either<List<Repo>>> { either ->
      if (either?.status == Status.SUCCESS && either.data != null) {
        adapter.updateRepos(either.data)
      } else {
        if (either?.error == ApiError.REPOS) {
          Toast.makeText(context, getString(R.string.error_retrieving_repos), Toast.LENGTH_SHORT).show()
        }
      }
    })
  }
}