package com.example.solutonchallenge.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.solutonchallenge.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.example.solutonchallenge.ui.theme.primaryColor
import com.example.solutonchallenge.ui.theme.whiteBackground


@Composable
fun LoginPage(navController: NavController, onSignUpClick: () -> Unit, onLoginClick: () -> Unit) {

    val image = painterResource(id = R.drawable.largess)

    val passwordValue = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }
    val focusRequester = remember { FocusRequester() }


    Box(
        modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White), contentAlignment = Alignment.TopCenter
        ) {

            Image(
                painter = image,
                contentDescription = "my image",
                modifier = Modifier
                    .size(375.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .aspectRatio(1.5f)
            )

        }


        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
                .clip(RoundedCornerShape(30.dp))
                .background(primaryColor)
                .padding(30.dp)
        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Sign In",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp
                    ),
                    fontSize = 30.sp
                )
                Spacer(modifier = Modifier.padding(20.dp))

                var email by rememberSaveable { mutableStateOf("") }

                Box(
                    modifier = Modifier
                        .background(whiteBackground)
                ) {
                    OutlinedTextField(
                        value = email,
                        onValueChange = { email = it },
                        label = { Text("Email Address") },
                        placeholder = { Text(text = "Email Adress") },
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .focusRequester(focusRequester = focusRequester),
                    )
                }
                Spacer(modifier = Modifier.padding(10.dp))

                Box(
                    modifier = Modifier
                        .background(whiteBackground)
                ) {

                    OutlinedTextField(
                        value = passwordValue.value,
                        onValueChange = { passwordValue.value = it },
                        label = { Text(text = "Password") },
                        placeholder = { Text(text = "Password") },
                        singleLine = true,
                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                        modifier = Modifier
                            .fillMaxWidth(0.8f)
                            .focusRequester(focusRequester = focusRequester),
                    )
                }
                Spacer(modifier = Modifier.padding(10.dp))

                Button(
                    onClick = {
                              onLoginClick()
                              navController.navigate("home")

                    },
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(40.dp)

                ) {
                    Text(text = "Sign In",
                         fontSize = 20.sp,
                    )
                }

                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "Create An Account",
                    color = Color.White,
                    fontSize = 20.sp,
                    style = TextStyle(fontWeight = FontWeight.Black),
                            modifier = Modifier.clickable{
                                onSignUpClick()
                            }
                )


                Spacer(modifier = Modifier.padding(10.dp))


            }
          }
       }
    }









