package com.example.jetpackmessageui.ui.survey.sample

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons.Filled
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackmessageui.R

val welcomeItems = listOf(
    "World",
    "Composable"
)

val OneToThousand: List<String> = List(1000) { "$it" }

@Composable
fun WelcomeList(modifier: Modifier = Modifier, welcomeItems: List<String>) {
    LazyColumn {
        items(welcomeItems + OneToThousand) {
            Welcome(item = it)
        }
    }
}

@Composable
fun Welcome(item: String, modifier: Modifier = Modifier) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier
            .padding(vertical = 4.dp, horizontal = 8.dp)
            .background(color = Color.Black)
            .animateContentSize()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .padding(vertical = 4.dp)
        ) {
            Column(
                modifier = modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                Text(
                    text = "Welcome",
                    color = Color.White
                )

                Text(
                    text = item,
                    style = MaterialTheme.typography.headlineSmall.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                    color = Color.White
                )
            }

            /*ElevatedButton(
                onClick = {
                    isExpanded = !isExpanded
                },
                colors = ButtonColors(
                    containerColor = Color.White,
                    contentColor = Color.Black,
                    disabledContentColor = Color.LightGray,
                    disabledContainerColor = Color.LightGray
                ),
                modifier = modifier.padding(
                    horizontal = 12.dp
                )
            ) {
                Text(text = if (isExpanded) "Show Less" else "Show More")
            }*/

            IconButton(
                onClick = { isExpanded = !isExpanded }
            ) {
                Icon(
                    imageVector = if (isExpanded) Filled.ExpandLess else Filled.ExpandMore,
                    contentDescription = if (isExpanded) {
                        stringResource(R.string.show_less)
                    } else {
                        stringResource(R.string.show_more)
                    },
                    tint = MaterialTheme.colorScheme.secondary
                )
            }
        }

        if (isExpanded) {
            Text(
                text = "Lorem ipsum odor amet, consectetuer adipiscing elit. Feugiat est libero nisi maximus rhoncus duis finibus dictum. Volutpat lacinia dui tempor fames netus nullam.",
                color = Color.White,
                modifier = modifier.padding(8.dp)
            )
        }
    }
}

@Preview(
    showBackground = true,
    widthDp = 320,
    heightDp = 320,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Welcome App Dark"
)

@Preview(showBackground = true, widthDp = 320, heightDp = 320)
@Composable
fun WelcomeListPreview() {
    WelcomeList(welcomeItems = welcomeItems)
}