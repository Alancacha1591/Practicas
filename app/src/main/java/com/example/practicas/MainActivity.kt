package com.example.practicas
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicas.ui.theme.PracticasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val focusManager = LocalFocusManager.current
                    val items = listOf(
                        Color.Blue,
                        Color.Black,
                        Color.Cyan,
                        Color.Yellow,
                        Color.Red,
                        Color.Gray,
                        Color.Green,
                        Color.DarkGray,
                        Color.Magenta
                    )
                    MainScreen(items)
                }
            }
        }
    }
}

@Composable
fun MainScreen(items : List<Color>) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row() {
            Image(
                painter = painterResource(id = R.drawable.itl),
                contentDescription = null
            )
        }
        Row(){
            Texto("Clorox",
                Color.Blue,
                Color.White)
            Spacer(modifier = Modifier.padding(10.dp))
            Texto ("Precio",
                Color.Red,
                Color.White)
        }
        Spacer(modifier = Modifier.padding(20.dp))
        LazyRow() {
            items(items.size) {index->
                for (item in items) {
                    Circulo(item)
                }
            }
        }
    }
}

@Composable
fun Texto(texto:String, fondo: Color,
          colorLetra: Color){
    Text(
        text=texto,
        color=colorLetra,
        fontSize=70.sp,
        modifier= Modifier
            .background(fondo)
    )
}

@Composable
fun Circulo(color:Color){
    Box(
        modifier= Modifier
            .background(color, shape = CircleShape)
            .size(70.dp)

    )
}