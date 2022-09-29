package jetpack.mvvm.base

import android.os.Bundle
import androidx.databinding.ViewDataBinding
import jetpack.mvvm.ContentLoadingDialog

/**
 * Description：MVVM base activity
 */
abstract class BaseVmActivity<VDB : ViewDataBinding, VM : BaseViewModel> : BaseActivity<VDB>() {
    abstract val viewModel: VM

    private val loadingDialog by lazy { ContentLoadingDialog(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addObserver()
    }

    open fun addObserver() {
        viewModel.dataLoading.observe(this) {
            if (it) {
                loadingDialog.showDialog()
            } else {
                loadingDialog.hideDialog()
            }
        }
    }

}

