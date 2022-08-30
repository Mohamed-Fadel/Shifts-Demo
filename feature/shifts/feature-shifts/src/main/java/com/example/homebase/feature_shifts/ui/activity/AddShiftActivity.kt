package com.example.homebase.feature_shifts.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.homebase.feature_shifts.databinding.ActivityAddShiftBinding
import com.example.homebase.feature_shifts.ui.extension.getSelectedItem
import com.example.homebase.feature_shifts.ui.utils.Destination
import com.example.homebase.feature_shifts.ui.viewmodel.AddShiftViewModel
import com.example.homebase.feature_shifts.ui.viewmodel.ShiftParams
import com.example.homebase.shared.ui.extensions.viewBinding
import com.example.homebase.shared.utils.EventObserver
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddShiftActivity : AppCompatActivity() {

    private val binding by viewBinding(ActivityAddShiftBinding::inflate)

    private val viewModel: AddShiftViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUpInputsObservers()

        setUpListeners()

        viewModel.navigateTo.observe(this, EventObserver {
            if (it == Destination.SHIFT_LIST) {
                onBackPressed()
            }
        })

        viewModel.successMessage.observe(this, EventObserver {
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        })

        viewModel.onScreenStarted()
    }

    private fun setUpInputsObservers() {
        viewModel.employees.observe(this) { binding.spnEmployee.setItems(it) }
        viewModel.roles.observe(this) { binding.spnRole.setItems(it) }
        viewModel.colors.observe(this) { binding.spnColor.setItems(it) }
    }

    private fun setUpListeners() {
        binding.date.setOnClickListener {
            binding.date.show(supportFragmentManager, "DATE_PICKER")
        }

        binding.time.setOnClickListener {
            binding.time.show(supportFragmentManager, "TIME_PICKER")
        }

        binding.endTime.setOnClickListener {
            binding.endTime.show(supportFragmentManager, "TIME_PICKER")
        }

        handleSubmitButton()
    }

    private fun handleSubmitButton() {
        binding.submit.setOnClickListener {
            val params = ShiftParams(
                startDate = binding.date.text.toString(),
                startTime = binding.time.text.toString(),
                endTime = binding.endTime.text.toString(),
                employee = binding.spnEmployee.getSelectedItem(),
                roleWrapper = binding.spnRole.getSelectedItem(),
                colorWrapper = binding.spnColor.getSelectedItem()
            )

            viewModel.onAddButtonClicked(params)
        }
    }
}