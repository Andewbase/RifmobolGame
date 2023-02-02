package z.nova.rifmobolgame.screen.mainmenu

import android.os.Bundle
import android.view.View
import androidx.activity.addCallback
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import z.nova.rifmobolgame.databinding.FragmentMainMenuBinding
import z.nova.rifmobolgame.screen.base.BaseFragment
import kotlin.system.exitProcess

@AndroidEntryPoint
class MainMenuFragment : BaseFragment<FragmentMainMenuBinding>(FragmentMainMenuBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       val randomMultiLvl = (1..31).random()

        binding.btnPlay.setOnClickListener {
            val action = MainMenuFragmentDirections.actionMainMenuFragmentToSinglListFragment()
            findNavController().navigate(action)
        }

        binding.btnMultiplayer.setOnClickListener {
            val action = MainMenuFragmentDirections.actionMainMenuFragmentToMultiLevelFragment(randomMultiLvl)
            findNavController().navigate(action)
        }

        binding.btnRules.setOnClickListener {
            val action = MainMenuFragmentDirections.actionMainMenuFragmentToRulesGameFragment()
            findNavController().navigate(action)
        }

        val callbackBackPressedCallback = requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner){
            requireActivity().moveTaskToBack(true)
            requireActivity().finish()
            exitProcess(0)
        }

        callbackBackPressedCallback.isEnabled
    }




}