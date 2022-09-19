package jetpack.mvvm

import jetpack.mvvm.base.BaseVmFragment
import jetpack.mvvm.databinding.FragmentMvvmBinding
import jetpack.mvvm.viewmodel.HomeViewModel

/**
 * Description：MvvmFragment
 */
class MvvmFragment : BaseVmFragment<FragmentMvvmBinding, HomeViewModel>() {
    override fun getBinding(): FragmentMvvmBinding {
        return FragmentMvvmBinding.inflate(layoutInflater).apply {
            viewmodel = viewModel
            lifecycleOwner = this@MvvmFragment
        }
    }

    override fun getVmClass(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }
}