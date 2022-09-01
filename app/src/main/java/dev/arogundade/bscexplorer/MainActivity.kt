package dev.arogundade.bscexplorer

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import dev.arogundade.library.BscExplorer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var explorer: BscExplorer

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {
            val result = explorer.getInternalTransactions("0x9E47A9f1843Ebd9339C53E0732FbD540A2Ea43AC", 1)
            withContext(Dispatchers.Main) {
                val tv = findViewById<TextView>(R.id.text)
                tv.text = result.e?.message.toString()
                result.data?.forEach {
                    tv.text = tv.text.toString() + "\n" + it.value
                }
            }
        }

    }
}