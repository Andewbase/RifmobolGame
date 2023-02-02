package z.nova.rifmobolgame.screen.rulesgame

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import z.nova.rifmobolgame.databinding.FragmentRulesGameBinding
import z.nova.rifmobolgame.screen.base.BaseFragment

@AndroidEntryPoint
class RulesGameFragment : BaseFragment<FragmentRulesGameBinding>(FragmentRulesGameBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

}