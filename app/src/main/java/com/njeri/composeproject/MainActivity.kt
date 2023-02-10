package com.njeri.composeproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.njeri.composeproject.ui.theme.ComposeProjectTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeProjectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    SayHello("People")
                 BirthdayGreeting("Alright","How did I do this?")
                      ComplexBox()
                }
            }
        }
    }
}


@Composable
fun BirthdayGreeting(introduction:String,question:String){
    Column(
     modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier
                .padding(20.dp)
              .background(Color.White)
        ) {
            Text(
                text = introduction, fontWeight = FontWeight.Bold, fontSize = 40.sp,
                color = Color.Black,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
            )
            Text(
                text = question, fontSize = 36.sp, fontStyle = FontStyle.Italic,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
            )
        }


    }

}
@Composable
fun BirthdayGreetingWithImage(){

    val bgImage= painterResource(id = R.drawable.john_doe_2x)
    Box{
        Image(painter = bgImage,
            contentDescription ="birthday background image",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            contentScale = ContentScale.Crop,
           alpha = 0.5F
            )
      BirthdayGreeting("Hello","How did I do this?")
    }
  }
@Composable
fun textInColumn(introduction:String,question:String){
    Text(text = introduction, fontWeight = FontWeight.Bold ,fontSize = 40.sp,
        color= Color.Black,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
    )
    Text(text = question, fontSize = 36.sp, fontStyle= FontStyle.Italic,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
    )
}

@Composable
fun ComplexBox(){
    Column(
      Modifier.fillMaxWidth()
    ) {
        

    Row(
        Modifier.weight(1f)
    ) {
        Column(
            modifier = Modifier.weight(1f)
                .fillMaxSize()
                .background(Color.Blue),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            textInColumn(introduction = "Box1", question ="is Blue" )
        }
        Column(
            modifier = Modifier.weight(1f)
                .fillMaxSize()
                .background(Color.Green),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            textInColumn(introduction = "Box2", question ="is Green" )
        }
    }
    Row( Modifier.weight(1f)) {
        Column(  modifier = Modifier.weight(1f)
            .fillMaxSize()
            .background(Color.Red),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            textInColumn(introduction = "Box3", question ="is Red" )
        }
        Column( modifier = Modifier.weight(1f)
            .fillMaxSize()
            .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {
            textInColumn(introduction = "Box4", question ="is White" )
        }
    }
    }
}


@Preview(showBackground = true)
@Composable
fun BirthdayGreetingWithImagePreview() {
    ComposeProjectTheme {
   BirthdayGreetingWithImage()
//        ComplexBox()
    }
}