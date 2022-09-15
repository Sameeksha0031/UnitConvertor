package com.example.unitconversionapp

import android.widget.Toast

class ConversionComputation {
    fun unitConvertor(
        convertedFrom: String,
        convertedTo: String,
        enteredFirstNumber: String
    ): Double {
        val output: Double
        var enteredFirstNumber = enteredFirstNumber.toDouble()
        //val enteredNumber: Double = binding.txtNumberToBeConverted.text.toString().toDouble()
        //Toast.makeText(this, "$convertedFrom,$convertedTo", Toast.LENGTH_SHORT).show()
        if (convertedFrom == convertedTo) {
            return enteredFirstNumber
        }
        when (convertedFrom) {
            "Centimeter" -> {
                if (convertedTo == "meter") {
                    output = enteredFirstNumber / 100
                    return output
                }
                if (convertedTo == "Kilometer") {
                    output = enteredFirstNumber / 100000
                    return output
                }
            }
            "meter" -> {
                if (convertedTo == "Centimeter") {
                    output = enteredFirstNumber * 100
                    return output
                }
                if (convertedTo == "Kilometer") {
                    output = enteredFirstNumber / 1000
                    return output
                }

            }
            "Kilometer" -> {
                if (convertedTo == "Centimeter") {
                    output = enteredFirstNumber * 100000
                    return output
                }
                if (convertedTo == "meter") {
                    output = enteredFirstNumber * 1000
                    return output
                }
            }
            "Gram" -> {
                if (convertedTo == "Kilogram") {
                    output = enteredFirstNumber / 1000
                    return output
                }
                if (convertedTo == "Tonnes") {
                    output = enteredFirstNumber / 1000000
                    return output
                }
            }
            "Kilogram" -> {
                if (convertedTo == "Gram") {
                    output = enteredFirstNumber * 1000
                    return output
                }
                if (convertedTo == "Tonnes") {
                    output = enteredFirstNumber / 1000
                    return output
                }
            }
            "Tonnes" -> {
                if (convertedTo == "Gram") {
                    output = enteredFirstNumber * 1000000
                    return output
                }
                if (convertedTo == "Kilogram") {
                    output = enteredFirstNumber * 1000
                    return output
                }
            }
            "MilliLiter" -> {
                if (convertedTo == "Liter") {
                    output = enteredFirstNumber / 1000
                    return output
                }
                if (convertedTo == "Gallons") {
                    output = enteredFirstNumber / 3785
                    return output
                }
            }
            "Liter" -> {
                if (convertedTo == "MilliLiter") {
                    output = enteredFirstNumber * 1000
                    return output
                }
                if (convertedTo == "Gallons") {
                    output = enteredFirstNumber / 3.785
                    return output
                }
            }
            "Gallons" -> {
                if (convertedTo == "MilliLiter") {
                    output = enteredFirstNumber * 3785
                    return output
                }
                if (convertedTo == "Liter") {
                    output = enteredFirstNumber * 3.785
                    return output
                }
            }
        }

        return 0.0
    }

    fun evaluatingQuantity(
        spnTypOne: String,
        spnTypTwo: String,
        convertedTo: String,
        firstNumberEntered: String,
        secondNumberEntered: String
    ): Double {
        val result: Double
        when (spnTypOne) {
            "Centimeter", "meter", "Kilometer" -> {
                result = evaluatingLength(
                    spnTypOne,
                    spnTypTwo,
                    convertedTo,
                    firstNumberEntered,
                    secondNumberEntered
                )
                return result
            }
            "Gram", "Kilogram", "Tonnes" -> {
                result = evaluatingWeight(
                    spnTypOne,
                    spnTypTwo,
                    convertedTo,
                    firstNumberEntered,
                    secondNumberEntered
                )
                return result
            }
            "MilliLiter", "Liter", "Gallons" -> {
                result = evaluatingVolume(
                    spnTypOne,
                    spnTypTwo,
                    convertedTo,
                    firstNumberEntered,
                    secondNumberEntered
                )
                return result
            }
        }
        return 0.0
    }

    private fun evaluatingLength(spnTypOne: String, spnTypTwo: String, convertedTo: String,
                                 firstNumberEntered: String, secondNumberEntered: String): Double {
        var  convertedNumber : Double = 0.0
        var firstNumberEntered = firstNumberEntered.toDouble()
        var secondNumberEntered = secondNumberEntered.toDouble()
        when(spnTypOne){
            "Centimeter" ->{
                when(spnTypTwo){
                    "meter" ->{
                        when(convertedTo){
                            "Kilometer" ->{
                                convertedNumber = firstNumberEntered /100000 + secondNumberEntered / 1000
                            }
                            "meter" ->{
                                convertedNumber = firstNumberEntered / 100 + secondNumberEntered
                            }
                            "Centimeter" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered * 100
                            }
                        }
                    }
                    "Kilometer" ->{
                        when(convertedTo){
                            "meter" ->{
                                convertedNumber = firstNumberEntered / 100 + secondNumberEntered * 1000
                            }
                            "Kilometer" ->{
                                convertedNumber = firstNumberEntered / 10000 + secondNumberEntered
                            }
                            "Centimeter" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered * 10000
                            }
                        }
                    }
                    "Centimeter" ->{
                        when(convertedTo){
                            "meter" ->{
                                convertedNumber = firstNumberEntered / 100 + secondNumberEntered / 100
                            }
                            "Kilometer" ->{
                                convertedNumber = firstNumberEntered / 100000 + secondNumberEntered / 100000
                            }
                            "Centimeter" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered
                            }
                        }
                    }
                }
            }
            "meter" ->{
                when(spnTypTwo){
                    "meter" ->{
                        when(convertedTo){
                            "Kilometer" ->{
                                convertedNumber = firstNumberEntered / 1000 + secondNumberEntered / 1000
                            }
                            "meter" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered
                            }
                            "Centimeter" ->{
                                convertedNumber = (firstNumberEntered + secondNumberEntered) * 100
                            }
                        }
                    }
                    "Kilometer" ->{
                        when(convertedTo){
                            "meter" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered * 1000
                            }
                            "Kilometer" ->{
                                convertedNumber = firstNumberEntered / 1000 + secondNumberEntered
                            }
                            "Centimeter" ->{
                                convertedNumber = firstNumberEntered * 100 + secondNumberEntered * 100000
                            }
                        }
                    }
                    "Centimeter" ->{
                        when(convertedTo){
                            "meter" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered / 100
                            }
                            "Kilometer" ->{
                                convertedNumber = firstNumberEntered / 1000 + secondNumberEntered / 100
                            }
                            "Centimeter" ->{
                                convertedNumber = firstNumberEntered * 100 + secondNumberEntered
                            }
                        }
                    }
                }
            }
            "Kilometer" ->{
                when(spnTypTwo){
                    "meter" ->{
                        when(convertedTo){
                            "Kilometer" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered / 1000
                            }
                            "meter" ->{
                                convertedNumber = firstNumberEntered * 1000 + secondNumberEntered
                            }
                            "Centimeter" ->{
                                convertedNumber = firstNumberEntered / 100000 + secondNumberEntered / 100
                            }
                        }
                    }
                    "Kilometer" ->{
                        when(convertedTo){
                            "meter" ->{
                                convertedNumber = (firstNumberEntered + secondNumberEntered) * 1000
                            }
                            "Kilometer" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered
                            }
                            "Centimeter" ->{
                                convertedNumber = (firstNumberEntered + secondNumberEntered) * 100000
                            }
                        }
                    }
                    "Centimeter" ->{
                        when(convertedTo){
                            "meter" ->{
                                convertedNumber = firstNumberEntered * 1000 + secondNumberEntered / 100
                            }
                            "Kilometer" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered / 100000
                            }
                            "Centimeter" ->{
                                convertedNumber = firstNumberEntered * 100000 + secondNumberEntered
                            }
                        }
                    }
                }
            }
        }
        return convertedNumber
    }

    private fun evaluatingWeight(spnTypOne: String, spnTypTwo: String, convertedTo: String,
                                 firstNumberEntered: String, secondNumberEntered: String): Double {
        var convertedNumber : Double = 0.0
        var firstNumberEntered = firstNumberEntered.toDouble()
        var secondNumberEntered = secondNumberEntered.toDouble()
        when(spnTypOne){
            "Gram" ->{
                when(spnTypTwo){
                    "Gram"->{
                        when(convertedTo){
                            "Gram" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered
                            }
                            "Kilogram" ->{
                                convertedNumber = (firstNumberEntered + secondNumberEntered) * 1000
                            }
                            "Tonnes" ->{
                                convertedNumber = (firstNumberEntered + secondNumberEntered) * 1000000
                            }
                        }
                    }
                    "Kilogram"->{
                        when(convertedTo){
                            "Gram" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered * 1000
                            }
                            "Kilogram" ->{
                                convertedNumber = firstNumberEntered / 1000 + secondNumberEntered
                            }
                            "Tonnes" ->{
                                convertedNumber = firstNumberEntered / 100000 + secondNumberEntered /1000
                            }
                        }
                    }
                    "Tonnes"->{
                        when(convertedTo){
                            "Gram" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered * 1000000
                            }
                            "Kilogram" ->{
                                convertedNumber = firstNumberEntered / 1000 + secondNumberEntered * 1000
                            }
                            "Tonnes" ->{
                                convertedNumber = firstNumberEntered / 1000000 + secondNumberEntered
                            }
                        }
                    }
                }
            }
            "KiloGram" ->{
                when(spnTypTwo){
                    "Gram"->{
                        when(convertedTo){
                            "Gram" ->{
                                convertedNumber = firstNumberEntered * 1000 + secondNumberEntered
                            }
                            "Kilogram" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered / 1000
                            }
                            "Tonnes" ->{
                                convertedNumber = firstNumberEntered / 1000 + secondNumberEntered / 1000000
                            }
                        }
                    }
                    "Kilogram"->{
                        when(convertedTo){
                            "Gram" ->{
                                convertedNumber = (firstNumberEntered + secondNumberEntered) * 1000
                            }
                            "Kilogram" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered
                            }
                            "Tonnes" ->{
                                convertedNumber = (firstNumberEntered + secondNumberEntered) / 1000
                            }
                        }
                    }
                    "Tonnes"->{
                        when(convertedTo){
                            "Gram" ->{
                                convertedNumber = firstNumberEntered / 1000 + secondNumberEntered / 1000000
                            }
                            "Kilogram" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered * 1000
                            }
                            "Tonnes" ->{
                                convertedNumber = firstNumberEntered * 1000 + secondNumberEntered
                            }
                        }
                    }
                }
            }
            "Tonnes" ->{
                when(spnTypTwo){
                    "Gram"->{
                        when(convertedTo){
                            "Gram" ->{
                                convertedNumber = firstNumberEntered * 1000000 + secondNumberEntered
                            }
                            "Kilogram" ->{
                                convertedNumber = firstNumberEntered * 1000 + secondNumberEntered / 1000
                            }
                            "Tonnes" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered / 1000000
                            }
                        }
                    }
                    "Kilogram"->{
                        when(convertedTo){
                            "Gram" ->{
                                convertedNumber = firstNumberEntered * 1000000 + secondNumberEntered * 1000
                            }
                            "Kilogram" ->{
                                convertedNumber = firstNumberEntered * 1000 + secondNumberEntered
                            }
                            "Tonnes" ->{
                                convertedNumber = firstNumberEntered / 1000 + secondNumberEntered
                            }
                        }
                    }
                    "Tonnes"->{
                        when(convertedTo){
                            "Gram" ->{
                                convertedNumber = (firstNumberEntered + secondNumberEntered) * 1000000
                            }
                            "Kilogram" ->{
                                convertedNumber = (firstNumberEntered + secondNumberEntered) * 1000
                            }
                            "Tonnes" ->{
                                convertedNumber = (firstNumberEntered + secondNumberEntered)
                            }
                        }
                    }
                }
            }

        }
        return convertedNumber
    }

    private fun evaluatingVolume(spnTypOne: String, spnTypTwo: String, convertedTo: String,
                                 firstNumberEntered: String, secondNumberEntered: String): Double {
        var convertedNumber : Double = 0.0
        var firstNumberEntered = firstNumberEntered.toDouble()
        var secondNumberEntered = secondNumberEntered.toDouble()
        when(spnTypOne){
            "MilliLiter" -> {
                when(spnTypTwo){
                    "MilliLiter" ->{
                        when(convertedTo){
                            "MilliLiter" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered
                            }
                            "Liter" ->{
                                convertedNumber = (firstNumberEntered + secondNumberEntered) / 1000
                            }
                            "Gallons" ->{
                                convertedNumber = (firstNumberEntered + secondNumberEntered) / 3785
                            }
                        }
                    }
                    "Liter" ->{
                        when(convertedTo){
                            "MilliLiter" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered * 1000
                            }
                            "Liter" ->{
                                convertedNumber = firstNumberEntered / 1000 + secondNumberEntered
                            }
                            "Gallons" ->{
                                convertedNumber = firstNumberEntered / 3785 + secondNumberEntered / 3.785
                            }
                        }
                    }
                    "Gallons" ->{
                        when(convertedTo){
                            "MilliLiter" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered * 3785
                            }
                            "Liter" ->{
                                convertedNumber = firstNumberEntered / 1000 + secondNumberEntered * 3.785
                            }
                            "Gallons" ->{
                                convertedNumber = firstNumberEntered / 3785 + secondNumberEntered
                            }
                        }
                    }
                }
            }
            "Liter" -> {
                when(spnTypTwo){
                    "MilliLiter" ->{
                        when(convertedTo){
                            "MilliLiter" ->{
                                convertedNumber = firstNumberEntered * 1000 + secondNumberEntered
                            }
                            "Liter" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered / 1000
                            }
                            "Gallons" ->{
                                convertedNumber = firstNumberEntered / 3.785 + secondNumberEntered / 3785
                            }
                        }
                    }
                    "Liter" ->{
                        when(convertedTo){
                            "MilliLiter" ->{
                                convertedNumber = (firstNumberEntered + secondNumberEntered) * 1000
                            }
                            "Liter" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered
                            }
                            "Gallons" ->{
                                convertedNumber = (firstNumberEntered + secondNumberEntered) / 3.785
                            }
                        }
                    }
                    "Gallons" ->{
                        when(convertedTo){
                            "MilliLiter" ->{
                                convertedNumber = firstNumberEntered * 1000 + secondNumberEntered * 3785
                            }
                            "Liter" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered * 3.785
                            }
                            "Gallons" ->{
                                convertedNumber = firstNumberEntered / 3.785 + secondNumberEntered
                            }
                        }
                    }
                }
            }
            "Gallons" -> {
                when(spnTypTwo){
                    "MilliLiter" ->{
                        when(convertedTo){
                            "MilliLiter" ->{
                                convertedNumber = firstNumberEntered * 3785 + secondNumberEntered
                            }
                            "Liter" ->{
                                convertedNumber = firstNumberEntered * 3.785 + secondNumberEntered / 1000
                            }
                            "Gallons" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered / 3875
                            }
                        }
                    }
                    "Liter" ->{
                        when(convertedTo){
                            "MilliLiter" ->{
                                convertedNumber = firstNumberEntered * 3785 + secondNumberEntered * 1000
                            }
                            "Liter" ->{
                                convertedNumber = firstNumberEntered * 3.785 + secondNumberEntered
                            }
                            "Gallons" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered / 3.785
                            }
                        }
                    }
                    "Gallons" ->{
                        when(convertedTo){
                            "MilliLiter" ->{
                                convertedNumber = (firstNumberEntered + secondNumberEntered) * 3785
                            }
                            "Liter" ->{
                                convertedNumber = (firstNumberEntered + secondNumberEntered) * 3.785
                            }
                            "Gallons" ->{
                                convertedNumber = firstNumberEntered + secondNumberEntered
                            }
                        }
                    }
                }
            }
        }
        return convertedNumber
    }
}