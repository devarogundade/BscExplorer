package dev.arogundade.bscexplorer

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import dev.arogundade.library.BscExplorer
import dev.arogundade.library.utils.Converter
import dev.arogundade.library.utils.Status
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

        val address = "0x9E47A9f1843Ebd9339C53E0732FbD540A2Ea43AC"

        CoroutineScope(Dispatchers.IO).launch {
            val result = explorer.getBnbBalance(address)
            withContext(Dispatchers.Main) {
                val tv = findViewById<TextView>(R.id.text)
                if (result is Status.Failure) {
                    tv.text = result.e?.message.toString()
                } else {
                    tv.text = Converter.convert(
                        result.data ?: 0.0,
                        Converter.Unit.Wei,
                        Converter.Unit.BNB
                    ).toString()
                }
            }
        }

    }
}