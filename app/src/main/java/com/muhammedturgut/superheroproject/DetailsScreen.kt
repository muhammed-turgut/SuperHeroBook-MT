package com.muhammedturgut.superheroproject

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailsScreen(superHero: SuperHero){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.White),
        contentAlignment = Alignment.Center)
    {
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painterResource(superHero.image), contentDescription = null, modifier = Modifier.padding(start = 16.dp, end = 16.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)) {
                Text(text = "Hero Name",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp))

                Text(text = superHero.name,
                    fontSize = 24.sp)
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)) {
                Text(text = "Cinematic Universe",
                    fontSize = 20.sp,
                    color = Color.Black ,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(top = 8.dp))

                Text(text = superHero.univerese,
                    fontSize = 24.sp)
            }


            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.height(200.dp).padding(top = 16.dp, bottom = 8.dp)) {
                Text(text = "About the Hero", modifier = Modifier.padding(top = 8.dp),
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )

                val scrollState = rememberScrollState()
                Text(text = superHero.About, modifier = Modifier.padding(start = 16.dp,end=16.dp). verticalScroll(state = scrollState),
                    fontSize = 16.sp)
            }

            Column (horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)){
                Text(text = "Movies",
                    fontSize = 20.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold)

                Text(text = superHero.Movis,
                    fontSize = 18.sp)
            }

        }

    }
}
