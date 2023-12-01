package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   LemonadeApp(name = getString(R.string.step1))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp(name: String, modifier: Modifier = Modifier) {
    

    val greenAscentColor = Color(0xFF69F0AE)

    var currentStep by remember {
        mutableStateOf(1)
    }
    var squeezeCount by remember {
        mutableStateOf(0)
    }

    val imageResource = when(currentStep) {
        1 -> {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ){

                Button(onClick = {
                    currentStep = 2
                    squeezeCount = (1..5).random()
                },
                    shape = RoundedCornerShape(16.dp),

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lemon_tree),
                        contentDescription = null
                    )
                }

                Spacer(
                    modifier = modifier
                        .padding(16.dp)
                )
                Text(
                    text = stringResource(id = R.string.step1),
                    fontSize = 18.sp,
                    modifier = modifier
                )
            }

        }
        2 -> {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ){
                Button(onClick = {
                    squeezeCount--
                    if(squeezeCount == 0){
                        currentStep = 3
                    }
                },
                    shape = RoundedCornerShape(16.dp),

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lemon_squeeze),
                        contentDescription = null
                    )
                }

                Spacer(
                    modifier = modifier
                        .padding(16.dp)
                )
                Text(
                    text = stringResource(id = R.string.step2),
                    fontSize = 18.sp,
                    modifier = modifier
                )
            }


        }
        3 -> {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ){
                Button(onClick = { currentStep = 4 },
                    shape = RoundedCornerShape(16.dp),
                    ) {
                    Image(
                        painter = painterResource(id = R.drawable.lemon_drink),
                        contentDescription = null
                    )
                }

                Spacer(
                    modifier = modifier
                        .padding(16.dp)
                )
                Text(
                    text = stringResource(id = R.string.step3),
                    fontSize = 18.sp,
                    modifier = modifier
                )
            }


        }
        else -> {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ){
                Button(onClick = { currentStep = 1  },
                    shape = RoundedCornerShape(16.dp),
                    ) {
                    Image(
                        painter = painterResource(id = R.drawable.lemon_restart),
                        contentDescription = null
                    )
                }

                Spacer(
                    modifier = modifier
                        .padding(16.dp)
                )
                Text(
                    text = stringResource(id = R.string.step4),
                    fontSize = 18.sp,
                    modifier = modifier
                )
            }


        }


    }


}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        LemonadeApp(name = stringResource(R.string.step1), modifier = Modifier )
    }
}