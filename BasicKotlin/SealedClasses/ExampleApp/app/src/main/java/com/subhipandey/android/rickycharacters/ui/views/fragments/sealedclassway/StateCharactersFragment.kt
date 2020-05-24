

package com.subhipandey.android.rickycharacters.ui.views.fragments.sealedclassway

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.subhipandey.android.rickycharacters.R
import com.subhipandey.android.rickycharacters.data.models.Character
import com.subhipandey.android.rickycharacters.data.models.CharactersResponseModel
import com.subhipandey.android.rickycharacters.data.network.ApiClient
import com.subhipandey.android.rickycharacters.data.network.ApiService
import com.subhipandey.android.rickycharacters.ui.adapters.CharactersAdapter
import com.subhipandey.android.rickycharacters.utils.hide
import com.subhipandey.android.rickycharacters.utils.show
import kotlinx.android.synthetic.main.fragment_characters.*

class StateCharactersFragment : Fragment(R.layout.fragment_characters) {
  private val apiService = ApiClient().getClient().create(ApiService::class.java)
  private lateinit var charactersAdapter: CharactersAdapter

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    charactersAdapter = CharactersAdapter { character ->
      displayCharacterDetails(character)
    }
    recyclerViewMovies.adapter = charactersAdapter

    getCharacters()
    swipeContainer.setOnRefreshListener {
      getCharacters()
    }
  }

  private fun getCharacters() {
    lifecycleScope.launchWhenStarted{
      showRefreshDailog()
      val charactersResult = fetchCharacters()
      handleCharactersResult(charactersResult)
    }
  }



  private fun displayCharacterDetails(character: Character){
    val characterFragmentAction =
        StateCharactersFragmentDirections.actionStateCharactersFragmentToCharacterDetailsFragment(
            character)
    findNavController().navigate(characterFragmentAction)
  }

  private fun handleError(message : String){
    hideRefreshDialog()
    errorMessageText.text = message
  }

  private fun showCharacters(
      charactersResponseModel: CharactersResponseModel) {
    hideEmptyView()
    charactersAdapter.updateList(charactersResponseModel.results)
  }

  private fun showEmptyView(){
    emptyViewLinear.show()
    recyclerViewMovies.hide()
    hideRefreshDialog()
  }

  private fun hideEmptyView(){
    emptyViewLinear.hide()
    recyclerViewMovies.show()
    hideRefreshDialog()
  }

  private fun showRefreshDialog(){
    swipeContainer.isRefreshing = true
  }

  private fun hideRefreshDialog(){
    swipeContainer.isRefreshing = false
  }
}