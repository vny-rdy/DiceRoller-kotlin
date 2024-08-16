package com.example.diceroller
import android.os.Bundle
import androidx.compose.foundation.layout.height
import androidx.compose.ui.unit.dp
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.diceroller.ui.theme.DiceRollerTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DiceRollerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DiceRollerApp()
                }
            }
        }
    }
}
@Preview
@Composable
fun DiceRollerApp(){
    DiceWithButtonAndImage(modifier= Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center))
}
@Composable
fun DiceWithButtonAndImage(modifier: Modifier = Modifier) {
    var result by remember {
        mutableIntStateOf(1)
    }
    val imageResource = when(result){
        1->R.drawable.one
        2->R.drawable.two
        3->R.drawable.three
        4->R.drawable.four
        5->R.drawable.five
        else->R.drawable.six
    }
    Column (
        modifier=modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(painter = painterResource(id = imageResource),
            contentDescription = result.toString()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { result=(1..6).random()}) {
            Text(stringResource(R.string.roll))
        }
    }
}