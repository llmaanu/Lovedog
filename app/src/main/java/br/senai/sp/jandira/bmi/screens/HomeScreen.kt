package br.senai.sp.jandira.bmi.screens

import android.widget.Button
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.bmi.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
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
                    R.drawable.doglover
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
                        contentColor = Color.White
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
                            .height(50.dp)
                    ){
                        Text(
                            text = stringResource(
                                R.string.your_name
                            ),
                            fontSize = 24.sp,
                            color = Color.Black,
`
                        )

                        TextField(
                            value = "",
                            onValueChange = {},
                            modifier = Modifier
                                .fillMaxWidth()
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
    HomeScreen()
}
