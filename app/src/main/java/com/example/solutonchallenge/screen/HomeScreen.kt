package com.example.solutonchallenge.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.solutonchallenge.R
import com.example.solutonchallenge.ui.theme.backgroundColor
import com.example.solutonchallenge.ui.theme.primaryColor
import com.example.solutonchallenge.ui.theme.whiteBackground



@Composable
fun HomePage() {
    var selectedTab by remember { mutableStateOf(0) }
    val home1 = painterResource(id = R.drawable.home1)
    val search1 = painterResource(id = R.drawable.search1)
    val profil1 = painterResource(id = R.drawable.profil1)
    val message1 = painterResource(id = R.drawable.message1)
    val add1 = painterResource(id = R.drawable.add1)



        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                .background(backgroundColor)
        ) {
            Spacer(modifier = Modifier.padding(5.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(4.dp)
                    .background(primaryColor)
                    .padding(8.dp)


            ) {
                Text(
                    text = "Largess",
                    textAlign = TextAlign.Center,
                    color = whiteBackground,
                    style = TextStyle(
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 2.sp),
                    fontSize = 20.sp
                )

            }

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxSize()


            ) {
                BottomNavigation(

                    modifier = Modifier
                        .height(94.dp)
                        .fillMaxWidth()
                        .padding(4.dp)
                        .align(Alignment.Bottom)
                        .background(colors.primary)

                ) {
                    BottomNavigationItem(
                        selected = selectedTab == 0,
                        onClick = { selectedTab = 0 },
                        icon = {
                            Image(
                                contentDescription = "Home Icon",
                                painter = home1 ,
                                modifier = Modifier
                                    .size(54.dp, 54.dp),
                            )

                        },
                        label = { Text("Home") }
                    )

                    BottomNavigationItem(
                        selected = selectedTab == 1,
                        onClick = { selectedTab = 1 },
                        icon = {
                            Image(
                                contentDescription = "Search Icon",
                                painter = search1,
                                modifier = Modifier
                                    .size(54.dp, 54.dp)
                            )
                        },
                        label = { Text("Search") }
                    )
                    BottomNavigationItem(
                        selected = selectedTab == 3,
                        onClick = { selectedTab = 3 },
                        icon = {
                            Image(
                                contentDescription = "Photografy Add Icon",
                                painter = add1,
                                modifier = Modifier
                                    .size(54.dp, 54.dp)
                            )
                        },
                        label = { Text("Add") }
                    )


                    BottomNavigationItem(
                        selected = selectedTab == 2,
                        onClick = { selectedTab = 2 },
                        icon = {
                            Image(
                                contentDescription = "Message Icon",
                                painter = message1 ,
                                modifier = Modifier
                                    .size(54.dp, 54.dp)
                            )
                        },
                        label = { Text("Profile") }
                    )

                    BottomNavigationItem(
                        selected = selectedTab == 3,
                        onClick = { selectedTab = 3 },
                        icon = {
                            Image(
                                contentDescription = "Profile Icon",
                                painter = profil1,
                                modifier = Modifier
                                    .size(54.dp, 54.dp)
                            )
                        },
                        label = { Text("Settings") }
                    )

                }
            }
        }
    }



































