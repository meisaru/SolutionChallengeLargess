package com.example.solutonchallenge.screen

import android.content.Context
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.solutonchallenge.R
import com.example.solutonchallenge.ui.theme.primaryColor
import com.example.solutonchallenge.ui.theme.whiteBackground
import com.google.firebase.firestore.FirebaseFirestore
import android.util.Log
import android.widget.Toast
import androidx.compose.ui.platform.LocalContext


class FirestoreManager {
    private val db = FirebaseFirestore.getInstance()
    private val fireStoreManagerTag = "FirestoreManager"

    fun addUser(name: String, email: String, phone: String, password: String, context: Context) {
        val userData = hashMapOf(
            "nameValue" to name,
            "emailValue" to email,
            "phoneValue" to phone,
            "passwordValue" to password,
        )

        db.collection("users")
            .add(userData)
            .addOnSuccessListener { documentReference ->
                Toast.makeText(
                    context,
                    "Data successfully added!",
                    Toast.LENGTH_SHORT
                ).show()
                Log.d(fireStoreManagerTag, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Toast.makeText(
                    context,
                    "Data addition error: ${e.message}",
                    Toast.LENGTH_SHORT
                ).show()
                Log.w(fireStoreManagerTag, "Error adding document", e)
            }
    }
}
val firestoreManager = FirestoreManager()

@Composable
fun RegisterPage(navController : NavController, onLoginClick: () -> Unit) {

    val image = painterResource(id = R.drawable.largess)
    val eye = painterResource(id = R.drawable.password_eye)

    // Kullanıcı bilgilerini tutacak değişkenler
    val nameValue = remember { mutableStateOf("") }
    val emailValue = remember { mutableStateOf("") }
    val phoneValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val confirmPasswordValue = remember { mutableStateOf("") }

    val passwordVisibility = remember { mutableStateOf(false) }
    val confirmPasswordVisibility = remember { mutableStateOf(false) }
    val context = LocalContext.current


    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = image,
                contentDescription = "my image",
                modifier = Modifier
                    .size(200.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .aspectRatio(1.5f)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.80f)
                .clip(RoundedCornerShape(30.dp))
                .background(primaryColor)
                .padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Create An Account",
                    fontSize = 25.sp,
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.sp
                    )
                )
                Spacer(modifier = Modifier.padding(10.dp))
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    OutlinedTextField(
                        value = nameValue.value,
                        onValueChange = { nameValue.value = it },
                        label = { Text(text = "Name") },
                        placeholder = { Text(text = "Name") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.7f)
                    )
                    OutlinedTextField(
                        value = emailValue.value,
                        onValueChange = { emailValue.value = it },
                        label = { Text(text = "Email Address") },
                        placeholder = { Text(text = "Email Address") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.7f)
                    )
                    OutlinedTextField(
                        value = phoneValue.value,
                        onValueChange = { phoneValue.value = it },
                        label = { Text(text = "Phone Number") },
                        placeholder = { Text(text = "Phone Number") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.7f),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                    )
                    OutlinedTextField(
                        value = passwordValue.value,
                        onValueChange = { passwordValue.value = it },
                        label = { Text(text = "Password") },
                        placeholder = { Text(text = "Password") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.7f),
                        trailingIcon = {
                            val iconTint =
                                if (passwordVisibility.value) primaryColor else Color.Gray

                            IconButton(onClick = {
                                passwordVisibility.value = !passwordVisibility.value
                            }) {
                                Icon(
                                    painter = eye,
                                    contentDescription = "Password Eye Icon",
                                    tint = iconTint
                                )
                            }
                        },
                        visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                        else PasswordVisualTransformation()
                    )
                    OutlinedTextField(
                        value = confirmPasswordValue.value,
                        onValueChange = { confirmPasswordValue.value = it },
                        label = { Text(text = "Confirm Password") },
                        placeholder = { Text(text = "Confirm Password") },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(0.7f),
                        trailingIcon = {
                            IconButton(onClick = {
                                confirmPasswordVisibility.value =
                                    !confirmPasswordVisibility.value
                            }) {
                                Icon(
                                    painter = eye,
                                    contentDescription = "Password Eye Icon",
                                    tint = if (confirmPasswordVisibility.value) primaryColor else Color.Gray
                                )
                            }
                        },
                        visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None
                        else PasswordVisualTransformation()
                    )
                    Spacer(modifier = Modifier.padding(10.dp))

                    Button(
                        onClick = {
                            firestoreManager.addUser(
                                nameValue.value,
                                emailValue.value,
                                phoneValue.value,
                                passwordValue.value,
                                context
                            )
                            onLoginClick()
                        },
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                            .height(30.dp)
                            .background(whiteBackground)
                    ) {
                        Text(text = "Sign Up", fontSize = 10.sp)
                    }
                    Spacer(modifier = Modifier.padding(10.dp))

                    Text(
                        text = "Login Instead",
                        style = TextStyle(color = Color.White),
                        modifier = Modifier.clickable {
                            onLoginClick()
                        }
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                }
            }
        }
    }
}
