package z.nova.rifmobolgame.screen.splash

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.activity.addCallback
import dagger.hilt.android.AndroidEntryPoint
import z.nova.rifmobolgame.MainActivity
import z.nova.rifmobolgame.R
import z.nova.rifmobolgame.databinding.FragmentSplashBinding
import java.util.*
import kotlin.concurrent.schedule
import kotlin.system.exitProcess

private const val DELAY_SPLASH = 5000L

@AndroidEntryPoint
class SplashFragment : Fragment(R.layout.fragment_splash) {

    private var mBinding: FragmentSplashBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding = FragmentSplashBinding.bind(view)

        val intent = Intent(requireContext(), MainActivity::class.java)
        Timer().schedule(DELAY_SPLASH){
            startActivity(intent)
        }

        val callbackBackPressedCallback = requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            requireActivity().moveTaskToBack(true)
            requireActivity().finish()
            exitProcess(0)
        }

        callbackBackPressedCallback.isEnabled

    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding = null
    }
}