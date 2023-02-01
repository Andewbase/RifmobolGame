package z.nova.rifmobolgame.screen.rulesgame

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import z.nova.rifmobolgame.R
import z.nova.rifmobolgame.databinding.FragmentRulesGameBinding

@AndroidEntryPoint
class RulesGameFragment : Fragment(R.layout.fragment_rules_game) {

    private var mBinding: FragmentRulesGameBinding? = null
    private val binding get() = mBinding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding = FragmentRulesGameBinding.bind(view)

        binding.buttonBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}