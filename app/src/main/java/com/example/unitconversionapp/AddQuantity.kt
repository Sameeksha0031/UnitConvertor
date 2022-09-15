package com.example.unitconversionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.unitconversionapp.databinding.ActivityAddQuantityBinding
import com.example.unitconversionapp.databinding.ActivityMainBinding

class AddQuantity : AppCompatActivity() {
    lateinit var binding: ActivityAddQuantityBinding
    lateinit var firstNumberConvertedFrom: String
    lateinit var secondNumberConvertedFrom: String
    lateinit var convertedTo: String
    var conversionComputation = ConversionComputation()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_quantity)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_quantity)

        //array of measuration
        val arrayListOfParentSpinner = arrayListOf<String>("Length", "Weight", "Volume")
        val adapterViewOfParentSpinner =
            ArrayAdapter(applicationContext, R.layout.sp_parent, arrayListOfParentSpinner)
        binding.spnMeasurement.adapter = adapterViewOfParentSpinner

        //arrays for Units
        val arrayListOfLength = arrayListOf<String>("Centimeter", "meter", "Kilometer")
        val arrayListOfWeight = arrayListOf<String>("Gram", "Kilogram", "Tonnes")
        val arrayListOfVolume = arrayListOf<String>("MilliLiter", "Liter", "Gallons")

        binding.spnMeasurement.onItemSelectedListener =
            object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(
                    adapter: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    binding.txtNumberToBeConverted.text.clear()
                    binding.txtSecondNumberTobeConverted.text.clear()
                    binding.txtResult.text = "0"
                    when (position) {
                        0 -> {
                            binding.spnTypeOne.adapter =
                                ArrayAdapter(application, R.layout.sp_child, arrayListOfLength)
                            binding.spnTypeTwo.adapter =
                                ArrayAdapter(application, R.layout.sp_child, arrayListOfLength)
                            binding.spnTypeThree.adapter =
                                ArrayAdapter(application, R.layout.sp_child, arrayListOfLength)
                        }
                        1 -> {
                            binding.spnTypeOne.adapter =
                                ArrayAdapter(application, R.layout.sp_child, arrayListOfWeight)
                            binding.spnTypeTwo.adapter =
                                ArrayAdapter(application, R.layout.sp_child, arrayListOfWeight)
                            binding.spnTypeThree.adapter =
                                ArrayAdapter(application, R.layout.sp_child, arrayListOfWeight)
                        }
                        2 -> {
                            binding.spnTypeOne.adapter =
                                ArrayAdapter(application, R.layout.sp_child, arrayListOfVolume)
                            binding.spnTypeTwo.adapter =
                                ArrayAdapter(application, R.layout.sp_child, arrayListOfVolume)
                            binding.spnTypeThree.adapter =
                                ArrayAdapter(application, R.layout.sp_child, arrayListOfVolume)
                        }

                    }

                    binding.spnTypeOne.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                adapter: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                firstNumberConvertedFrom =
                                    binding.spnTypeOne.selectedItem.toString()
                            }

                            override fun onNothingSelected(p0: AdapterView<*>?) {
                                TODO("Not yet implemented")
                            }

                        }
                    binding.spnTypeTwo.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                adapter: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                secondNumberConvertedFrom =
                                    binding.spnTypeTwo.selectedItem.toString()
                            }

                            override fun onNothingSelected(p0: AdapterView<*>?) {
                                TODO("Not yet implemented")
                            }

                        }
                    binding.spnTypeThree.onItemSelectedListener =
                        object : AdapterView.OnItemSelectedListener {
                            override fun onItemSelected(
                                adapter: AdapterView<*>?,
                                view: View?,
                                position: Int,
                                id: Long
                            ) {
                                convertedTo = binding.spnTypeThree.selectedItem.toString()
                            }

                            override fun onNothingSelected(p0: AdapterView<*>?) {
                                TODO("Not yet implemented")
                            }

                        }
                    binding.btnConvertQuality.setOnClickListener {
                        var firstNumberEntered = binding.txtNumberToBeConverted.text.toString()
                        var secondNumberEntered =
                            binding.txtSecondNumberTobeConverted.text.toString()
                        if (binding.txtNumberToBeConverted.text.toString()
                                .isBlank() && secondNumberEntered.isBlank()
                        ) {
                            Toast.makeText(
                                applicationContext,
                                "Insert the value",
                                Toast.LENGTH_SHORT
                            ).show()
                            binding.txtResult.text = "0"
                        } else {
                            if (binding.txtNumberToBeConverted.text.toString().isBlank()) {
                                firstNumberEntered = "0"
                            } else if (binding.txtSecondNumberTobeConverted.text.toString()
                                    .isBlank()
                            ) {
                                secondNumberEntered = "0"
                            }
                            binding.txtResult.text =
                                conversionComputation.evaluatingQuantity(
                                    firstNumberConvertedFrom, secondNumberConvertedFrom,
                                    convertedTo, firstNumberEntered, secondNumberEntered
                                ).toString()

                        }
                    }

                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }
    }
}