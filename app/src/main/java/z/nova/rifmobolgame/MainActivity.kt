package z.nova.rifmobolgame

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.yodo1.mas.Yodo1Mas
import com.yodo1.mas.error.Yodo1MasError
import dagger.hilt.android.AndroidEntryPoint
import z.nova.rifmobolgame.databinding.ActivityMainBinding


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var mBinding: ActivityMainBinding?= null
    private val binding get() = mBinding!!

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Yodo1Mas.getInstance().init(this, YODO_KEY, object : Yodo1Mas.InitListener {
            override fun onMasInitSuccessful() {}
            override fun onMasInitFailed(error: Yodo1MasError) {}
        })

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerMain) as NavHostFragment
        navController = navHostFragment.findNavController()

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }

    companion object ConstKey{
        private const val YODO_KEY = "sszpCIMxv0"
    }
}