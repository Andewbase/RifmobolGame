package z.nova.rifmobolgame.screen.singlevel.dialog

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import z.nova.rifmobolgame.data.local.GameData.LAST_LEVEL
import z.nova.rifmobolgame.databinding.FragmentLoseDialogBinding
import z.nova.rifmobolgame.screen.base.BaseDialogFragment

@AndroidEntryPoint
class LoseDialogFragment : BaseDialogFragment<FragmentLoseDialogBinding>(FragmentLoseDialogBinding::inflate) {

    private val viewModel by viewModels<DialogViewModel>()

    private val safeArgs: LoseDialogFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var idLvlDialog = safeArgs.idLvlDialogLose

        viewModel.textDialogLoseLiveData.observe(viewLifecycleOwner) { text ->
            binding.textlose.setText(text.textDialog)
        }

        binding.btnClose.setOnClickListener {
            yodoMas(idLvlDialog)
            val action = LoseDialogFragmentDirections.actionLoseDialogFragmentToSinglListFragment()
            findNavController().navigate(action)
        }

        binding.btnContinue.setOnClickListener {
            yodoMas(idLvlDialog)

            if (idLvlDialog != LAST_LEVEL){
                val nextLevel = ++idLvlDialog
                val action = LoseDialogFragmentDirections.actionLoseDialogFragmentToSingLevelFragment(nextLevel)
                findNavController().navigate(action)
            }else{
                val action = LoseDialogFragmentDirections.actionLoseDialogFragmentToSinglListFragment()
                findNavController().navigate(action)
            }
        }

        binding.btncontinueback.setOnClickListener {
            val action = LoseDialogFragmentDirections.actionLoseDialogFragmentToSingLevelFragment(idLvlDialog)
            findNavController().navigate(action)
        }

    }

}