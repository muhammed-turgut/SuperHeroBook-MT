package com.muhammedturgut.superheroproject

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.gson.Gson

@Composable
fun SuperHeroList(superheros: List<SuperHero>, navController: NavController) {
    LazyColumn(
        contentPadding = PaddingValues(8.dp),
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        items(superheros) {
            SuperHeroRow(superHero = it, navController = navController)
            Spacer(modifier = Modifier.height(6.dp))
        }
    }
}

@Composable
fun SuperHeroRow(superHero: SuperHero, navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                navController.navigate("details_Screen/${Gson().toJson(superHero)}")
            }
            .clip(RoundedCornerShape(12.dp))
            .background(if (superHero.univerese == "DC") Color.Blue else Color.Red)
            .padding(start = 8.dp)
    ){

        Text(
            superHero.name,
            modifier = Modifier.padding(top=8.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color.White
        )

        Text(
            superHero.univerese,
            modifier = Modifier.padding(top=4.dp, bottom = 8.dp),
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp,
            color = Color.Whitegit
        )
    }
}