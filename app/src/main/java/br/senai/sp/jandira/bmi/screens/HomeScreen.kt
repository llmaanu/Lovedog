package br.senai.sp.jandira.bmi.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.senai.sp.jandira.bmi.R


@Composable
fun HomeScreen(navegacao: NavHostController?) {
    val nameState = remember {
        mutableStateOf("")
    }
    var isErrorState = remember{
        mutableStateOf(false)
    }
    // abrir ou criar arquivo shared preferences
    val context = LocalContext.current
    val userFile = context
        .getSharedPreferences("userFile", Context.MODE_PRIVATE)

    // colocar arquivo em modo de edição
    val editor = userFile.edit()


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.radialGradient(
                    listOf(
                        Color(0xFFE1AABD),
                        Color(0xFFE7769C),
                        Color(0xFFDC85A2),
                        Color(0xFFE1487C),
                        Color(0xFFDA5988),
                        Color(0xFFE54881),
                        Color(0xFFDC3E78),
                        Color(0xFFD97297),

                    )
                )
            )
    ){
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(
                    R.drawable.mulheres
                ),
                contentDescription = stringResource(
                    R.string.logo
                ),
                modifier = Modifier
                    .padding(top = 90.dp)
            )
            Text(
                text = stringResource(
                    R.string.welcome
                ),
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(450.dp),
                shape = RoundedCornerShape(
                    topStart = 48.dp,
                    topEnd = 48.dp
                ),
                colors = CardDefaults
                    .cardColors(
                        contentColor = Color.Black
                )
            )  {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(32.dp),
                    horizontalAlignment = Alignment.End,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()

                    ){
                        Text (
                            text = stringResource(
                                R.string.your_name
                            ),
                            fontSize = 24.sp,
                            color = Color.Black,
                        )

                        TextField(
                            value = nameState.value,
                            onValueChange = {
                                nameState.value = it
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp),
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                capitalization = KeyboardCapitalization.Characters
                            ),
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = "",
                                    tint = Color(0xFFE11493)

                                )
                            },

                            isError = true,
                            supportingText = {
                                if (isErrorState.value){
                                    Text(
                                        text = "O nome é obrigatório!"
                                    )
                                    //trailingIcon = {
                                   // if (isErrorState.value){
                                     //   Icon(
                                       //     imageVector = Icons.Default.Error
                                       //             contentDescription = "",
                                        ///    tint = Color.Red
                                      //  )
                                    }
                            }
                        )
                    }
                    Button(
                        onClick = {
                            if(nameState.value.isEmpty()){
                                isErrorState.value = true
                            } else{
                                editor.putString("user_Name", nameState.value)
                                editor.apply()
                                navegacao?.navigate("dados")
                            }
                        },
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text(
                            text = stringResource(
                                R.string.next
                            ),
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )

                    }

                }
                }
            }
        }
    }



@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navegacao = navController)
}
