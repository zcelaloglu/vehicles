package com.celaloglu.zafer.features.vehicles

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.celaloglu.zafer.R
import com.celaloglu.zafer.commons.*
import com.celaloglu.zafer.models.entities.Vehicle
import kotlinx.android.synthetic.main.fragment_vehicles.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import org.koin.androidx.viewmodel.ext.android.viewModel

class VehiclesFragment : Fragment(R.layout.fragment_vehicles) {

    @ExperimentalCoroutinesApi
    private val vehiclesViewModel by viewModel<VehiclesViewModel>()

    private val vehiclesAdapter: VehiclesAdapter by lazy {
        VehiclesAdapter()
    }

    @ExperimentalCoroutinesApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        lifecycleScope.launchWhenCreated {
            vehiclesViewModel.uiState.collect { uiState ->
                when (uiState) {
                    is Success<*> -> {
                        val data = uiState.data as List<Vehicle>
                        displayVehicleResults(data)
                    }
                    is Error -> displayErrorState(uiState.error)
                    is Loading -> loading_vehicles_progress_bar.show()
                }
            }
        }

        vehiclesViewModel.getVehicles()
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