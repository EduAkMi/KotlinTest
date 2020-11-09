package com.example.kotlintest.bProjectB

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ReligionViewModel : ViewModel() {
    val confirmReligion: MutableLiveData<Boolean> = MutableLiveData()
    val confirmChangeTab: MutableLiveData<Boolean> = MutableLiveData()

    fun setConfirmReligion(confirm: Boolean) = confirmReligion.postValue(confirm)

    fun setConfirmTab(confirm: Boolean) = confirmChangeTab.postValue(confirm)
}