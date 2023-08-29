package com.example.autoscout24.home.composeComponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.AsyncImage
import com.example.autoscout24.R
import com.example.autoscoutdomain.models.Car

@Composable
fun CarItem(
    carItem: Car,
    onCallClicked: (phone: String) -> Unit
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color.LightGray)
    ) {
        val (carImage, makeText, callButton, priceText, milageText) = createRefs()
        AsyncImage(model = carItem.images?.firstOrNull()?.url, contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(5.dp)
                .size(70.dp)
                .clip(RoundedCornerShape(5.dp))
                .constrainAs(carImage) {
                    start.linkTo(parent.start)
                    top.linkTo(parent.top)
                })

        Text(
            text = "${carItem.make}: ${carItem.model}" ?: "",
            color = Color.Blue,
            fontSize = 16.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .padding(5.dp)
                .constrainAs(makeText) {
                    start.linkTo(carImage.end)
                    top.linkTo(carImage.top)
                })



        Text(
            text = "${carItem.price} ${stringResource(id = R.string.currency)}",
            modifier = Modifier
                .padding(5.dp)
                .constrainAs(priceText) {
                    start.linkTo(carImage.end)
                    top.linkTo(makeText.bottom)
                })

        Text(
            text = "${carItem.mileage} ${stringResource(id = R.string.distance_unit)}",
            modifier = Modifier
                .padding(5.dp)
                .constrainAs(milageText) {
                    end.linkTo(parent.end)
                    bottom.linkTo(priceText.bottom)
                })

        if (carItem.seller != null) {
            Button(onClick = { onCallClicked(carItem.seller!!.phone) },
                modifier = Modifier
                    .clip(RectangleShape)
                    .fillMaxWidth()
                    .constrainAs(callButton) {
                        top.linkTo(carImage.bottom)
                    }) {
                Row {
                    Icon(
                        painter = painterResource(id = androidx.core.R.drawable.ic_call_answer),
                        contentDescription = null
                    )
                    Text(text = stringResource(id = R.string.call_seller))

                }

            }
        }
    }
}