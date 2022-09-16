package jetpack.mvvm.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

/**
 * Description：BaseActivity
 */
abstract class BaseActivity<VB : ViewDataBinding> : AppCompatActivity() {
    private var _viewBinding: VB? = null
    protected val viewBinding: VB
        get() = checkNotNull(_viewBinding) {
            "Activity $this viewBinding cannot be accessed"
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _viewBinding = getBinding()
        setContentView(viewBinding.root)

        initialize()
    }

    abstract fun getBinding(): VB

    open fun initialize() {

    }

}
