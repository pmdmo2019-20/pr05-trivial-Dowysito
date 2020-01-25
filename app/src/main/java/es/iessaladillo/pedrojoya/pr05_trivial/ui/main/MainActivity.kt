package ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import es.iessaladillo.pedrojoya.pr05_trivial.R
import ui.title.TitleFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        setupFragment()
    }

    private fun setupFragment() {
        supportFragmentManager.commit {
            replace(R.id.fcContent,
                TitleFragment.newInstance())
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        supportFragmentManager.commit {
            replace(R.id.fcContent,
                TitleFragment.newInstance())
        }
    }
}