package com.example.unitconversionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.unitconversionapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var initialUnit: String
    lateinit var conversionUnit: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

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
                    adapterView: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    Toast.makeText(
                        this@MainActivity, "You selected" + " ${
                            adapterView?.getItemAtPosition(position)
                                .toString()
                        }", Toast.LENGTH_SHORT
                    ).show()
                    when (position) {

                        0 -> {
                            binding.spnTypeOne.adapter =
                                ArrayAdapter(
                                    applicationContext,
                                    R.layout.sp_child,
                                    arrayListOfLength
                                )
                            binding.spnTypeTwo.adapter =
                                ArrayAdapter(
                                    applicationContext,
                                    R.layout.sp_child,
                                    arrayListOfLength
                                )
                            initialUnit = binding.spnTypeOne.selectedItem.toString()
                            conversionUnit = binding.spnTypeTwo.selectedItem.toString()
                            binding.btnConvertQuality.setOnClickListener {
                                binding.txtResult.text =
                                    "${unitConvertor(initialUnit, conversionUnit)}"
                            }

                        }

                        1 -> {
                            binding.spnTypeOne.adapter =
                                ArrayAdapter(
                                    applicationContext,
                                    R.layout.sp_child,
                                    arrayListOfWeight
                                )
                            binding.spnTypeTwo.adapter =
                                ArrayAdapter(
                                    applicationContext,
                                    R.layout.sp_child,
                                    arrayListOfWeight
                                )
                        }

                        2 -> {
                            binding.spnTypeOne.adapter =
                                ArrayAdapter(
                                    applicationContext,
                                    R.layout.sp_child,
                                    arrayListOfVolume
                                )
                            binding.spnTypeTwo.adapter =
                                ArrayAdapter(
                                    applicationContext,
                                    R.layout.sp_child,
                                    arrayListOfVolume
                                )
                        }

                    }
                }

                override fun onNothingSelected(p0: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }
            }

    }

    fun unitConvertor(initialUnit: String, conversionUnit: String): Double {
        var output: Double = 0.0

        var enteredNumber: Double = binding.txtNumberToBeConverted.text.toString().toDouble()
        Toast.makeText(this,"$initialUnit,$conversionUnit",Toast.LENGTH_SHORT).show()
        if (initialUnit.equals("Centimeter") && conversionUnit.equals("Centimeter")) {
            output = enteredNumber * 100
            Toast.makeText(this,"hi",Toast.LENGTH_SHORT).show()
        }
        return output
    }

}