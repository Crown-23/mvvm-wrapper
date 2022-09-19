package jetpack.mvvm.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

/**
 * Description：BaseActivity
 */
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {
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
