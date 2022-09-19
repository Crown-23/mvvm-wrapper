package jetpack.mvvm.base

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import jetpack.mvvm.ContentLoadingDialog

/**
 * Description：MVVM base fragment
 */
abstract class BaseVmFragment<VB : ViewDataBinding, VM : BaseViewModel> : BaseFragment<VB>() {
    protected val viewModel by lazy { ViewModelProvider(this).get(getVmClass()) }

    private val loadingDialog by lazy { ContentLoadingDialog(requireContext()) }

    abstract fun getVmClass(): Class<VM>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addObserver()
    }

    open fun addObserver() {
        viewModel.dataLoading.observe(viewLifecycleOwner) {
            if (it) {
                loadingDialog.showDialog()
            } else {
                loadingDialog.hideDialog()
            }
        }
    }

}

