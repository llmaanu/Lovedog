package br.senai.sp.jandira.bmi.screens

import androidx.compose.ui.graphics.Color

data class Bmi(
    var bmi: Pair<String, Double>,
    var bmiColor: Color,
    var BMIState: BMIState
)
