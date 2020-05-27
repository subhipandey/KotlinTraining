

package com.subhipandey.android.rickycharacters.ui.views.fragments.classicalway

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.subhipandey.android.rickycharacters.R
import com.subhipandey.android.rickycharacters.data.models.Character
import com.subhipandey.android.rickycharacters.data.models.CharactersResponseModel
import com.subhipandey.android.rickycharacters.data.network.ApiClient
import com.subhipandey.android.rickycharacters.data.network.ApiService
import com.subhipandey.android.rickycharacters.data.states.NetworkState
import com.subhipandey.android.rickycharacters.ui.adapters.CharactersAdapter
import com.subhipandey.android.rickycharacters.utils.hide
import com.subhipandey.android.rickycharacters.utils.show
import kotlinx.android.synthetic.main.fragment_characters.*

class CharactersFragment : Fragment(R.layout.fragment_characters) {
    private val apiService = ApiClient().getClient().create(ApiService::class.java)
    private lateinit var charactersAdapter: CharactersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        charactersAdapter = CharactersAdapter { character ->
            displayCharacterDetails(character)
        }
        recyclerViewMovies.adapter = charactersAdapter
        hideEmptyView()
        showRefreshDialog()
        fetchCharacters()
        swipeContainer.setOnRefreshListener {
            fetchCharacters()
        }
    }
    private fun displayCharacterDetails(
            character: java.lang.Character) {
        val characterFragmentAction =
                CharactersFragmentDirections.actionCharactersFragmentToCharacterDetailsFragment(
                        character)
        findNavController().navigate(characterFragmentAction)

    }

    private fun fetchCharacters() {
        lifecycleScope.launchWhenStarted {
            try {
                val response = apiService.getCharacters()
                val charactersResponseModel = response.body()
                if (response.isSuccessful){
                    hideEmptyView()
                    if (charactersResponseModel != null){
                        showCharacters(charactersResponseModel)
                    }else{
                        handleError("No characters found")
                    }
                }else{
                    showEmptyView()
                    when(response.code()){
                        403 -> handleError("Access to resource is forbidden")
                        404 -> handleError("Resource not found")
                        500 -> handleError("Internal server error")
                        502 -> handleError("Bad Gateway")
                        301 -> handleError("Resource has been removed permanently")
                        302 -> handleError("Resource moved, but has been found")
                        else -> handleError("All cases have not been covered!!")
                    }
                }
            }catch (error : IOException){
                showEmptyView()
                handleError(error.message!!)
            }
        }
    }

    private fun handleError(message : String){
        errorMessageText.text = message
    }

    private fun showCharacters(
            charactersResponseModel: CharactersResponseModel) {
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