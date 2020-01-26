package ui.main

import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.commit
import androidx.preference.PreferenceManager
import es.iessaladillo.pedrojoya.pr05_trivial.R
import es.iessaladillo.pedrojoya.pr05_trivial.ui.main.MainActivityViewModel
import ui.title.TitleFragment

class MainActivity : AppCompatActivity() {

    private val viewModel: MainActivityViewModel by viewModels()

    private val settings: SharedPreferences by lazy {
        PreferenceManager.getDefaultSharedPreferences(applicationContext)
    }


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
//        if (viewModel.currentFrag.value==1&&settings.getBoolean(getString(R.string.prefDialog),true)){
//            ESTO NO FUNCIONA (NO MUESTRA EL DIALOGO)
//            DialogFragment().show(supportFragmentManager,"sure")
//            if (viewModel.response.value?:true){
//                supportFragmentManager.commit {
//                    replace(R.id.fcContent,
//                        TitleFragment.newInstance())
//                }
//            }
//        }
//        else{
            supportFragmentManager.commit {
                replace(R.id.fcContent,
                    TitleFragment.newInstance())
            }
        }
//    }
}