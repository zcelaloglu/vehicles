package com.celaloglu.zafer.features.vehicles

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.celaloglu.zafer.R
import com.celaloglu.zafer.commons.*
import com.celaloglu.zafer.models.entities.Vehicle
import kotlinx.android.synthetic.main.fragment_vehicles.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class VehiclesFragment : Fragment(R.layout.fragment_vehicles) {

    private val vehiclesViewModel by viewModel<VehiclesViewModel>()

    private val vehiclesAdapter: VehiclesAdapter by lazy {
        VehiclesAdapter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vehiclesViewModel.getVehicles()
        observeUiState()
    }

    @Suppress("UNCHECKED_CAST")
    private fun observeUiState() {
        vehiclesViewModel.uiState.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Success<*> -> {
                    val data = it.data as List<Vehicle>
                    displayVehicleResults(data)
                }
                is Error -> displayErrorState(it.error)
                is Loading -> loading_vehicles_progress_bar.show()
            }
        })
    }

    private fun displayVehicleResults(vehicles: List<Vehicle>) {
        loading_vehicles_progress_bar.hide()

        vehicles_recycler_view.apply {
            adapter = vehiclesAdapter.apply {
                submitList(vehicles)
            }
            initRecyclerViewWithLineDecoration(requireContext())
        }
        vehicles_recycler_view.show()
    }

    private fun displayErrorState(error: Throwable) {
        vehicles_recycler_view.hide()
        loading_vehicles_progress_bar.hide()
        showSnackbar(vehicles_recycler_view, "${error.message}")
    }

}