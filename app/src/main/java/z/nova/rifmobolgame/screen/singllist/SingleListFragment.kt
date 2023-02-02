package z.nova.rifmobolgame.screen.singllist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import z.nova.rifmobolgame.data.model.TextLevel
import z.nova.rifmobolgame.databinding.FragmentSinglListBinding
import z.nova.rifmobolgame.screen.base.BaseFragment

@AndroidEntryPoint
class SingleListFragment : BaseFragment<FragmentSinglListBinding>(FragmentSinglListBinding::inflate) {

    private val viewModel by viewModels<SingleListViewModel>()

    private val adapter by lazy { SingleListAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.textLvlLiveData.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
            binding.apply {
                rvList.adapter = adapter
            }
        }

        adapter.setOnItemClick(object: SingleListAdapter.OnItemClick{
            override fun onItemClick(textLevel: TextLevel) {

                val action = SingleListFragmentDirections.actionSinglListFragmentToSingLevelFragment(textLevel.nameLvl)
                findNavController().navigate(action)
            }
        })

        binding.buttonBack.setOnClickListener {
            findNavController().navigateUp()
        }

    }

}