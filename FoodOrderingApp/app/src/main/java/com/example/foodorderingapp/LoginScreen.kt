package com.example.foodorderingapp

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.foodorderingapp.ui.theme.FoodOrderingAppTheme
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

class LoginScreen : ComponentActivity() {
}

@Composable
fun LoginScreenComponent(navController : NavController,viewModel: LoginScreenViewModel = LoginScreenViewModel()){

    val userName by viewModel.userName.observeAsState(initial = "")

    val password by viewModel.password.observeAsState(initial = "")

    val loginStatus by viewModel.loginStatus.observeAsState(initial = "")

    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

        Image(painter = painterResource(id = R.drawable.splashscreen),
            contentDescription = "splash screen image",
            alignment = Alignment.Center,
            modifier = Modifier.padding(0.dp,100.dp,0.dp,0.dp))

        Text(text = "Waves Of Food",
            color = Color.Black,
            fontSize = 40.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(0.dp,40.dp,0.dp,0.dp))

        Text(text = "Deliver Favorite Food",
            color = colorResource(id = R.color.GradientGreen),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(0.dp,40.dp,0.dp,0.dp))

        Text(text = "Login To Your Account",
            color = colorResource(id = R.color.GradientGreen),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(0.dp,40.dp,0.dp,0.dp))

        OutlinedTextField(value = userName, onValueChange = { viewModel.onUserNameUpdate(it)}, label = { Text(text = "User Name")})

        Spacer(modifier = Modifier.padding(0.dp,10.dp,0.dp,0.dp))

        OutlinedTextField(value = password, onValueChange = { viewModel.onPasswordUpdate(it)},
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            label = { Text(text = "Password")})

        Button(colors = ButtonColors(containerColor = colorResource(id = R.color.GradientGreen),
            contentColor = colorResource(id = R.color.white),
            disabledContentColor = colorResource(id = R.color.GradientGreen),
            disabledContainerColor = colorResource(id = R.color.GradientGreen) ),
            onClick = { validate(navController,viewModel,userName,password) },modifier = Modifier
                .padding(0.dp, 100.dp, 0.dp, 0.dp)) {
            Text(text = "Submit",
                color = colorResource(id = R.color.white),
                fontSize = 20.sp)
        }

        TextButton(
            onClick = { navController.navigate(Routes.signUpScreen) },modifier = Modifier
                .padding(0.dp, 0.dp, 0.dp, 0.dp)) {
            Text(text = "Don't Have Account?",
                color = colorResource(id = R.color.GradientGreen),
                fontSize = 10.sp)
        }

        Text(text = loginStatus,
            color = colorResource(id = R.color.GradientGreen),
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(0.dp,40.dp,0.dp,0.dp))

        Text(text = "Design By \n Praveen Sulegaon",
            color = colorResource(id = R.color.GradientGreen),
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(0.dp,40.dp,0.dp,0.dp))
    }
}

private fun validate(navController: NavController,viewModel: LoginScreenViewModel,username : String, password : String) {

        FirebaseDatabaseProvider.ValidateUser(navController,viewModel,username, password)

}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()
    FoodOrderingAppTheme {
        LoginScreenComponent(navController)
    }
}