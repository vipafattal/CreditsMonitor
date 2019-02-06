package com.magenta.creditsmonitor.model

import androidx.annotation.DrawableRes
import com.magenta.creditsmonitor.R


/**
 * Created by Alexander Kolpakov on 24.07.2018
 */
object DataProvider {

    fun getCreditsData(): List<Credit> {
        val data = ArrayList<Credit>()
        data.add(
            Credit(
               0, "Google Play",
               "28.07.2018",
               "$38,456.78",
                Status.COMPLAINT,
                R.drawable.img_google_play
            )
        )
        data.add(
            Credit(
                1,
                "Twitter",
                "27.07.2018",
                "$1,550.60",
                Status.RECEIVED,
                R.drawable.img_twitter
            )
        )
        data.add(
            Credit(
                2,
                "YouTube",
                "27.07.2018",
                "$14,340.00",
                Status.CORRECT,
                R.drawable.img_youtube
            )
        )
        data.add(
            Credit(
                3,
                "Dribbble",
                "26.07.2018",
                "$2,678.27",
                Status.ERROR,
                R.drawable.img_dribble
            )
        )
        data.add(
            Credit(
                4,
                "Apple Store",
                "26.07.2018",
                "$20,479.12",
                Status.CORRECT,
                R.drawable.img_apple
            )
        )
        data.add(
            Credit(
                5,
                "VK",
                "25.07.2018",
                "$13,846.13",
                Status.INCORRECT,
                R.drawable.img_vk
            )
        )
        data.add(
            Credit(
                6,
                "Instagram",
                "25.07.2018",
                "$24,856.17",
                Status.NOT_RECEIVED,
                R.drawable.img_instagram
            )
        )
        data.add(
            Credit(
                7,
                "Github",
                "24.07.2018",
                "$376.90",
                Status.COMPLAINT,
                R.drawable.img_github
            )
        )
        data.add(
            Credit(
                8,
                "Vimeo",
                "23.07.2018",
                "$7,568.02",
                Status.RECEIVED,
                R.drawable.img_vimeo
            )
        )
        data.add(
            Credit(
                9,
                "Facebook",
                "10.07.2018",
                "$18,347.32",
                Status.INCORRECT,
                R.drawable.img_facebook
            )
        )
        return data
    }


    fun getDetailsData(): List<Detail> =
        listOf(
            Detail(0, "In App purchase\"Gem\"", "$14,340.00 X1 (including VAT 10%)", "$14,340.00"),
            Detail(0, "In App purchase \"Money\"", "$2,456.78 X1 (including VAT 10%)", "$2,456.78"),
            Detail(0, "Interstitial Ads", "$1,150.15 X1 (including VAT 10%)", "$1,150.15"),
            Detail(0, "Rewarded video", "$566.20 X1 (including VAT 10%)", "$566.20")
        )
    enum class Status(val code: String, @DrawableRes val iconId: Int) {
        CORRECT("Correct", R.drawable.ic_correct),
        INCORRECT("Incorrect", R.drawable.ic_incorrect),
        COMPLAINT("Complaint", R.drawable.ic_complaint),
        ERROR("Error", R.drawable.ic_error),
        RECEIVED("Received", R.drawable.ic_received),
        NOT_RECEIVED("Not received", R.drawable.ic_not_received)
    }
}


