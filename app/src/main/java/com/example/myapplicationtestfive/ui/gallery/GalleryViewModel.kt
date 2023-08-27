package com.example.myapplicationtestfive.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplicationtestfive.network.gallery.UserToInsert
import com.example.myapplicationtestfive.network.gallery.UserToUpdate
import com.example.myapplicationtestfive.network.gallery.UsersApi
import kotlinx.coroutines.launch

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is gallery Fragment"
    }
    val text: LiveData<String> = _text

    // The internal MutableLiveData that stores the status of the most recent request
    private val _status = MutableLiveData<String>()

    // The external immutable LiveData for the request status
    val status: LiveData<String> = _status
    /**
     * Call getMarsPhotos() on init so we can display status immediately.
     */
    init {
        getUsers()
    }


    fun getUsers() {
        viewModelScope.launch {
            try {
                val listResult = UsersApi.retrofitService.getUsers()
                _status.value = "Success: ${listResult.users.size} Users retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }

    fun getSingleUser(id: String) {
        viewModelScope.launch {
            try {
                val listResult = UsersApi.retrofitService.getSingleUser(id)
                _status.value = "Success: ${listResult.user.toString()} User retrieved"
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }

    fun createSingleUser(name: String, job: String) {
        viewModelScope.launch {
            try {
                val listResult = UsersApi.retrofitService.createUser(UserToInsert("Lorem", "Ipsum"))
                _status.value = "Success: ${listResult.toString()} "
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }

    fun updateSingleUser(id: String, name: String, job: String) {
        viewModelScope.launch {
            try {
                val listResult = UsersApi.retrofitService.updateUser(id, UserToUpdate("Lorem", "Ipsum"))
                _status.value = "Success: ${listResult.toString()} "
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
    fun deleteSingleUser(id: String) {
        viewModelScope.launch {
            try {
                val listResult = UsersApi.retrofitService.deleteUser(id)
                _status.value = "Success: ${listResult.toString()} "
            } catch (e: Exception) {
                _status.value = "Failure: ${e.message}"
            }
        }
    }
}