package com.example.solutonchallenge


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.solutonchallenge.ui.theme.SolutıonChallengeTheme
import androidx.navigation.compose.*
import com.example.solutonchallenge.screen.HomePage
import com.example.solutonchallenge.screen.LoginPage
import com.example.solutonchallenge.screen.RegisterPage



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SolutıonChallengeTheme{
                     App()

                }
            }
        }
    }
@Composable
fun App(){
    var currentScreen by remember { mutableStateOf("login") }
    val navController = rememberNavController()
     NavHost(
         navController = navController, startDestination = "login"){
                composable("login") {
                    LoginPage(navController = navController,
                        onLoginClick = {
                            currentScreen = "home"
                            navController.navigate("home")
                        },
                        onSignUpClick ={
                        currentScreen = "register"
                        navController.navigate("register")
                    }
                    )
                }
         composable("register") {
             RegisterPage(navController = navController,
                 onLoginClick = {
                     currentScreen = "login"
                     navController.navigate("login")
                 }
             )
         }
         composable("home") {
             HomePage()

         }


     }


}





