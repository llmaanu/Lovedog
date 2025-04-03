package br.senai.sp.jandira.bmi

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.bmi.screens.HomeScreen
import br.senai.sp.jandira.bmi.screens.ResultBMI
import br.senai.sp.jandira.bmi.screens.UserDataScreen
import br.senai.sp.jandira.bmi.ui.theme.BMITheme


class MainActivity() : ComponentActivity(), Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<MainActivity> {
        override fun createFromParcel(parcel: Parcel): MainActivity {
            return MainActivity(parcel)
        }

        override fun newArray(size: Int): Array<MainActivity?> {
            return arrayOfNulls(size)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BMITheme {
                val navegacao = rememberNavController()


                NavHost(
                    navController = navegacao,
                    startDestination = "home"
                ) {
                    composable(route = "home") { HomeScreen(navegacao) }
                    composable(route = "dados") { UserDataScreen(navegacao) }
                    composable(route = "result") {
                        Box {
                            ResultBMI(navegacao)
                        }

                    }
                }
            }
        }
    }
}


