package com.example.bussinesscarduicompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bussinesscarduicompose.ui.theme.BussinessCardUiComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BussinessCardUiComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    LoadUi(
                        name = stringResource(R.string.name),
                        title = stringResource(R.string.title),
                        number = stringResource(
                            R.string.number
                        ),
                        link = stringResource(
                            R.string.link
                        ),
                        email = stringResource(R.string.email)
                    )
                }
            }
        }
    }
}

@Composable
fun LoadUi(name: String, title: String, number: String, link: String, email: String) {

    Box(
        modifier = Modifier
            .background(color = Color.Blue)
            .fillMaxHeight()
            .fillMaxWidth()
    ) {

        Column(
            modifier = Modifier
                .fillMaxHeight()

                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally
        ) {
            val image = painterResource(id = R.drawable.android_logo)
            Image(
                painter = image, contentDescription = null, modifier = Modifier
                    .fillMaxHeight(.15f)
                    .fillMaxSize(.3f)
            )
            LoadNameAndTitle(name = name, title = title)
        }

        Column(
            modifier = Modifier
                .fillMaxHeight()
                .wrapContentHeight(align = Alignment.Bottom)
                .fillMaxWidth()
        ) {

            LoadEmailLinkAndNumber(number = number, link = link, email = email)
        }


    }
}


@Composable
fun LoadNameAndTitle(name: String, title: String) {
    Text(text = name, fontSize = 36.sp, fontWeight = FontWeight.Bold, color = Color.White)
    Text(text = title, fontSize = 24.sp, color = Color.White, fontWeight = FontWeight.SemiBold)

}

@Composable
fun LoadEmailLinkAndNumber(number: String, link: String, email: String) {
    val phone = painterResource(id = R.drawable.phone_alt)
    val links = painterResource(id = R.drawable.link)
    val emails = painterResource(id = R.drawable.email)

    Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(bottom = 10.dp, top = 10.dp))
    Row(modifier = Modifier.padding(  start = 60.dp)) {
        Image(painter = phone, contentDescription = null, modifier = Modifier
            .fillMaxHeight(.033f)
            .fillMaxWidth(.08f))
        Text(text = number, fontSize = 20.sp, color = Color.White, modifier = Modifier.padding(start = 25.dp))
    }
    Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(bottom = 10.dp, top = 10.dp))
    Row(modifier = Modifier.padding(  start = 60.dp)) {
        Image(painter = links, contentDescription = null, modifier = Modifier
            .fillMaxHeight(.033f)
            .fillMaxWidth(.08f))
        Text(text = link, fontSize = 20.sp, color = Color.White, modifier = Modifier.padding(start = 25.dp))
    }
    Divider(color = Color.Gray, thickness = 1.dp, modifier = Modifier.padding(bottom = 10.dp, top = 10.dp))
    Row(modifier = Modifier.padding( bottom =  35.dp, start = 60.dp)) {
        Image(painter = emails, contentDescription = null, modifier = Modifier
            .fillMaxHeight(.033f)
            .fillMaxWidth(.08f))
        Text(text = email, fontSize = 20.sp, color = Color.White, modifier = Modifier.padding(start = 25.dp))
    }



}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BussinessCardUiComposeTheme {
        LoadUi(
            name = stringResource(id = R.string.name),
            title = stringResource(id = R.string.title),
            number = stringResource(
                id = R.string.number
            ),
            link = stringResource(
                id = R.string.link
            ),
            email = stringResource(id = R.string.email)
        )
    }
}