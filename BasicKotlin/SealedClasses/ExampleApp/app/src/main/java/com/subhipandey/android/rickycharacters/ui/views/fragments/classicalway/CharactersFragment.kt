

package com.subhipandey.android.rickycharacters.ui.views.fragments.classicalway

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

class CharactersFragment : Fragment(R.layout.fragment_characters) {
  private val apiService = ApiClient().getClient().create(ApiService::class.java)
  private lateinit var charactersAdapter: CharactersAdapter


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    charactersAdapter = CharactersAdapter {character ->
      displayCharacterDetails(character)
    }
    recyclerViewMovies.adapter = charactersAdapter
    fetchCharacters()
    swipeContainer.setOnRefreshListener {
      fetchCharacters()
    }
  }

  private fun displayCharacterDetails(character: Character){
    val characterFragmentAction =
        CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailsFragment(
            character)
    findNavController().navigate(characterFragmentAction)


  }

  private fun fetchCharacters() {
   lifecycleScope.launchWhenStarted {
     val response = apiService.getCharacters()
     val charactersResponseModel = response.body()
     if (response.isSuccessful){
       hideEmptyView()
       showCharacters(charactersResponseModel)
     }
   }

    else {
      handleError("An error occurred")
    }

    //TODO 3 Catch errors with try-catch statement

    //TODO 4 Catch HTTP error codes

    //TODO 5 Add refresh dialog

    //TODO 6 Handle null response body
  }

  private fun showCharacters(charactersResponseModel: CharactersResponseModel?) {
    charactersAdapter.updateList(charactersResponseModel!!.results)
  }

  private fun handleError(message : String){
    errorMessageText.text = message
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