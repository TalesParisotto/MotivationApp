package com.parisotto.motivation.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.parisotto.motivation.R
import com.parisotto.motivation.util.MotivationConstants
import com.parisotto.motivation.util.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity(),View.OnClickListener {

    private lateinit var mSecuroty: SecurityPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        mSecuroty = SecurityPreferences(this)
        buttonSave.setOnClickListener(this)

        verifyUserName()

    }

    override fun onClick(view: View?) {
        if (view != null) {
            if(view.id == R.id.buttonSave){
                handleSave()
            }
        }
    }

    private fun verifyUserName(){
        val userName = mSecuroty.getStoredgeString(MotivationConstants.key.PERSON_NAME)
        if(userName != ""){
            val i:Intent = Intent(this, MainActivity::class.java)
        }
        editName.setText(userName)
    }

    private fun handleSave(){
        val name: String = editName.text.toString()
        if(name == ""){
            Toast.makeText(this,"por favor, informe seu nome",Toast.LENGTH_LONG).show()
        }else {
            mSecuroty.storeString((MotivationConstants.key.PERSON_NAME), name)
            val i:Intent = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }
    }
}
