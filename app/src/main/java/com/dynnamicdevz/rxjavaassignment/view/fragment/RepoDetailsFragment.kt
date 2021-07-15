package com.dynnamicdevz.rxjavaassignment.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.dynnamicdevz.rxjavaassignment.databinding.RepoDetailsFragmentLayoutBinding
import com.dynnamicdevz.rxjavaassignment.model.data.AlexisResponseItem

class RepoDetailsFragment : Fragment() {

    companion object {

        lateinit var repoDetailsFragment: RepoDetailsFragment
        const val RESULT_KEY = "RESULT"


        fun getInstance(result: AlexisResponseItem): RepoDetailsFragment {
            if (!this::repoDetailsFragment.isInitialized)
                repoDetailsFragment = RepoDetailsFragment()
            return repoDetailsFragment.also {
                it.arguments = Bundle().also { bnd ->
                    bnd.putParcelable(RESULT_KEY, result)
                }
            }
        }

    }

    private lateinit var binding: RepoDetailsFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RepoDetailsFragmentLayoutBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getParcelable<AlexisResponseItem>(RESULT_KEY)?.let {

            binding.repoItemName.setText(it.name)
            binding.createdDateTv.setText(it.created_at)
            binding.urlTv.setText(it.archive_url)
        }
    }

}