package br.senai.sp.jandira.bmi.calcs


import androidx.compose.ui.graphics.Color
import br.senai.sp.jandira.bmi.screens.BMIState
import br.senai.sp.jandira.bmi.screens.Bmi
import kotlin.math.pow

fun bmicalculate(weight: Int, height: Double): Bmi {
    //val bmiResult = weight / (height * height)
    val bmiResult = weight.div(height.pow(2))

    when {
        bmiResult < 18.5 ->
            return Bmi(
                bmi = Pair("", bmiResult),
                bmiColor = Color.Cyan,
                BMIState = BMIState.UNDER_WEIGHT
            )
        bmiResult >= 18.5 && bmiResult <25.0 ->
            return Bmi(
                Bmi(
                bmi = Pair("", bmiResult),
                bmiColor = Color.Green,
                BMIState = BMIState.NORMAL
                )
        bmiResult >= 25.0 && bmiResult <29.9->
        return Bmi(
            Bmi(
                bmi = Pair("", bmiResult),
                bmiColor = Color.Yellow,
                BMIState = BMIState.OVER_WEIGHT
            )
        bmiResult >= 30.0 && bmiResult <34.9>
            return Bmi(
                Bmi(
                    bmi = Pair("", bmiResult),
                    bmiColor = Color.Magenta,
                    BMIState = BMIState.OBESITY_1
                )) bmiResult >= 25.0 && bmiResult <29.9->
        return Bmi(
            Bmi(
                bmi = Pair("", bmiResult),
                bmiColor = Color.Yellow,
                BMIState = BMIState.OVER_WEIGHT
            )


    }
}