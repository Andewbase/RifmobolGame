package z.nova.rifmobolgame.screen.singllist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import z.nova.rifmobolgame.R
import z.nova.rifmobolgame.data.model.TextLevel
import z.nova.rifmobolgame.databinding.FragmentSinglListBinding

@AndroidEntryPoint
class SingleListFragment : Fragment(R.layout.fragment_singl_list) {

    private var mBinding: FragmentSinglListBinding?= null
    private val binding get() = mBinding!!

    private val viewModel by viewModels<SingleListViewModel>()

    private val adapter by lazy { SingleListAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mBinding = FragmentSinglListBinding.bind(view)

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



    override fun onDestroyView() {
        super.onDestroyView()
        mBinding = null
    }

}