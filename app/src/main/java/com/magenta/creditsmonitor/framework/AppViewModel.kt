package com.magenta.creditsmonitor.framework

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.magenta.creditsmonitor.model.Credit

class AppViewModel : ViewModel() {
    private lateinit var selectedCredit: MutableLiveData<Credit>
    private lateinit var selectedCreditPosition:MutableLiveData<Int>

    fun setSelectedCredit(credit: Credit?, position:Int) {
        if (!::selectedCredit.isInitialized || !::selectedCreditPosition.isInitialized) {
            selectedCredit = MutableLiveData()
            selectedCreditPosition = MutableLiveData()
        }
        selectedCredit.value = credit
        selectedCreditPosition.value = position
    }

    fun getCurrentCredit() = selectedCredit
    fun getCurrentCreditPosition() = selectedCreditPosition



}