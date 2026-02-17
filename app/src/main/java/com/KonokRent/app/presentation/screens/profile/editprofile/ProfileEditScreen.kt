package com.KonokRent.app.presentation.screens.profile.editprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.KonokRent.app.presentation.theme.AirbnbCloneTheme
import com.airbnbclone.app.R
import com.airbnbclone.app.presentation.theme.AppColors


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileEditScreen() {
    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.ornament_prifile_backgraund),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            contentScale = ContentScale.FillWidth
        )
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(108.dp))  // отступ под орнамент + кнопки

            CardWithAvatarAndForm()
        }
    }
}

@Composable
fun CardWithAvatarAndForm() {
    val avatarSize = 96.dp
    val overlap = 2.dp

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 22.dp),
        shape = RoundedCornerShape(topStart = 22.dp, topEnd = 22.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Box {
            Image(
                painter = painterResource(R.drawable.profile_edit_background),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(520.dp),
                contentScale = ContentScale.FillWidth
            )

            Box(
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .offset(y = -overlap)
                    .size(avatarSize)
                    .clip(CircleShape)
                    .background(AppColors.LightGrey)
                    .border(2.dp, Color.Transparent, CircleShape)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 140.dp)
                    .padding(horizontal = 24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Выбрать фотографию",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )

                Spacer(modifier = Modifier.height(24.dp))

                OutlinedTextField(
                    value = "Аскарбеков Марлен",
                    onValueChange = {},
                    label = { Text("Полное имя") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                OutlinedTextField(
                    value = "marlen.askarbekov@gmail.com",
                    onValueChange = {},
                    label = { Text("E-mail") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    OutlinedTextField(value = "+996", onValueChange = {}, modifier = Modifier.width(80.dp))
                    Spacer(modifier = Modifier.width(8.dp))
                    OutlinedTextField(value = "701 392 423", onValueChange = {}, modifier = Modifier.weight(1f))
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected = false, onClick = {})
                        Text("Женский")
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected = true, onClick = {})
                        Text("Мужской")
                    }
                }

            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun ProfileEditScreenPreview() {
    AirbnbCloneTheme {
        ProfileEditScreen(


        )
    }
}
