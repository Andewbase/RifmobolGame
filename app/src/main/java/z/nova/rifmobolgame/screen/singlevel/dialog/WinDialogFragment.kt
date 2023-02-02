package z.nova.rifmobolgame.screen.singlevel.dialog

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import z.nova.rifmobolgame.data.local.GameData.LAST_LEVEL
import z.nova.rifmobolgame.databinding.FragmentWinDialogBinding
import z.nova.rifmobolgame.screen.base.BaseDialogFragment

@AndroidEntryPoint
class WinDialogFragment: BaseDialogFragment<FragmentWinDialogBinding>(FragmentWinDialogBinding::inflate) {

    private val viewModel by viewModels<DialogViewModel>()

    private val safArgs: WinDialogFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var idLvlDialog = safArgs.idLvlDialogWin

        viewModel.textDialogWinLiveData.observe(viewLifecycleOwner) { text ->
            binding.textwin.setText(text.textDialog)
        }

        binding.btnClose.setOnClickListener {
            yodoMas(idLvlDialog)
            val action = WinDialogFragmentDirections.actionWinDialogFragmentToSinglListFragment()
            findNavController().navigate(action)
        }

        binding.btnContinue.setOnClickListener {
            yodoMas(idLvlDialog)

            if (idLvlDialog != LAST_LEVEL){
                val nextLevel = ++idLvlDialog
                val action = WinDialogFragmentDirections.actionWinDialogFragmentToSingLevelFragment(nextLevel)
                findNavController().navigate(action)
            }else{
                val action = WinDialogFragmentDirections.actionWinDialogFragmentToSinglListFragment()
                findNavController().navigate(action)
            }
        }
    }

}