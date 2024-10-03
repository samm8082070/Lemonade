package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
            app(Modifier .fillMaxSize()
                .wrapContentSize(Alignment.Center))
            }
        }
    }
}

@Composable
fun app( modifier: Modifier = Modifier) {
    var State :Int by remember { mutableStateOf(1) }
    var image  by remember { mutableStateOf(1) }
    var image_description  by remember { mutableStateOf(1) }
    var string by remember { mutableStateOf("") }

    image = when(State){
        1 -> R.drawable.lemon_tree
        2 -> R.drawable.lemon_squeeze
        3 -> R.drawable.lemon_drink
        4 -> R.drawable.lemon_restart

        else -> {1}
    }
    image_description = when(State){
        1 -> R.string.img_1
        2 -> R.string.img_2
        3 -> R.string.img_3
        4 -> R.string.img_4

        else -> {1}
    }
    string = when (State){
        1 -> stringResource(id =R.string.String1)
        2 -> stringResource(id =R.string.String2)
        3 -> stringResource(id =R.string.String3)
        4 -> stringResource(id =R.string.String4)

        else -> {stringResource(id =R.string.String1)}

    }

    Column (modifier = modifier ,horizontalAlignment = Alignment.CenterHorizontally){
        Button(onClick = {if(State==4){State=1}
        else if(State==2){
            var x =(1..10).random()
            if(x in 2..4){State++}
        }
        else{State++} })
        {
        Image(
            painter = painterResource(id = image),
            contentDescription = stringResource(id = image_description)


        )
        }

       Spacer(modifier = Modifier .height(16.dp) )
        text(
            string = string


        )

    }

}






@Composable
fun text(string: String, modifier: Modifier = Modifier,fontSize: TextUnit = 18.sp){
    Text(
        text = string,
        fontSize = fontSize
    )
}
