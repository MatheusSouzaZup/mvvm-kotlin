package br.com.zup.zupapp.view

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.zup.mvvm.viewmodel.BaseViewModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment<T : ViewDataBinding, V : BaseViewModel<*>> : Fragment() {

    protected lateinit var bind: T
    protected lateinit var viewModel: V
    protected lateinit var actViewModel: V
    protected lateinit var parentFragmentViewModel: V

    @Inject
    lateinit var viewModelProvider: ViewModelProvider.Factory

    protected abstract val fragmentLayout: Int

    protected abstract val viewModelClass: Class<V>?

    protected abstract fun init()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bind = DataBindingUtil.inflate(inflater, fragmentLayout, container, false)

        if (viewModelClass != null) {
            viewModel = ViewModelProviders.of(this, viewModelProvider).get(viewModelClass!!)

            if (activity != null) {
                actViewModel = ViewModelProviders.of(requireActivity(), viewModelProvider).get(viewModelClass!!)
            }

            if (parentFragment != null) {
                parentFragmentViewModel = ViewModelProviders.of(parentFragment!!, viewModelProvider).get(viewModelClass!!)
            }
        }
        init()
        return bind.root
    }
}
