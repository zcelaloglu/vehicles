package com.celaloglu.zafer.features.vehicles;

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.celaloglu.zafer.databinding.AdvertisementItemBinding
import com.celaloglu.zafer.databinding.VehicleItemBinding
import com.celaloglu.zafer.features.viewstates.VehicleEntityViewState
import com.celaloglu.zafer.models.entities.Vehicle

class VehiclesAdapter : ListAdapter<Vehicle, RecyclerView.ViewHolder>(VehiclesDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        val context = parent.context
        val inflater = LayoutInflater.from(context)

        /**
         * I always prefer to create UI layer programmatically here in case of there is a dynamic
         * content(images in this case) comes from remote data source but I created 5 ImageView declaratively
         * because of there are only 5 static contents in response
         */
        return when (viewType) {
            ItemType.VEHICLE.ordinal -> VehicleViewHolder(
                VehicleItemBinding.inflate(
                    inflater,
                    parent,
                    false
                )
            )
            ItemType.ADVERTISEMENT.ordinal -> AdvertisementViewHolder(
                AdvertisementItemBinding.inflate(inflater, parent, false)
            )
            else -> {
                throw IllegalAccessException("wrong item view type")
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int): Unit =
        getItem(position).let {
            if (holder is VehicleViewHolder) {
                holder.bind(it)
            } else if (holder is AdvertisementViewHolder) {
                holder.bind()
            }
        }

    inner class VehicleViewHolder(private val binding: VehicleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(vehicle: Vehicle) {
            with(binding) {
                viewState = VehicleEntityViewState(vehicle)
                executePendingBindings()
            }
        }
    }

    inner class AdvertisementViewHolder(private val binding: AdvertisementItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            binding.executePendingBindings()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if ((position + 1) % 3 == 0) {
            ItemType.ADVERTISEMENT.ordinal
        } else {
            ItemType.VEHICLE.ordinal
        }
    }

    enum class ItemType {
        VEHICLE,
        ADVERTISEMENT
    }

    companion object {
        val VehiclesDiffUtil =
            object : DiffUtil.ItemCallback<Vehicle>() {
                override fun areItemsTheSame(
                    oldItem: Vehicle,
                    newItem: Vehicle
                ): Boolean = oldItem.id == newItem.id

                override fun areContentsTheSame(
                    oldItem: Vehicle,
                    newItem: Vehicle
                ): Boolean = oldItem == newItem

            }
    }
}