package z.nova.rifmobolgame.screen.splash

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import dagger.hilt.android.AndroidEntryPoint
import z.nova.rifmobolgame.MainActivity
import z.nova.rifmobolgame.databinding.FragmentSplashBinding
import z.nova.rifmobolgame.screen.base.BaseFragment
import java.util.*
import kotlin.concurrent.schedule
import kotlin.system.exitProcess

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>(FragmentSplashBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

  private companion object {
        private const val DELAY_SPLASH = 5000L
    }

}