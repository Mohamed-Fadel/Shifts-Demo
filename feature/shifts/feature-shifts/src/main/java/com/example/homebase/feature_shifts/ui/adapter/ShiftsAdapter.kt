package com.example.homebase.feature_shifts.ui.adapter

import android.graphics.Color
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.feature_shifts_domain.entity.Shift
import com.example.homebase.feature_shifts.databinding.ItemShiftBinding
import com.example.homebase.shared.ui.extensions.getViewBinding
import com.example.homebase.shared.utils.ext.HHmma_FORMAT

class ShiftsAdapter : ListAdapter<Shift, ShiftsAdapter.ShiftViewHolder>(
    object : DiffUtil.ItemCallback<Shift>() {

        override fun areItemsTheSame(oldItem: Shift, newItem: Shift): Boolean =
            oldItem.name == newItem.name

        override fun areContentsTheSame(oldItem: Shift, newItem: Shift): Boolean =
            oldItem == newItem
    }
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShiftViewHolder {
        return ShiftViewHolder(parent.getViewBinding(ItemShiftBinding::inflate))
    }

    override fun onBindViewHolder(holder: ShiftViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ShiftViewHolder(
        private val binding: ItemShiftBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Shift) {
            with(binding) {
                binding.tvShiftName.text = item.name
                binding.tvShiftDate.text =
                    "${item.startDate.HHmma_FORMAT} - ${item.endDate.HHmma_FORMAT}"

                binding.dayView.setDate(item.startDate)
                binding.tvShiftSubTitle.setText(item.role.resId)

                binding.btnIcon.setColorFilter(
                    Color.parseColor(item.color.hexValue),
                    android.graphics.PorterDuff.Mode.SRC_IN
                )

            }
        }
    }


}