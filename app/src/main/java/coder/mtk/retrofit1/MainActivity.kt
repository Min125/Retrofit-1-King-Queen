package coder.mtk.retrofit1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import coder.mtk.retrofit1.fragments.BoyFragment
import coder.mtk.retrofit1.fragments.GirlFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        btnBoy.setOnClickListener {
            val oneFragment = BoyFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment,oneFragment)
            transaction.commit()
        }
        btnGirl.setOnClickListener {
            val twoFragment = GirlFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment,twoFragment)
            transaction.commit()
        }
    }
}