package com.example.homebase.feature_shifts.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.homebase.feature_shifts.R
import com.example.homebase.feature_shifts.databinding.ActivityShiftsBinding
import com.example.homebase.feature_shifts.ui.adapter.ShiftsAdapter
import com.example.homebase.feature_shifts.ui.utils.Destination
import com.example.homebase.feature_shifts.ui.viewmodel.ShiftsViewModel
import com.example.homebase.shared.ui.adapter.VerticalSpaceItemDecoration
import com.example.homebase.shared.ui.extensions.navigateTo
import com.example.homebase.shared.ui.extensions.viewBinding
import com.example.homebase.shared.utils.EventObserver
import org.koin.androidx.viewmodel.ext.android.viewModel

class ShiftsActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityShiftsBinding::inflate)

    private val viewModel: ShiftsViewModel by viewModel()

    private val shiftsAdapter = ShiftsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupShiftList()

        setUpObservers()

        viewModel.onScreenStarted()
    }

    private fun setupShiftList() {
        binding.rvList.addItemDecoration(VerticalSpaceItemDecoration(24))
        binding.rvList.adapter = shiftsAdapter
    }

    private fun setUpObservers() {
        viewModel.navigateTo.observe(this, EventObserver {
            if (it == Destination.ADD_SHIFT) {
                navigateTo(AddShiftActivity::class.java)
            }
        })

        viewModel.shiftsList.observe(this) {
            shiftsAdapter.submitList(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_shifts, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add -> viewModel.onAddButtonClicked()
        }
        return true
    }

}