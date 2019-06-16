package com.parisotto.motivation.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.parisotto.motivation.R
import com.parisotto.motivation.mock.Mock
import com.parisotto.motivation.util.MotivationConstants
import com.parisotto.motivation.util.SecurityPreferences
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    private var mFilter:Int = MotivationConstants.PHRASE_FILTER.all
    private val mMock = Mock()
    private lateinit var mSecurityPreferences: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSecurityPreferences = SecurityPreferences(this)

        setListeners()

        handleFilter(R.id.imageAll)
        refreshPhrase()
        verifyUserName()
    }

    override fun onClick(view: View) {
        val id = view.id

        val listId = listOf(R.id.imageAll,R.id.imageSun,R.id.imageHappy)
        if(id in listId ){
            handleFilter(id)
        }else if(id == R.id.buttonNovaFrase){
            refreshPhrase()
        }
    }

    private fun setListeners(){
        imageAll.setOnClickListener(this)
        imageSun.setOnClickListener(this)
        imageHappy.setOnClickListener(this)
        buttonNovaFrase.setOnClickListener(this)
    }

    private fun verifyUserName(){
        textUserName.text = mSecurityPreferences.getStoredgeString(MotivationConstants.key.PERSON_NAME)
    }

    private fun handleFilter(id:Int){

        imageAll.setImageResource(R.drawable.ic_all_inclusive_black_24dp)
        imageSun.setImageResource(R.drawable.ic_wb_sunny_black_24dp)
        imageHappy.setImageResource(R.drawable.ic_sentiment_very_satisfied_black_24dp)

        if(id == R.id.imageAll){
            mFilter = MotivationConstants.PHRASE_FILTER.all
            imageAll.setImageResource(R.drawable.ic_all_inclusive_blue_24dp)
        }else if(id == R.id.imageSun){
            mFilter = MotivationConstants.PHRASE_FILTER.sun
            imageAll.setImageResource(R.drawable.ic_wb_sunny_blue_24dp)

        }else{
            mFilter = MotivationConstants.PHRASE_FILTER.happy
            imageSun.setImageResource(R.drawable.ic_sentiment_very_satisfied_blue_24dp)

        }
    }

    private fun refreshPhrase(){
        textFrase.text = mMock.getPhrase(mFilter)
    }
}
