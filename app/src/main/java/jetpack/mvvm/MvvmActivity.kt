package jetpack.mvvm

import android.content.Intent
import jetpack.mvvm.base.BaseVmActivity
import jetpack.mvvm.databinding.ActivityMvvmBinding
import jetpack.mvvm.viewmodel.HomeViewModel

class MvvmActivity : BaseVmActivity<ActivityMvvmBinding, HomeViewModel>() {
    override fun getBinding(): ActivityMvvmBinding {
        return ActivityMvvmBinding.inflate(layoutInflater).apply {
            viewmodel = viewModel
            lifecycleOwner = this@MvvmActivity
        }
    }

    override fun getVmClass(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun initialize() {
        viewBinding.testFragmentBtn.setOnClickListener {
            startActivity(Intent(this, ContainerActivity::class.java))
        }
    }

}