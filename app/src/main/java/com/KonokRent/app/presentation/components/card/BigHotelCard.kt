package com.KonokRent.app.presentation.components.card

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.KonokRent.app.domain.models.Hotel
import com.airbnbclone.app.R

@Composable
fun BigHotelCard(hotel: Hotel, onFavoriteClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(155.dp)
                    .padding(6.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFD9D9D9))
            ) {
                IconButton(
                    onClick = onFavoriteClick,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp)
                        .background(Color.Black.copy(alpha = 0.3f), CircleShape)
                        .size(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.FavoriteBorder,
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 6.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = hotel.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
                RatingTag(hotel, false)
            }

            Text(
                text = "2 кровати • 2 спальни • 1 ванная", //  надо стрингу продумать надо вместе порешать
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 6.dp, vertical = 4.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                LocationTag(hotel.please)

                PriceTag(hotel.price, 2)
            }
        }
    }
}

@Composable
fun VerticalLargeHotelCard(hotel: Hotel, onFavoriteClick: () -> Unit) {
    Column(modifier = Modifier.width(204.dp)) {
        HotelImageHeader(hotel.photo){}
        Column(modifier = Modifier.padding(12.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "${hotel.city}, ${hotel.name}",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.titleMedium
                )
                RatingTag(hotel, false)
            }
            Text(
                "2 кровати • 2 спальни • 1 ванная",
                color = Color.Gray,
                style = MaterialTheme.typography.bodySmall
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                LocationTag(hotel.please)
                PriceTag(hotel.price, 2)
            }
        }
    }
}

@Composable
fun LocationTag(distance: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(R.drawable.ic_map_point),
            contentDescription = null,
            modifier = Modifier.size(16.dp)
        )
        Text(
            modifier = Modifier.padding(start = 8.dp),
            text = "${distance}м",
            style = MaterialTheme.typography.bodySmall,
            color = Color.Gray
        )
    }
}

@Composable
fun PriceTag(price: Int, nightCount: Int) {
    Text(buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        ) {
            append("${price}с ")
        }
        withStyle(style = SpanStyle(color = Color.Gray, fontSize = 14.sp)) {
            append("/ $nightCount дня") //  надо стрингу продумать надо вместе порешать
        }
    })
}

@Composable
fun HotelImageHeader(photo: String, onFavoriteClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(125.dp)
            .padding(6.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0xFFD9D9D9))
    ) {
        IconButton(
            onClick = onFavoriteClick,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
                .background(Color.Black.copy(alpha = 0.3f), CircleShape)
                .size(32.dp)
        ) {
            Icon(
                imageVector = Icons.Default.FavoriteBorder,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(18.dp)
            )
        }
    }
}

@Composable
fun RatingTag(hotel: Hotel, isFull: Boolean) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            painter = painterResource(R.drawable.star),
            contentDescription = null,
            tint = Color(0xFFFFC508),
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = if (isFull) "${hotel.rating} (${hotel.feedbacksCount})" else "${hotel.rating}",
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Composable
fun HorizontalHotelCard(hotel: Hotel, onFavoriteClick: () -> Unit) {
    Row(modifier = Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color.LightGray)
        )
        Column(
            modifier = Modifier
                .padding(start = 12.dp)
                .weight(1f)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(hotel.name, fontWeight = FontWeight.Bold)
                Icon(
                    Icons.Default.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier
                        .size(20.dp)
                        .clickable { onFavoriteClick() })
            }
            Text(
                "В ней есть всё необходимое...",
                maxLines = 1,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
            Text(
                "2 кровати • 2 спальни",
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray
            )
            PriceTag(hotel.price, 2)
        }
    }
}

@Composable
fun CompactHotelCard(hotel: Hotel, onFavoriteClick: () -> Unit) {
    Column(modifier = Modifier.width(204.dp)) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .background(Color.LightGray)
        )
        Badge(modifier = Modifier.padding(8.dp)) { Text("Выбор гостей", fontSize = 10.sp) }
    }
    Column(modifier = Modifier.padding(8.dp)) {
        Text(hotel.name, fontWeight = FontWeight.SemiBold, maxLines = 1)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text("${hotel.price}с", fontWeight = FontWeight.Bold)
            Text(" за 2 ночи • ", fontSize = 10.sp, color = Color.Gray)
            Icon(
                Icons.Default.Star,
                null,
                tint = Color(0xFFFFC508),
                modifier = Modifier.size(12.dp)
            )
            Text(hotel.rating.toString(), fontSize = 10.sp)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BigHotelCardPreview() {
    BigHotelCard(
        Hotel(
            id = "ss",
            name = "Inter Hotel",
            city = "Бишкек",
            rating = 4.9,
            feedbacksCount = 20,
            price = 2620,
            please = 200,
            betsCount = 2,
            roomsCount = 2,
            bathCount = 2,
            photo = ""
        )
    ) {}
}

@Preview(showBackground = true)
@Composable
fun VerticalLargeHotelCardPreview() {
    VerticalLargeHotelCard(
        Hotel(
            id = "ss",
            name = "Inter Hotel",
            city = "Бишкек",
            rating = 4.9,
            feedbacksCount = 20,
            price = 2620,
            please = 200,
            betsCount = 2,
            roomsCount = 2,
            bathCount = 2,
            photo = ""
        )
    ) {}
}

@Preview(showBackground = true)
@Composable
fun HorizontalHotelCardPreview() {
    HorizontalHotelCard(
        Hotel(
            id = "ss",
            name = "Inter Hotel",
            city = "Бишкек",
            rating = 4.9,
            feedbacksCount = 20,
            price = 2620,
            please = 200,
            betsCount = 2,
            roomsCount = 2,
            bathCount = 2,
            photo = ""
        )
    ) {}
}

@Preview(showBackground = true)
@Composable
fun CompactHotelCardPreview() {
    CompactHotelCard(
        Hotel(
            id = "ss",
            name = "Inter Hotel",
            city = "Бишкек",
            rating = 4.9,
            feedbacksCount = 20,
            price = 2620,
            please = 200,
            betsCount = 2,
            roomsCount = 2,
            bathCount = 2,
            photo = ""
        )
    ) {}
}

