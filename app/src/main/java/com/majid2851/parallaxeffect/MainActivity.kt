package com.majid2851.parallaxeffect

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.majid2851.parallaxeffect.ui.theme.ParallaxEffectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ParallaxEffectTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                     Parallex()
                }
            }
        }
    }
}

@Composable
fun Parallex()
{
    val scrollState= rememberScrollState()
    Box()
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
        )
        {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
                    .graphicsLayer {
                       alpha=1-(scrollState.value.toFloat()/scrollState.maxValue.toFloat())
                        translationY=0.5f*scrollState.value
                    }
                ,
                contentAlignment = Alignment.Center
            )
            {
                Image(
                    painter = painterResource(id = R.drawable.img3),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }
            Text(
                text = title,
                modifier =  Modifier.padding(8.dp),
                style = MaterialTheme.typography.titleSmall
            )

            Text(
                text = desc,
                modifier =  Modifier.padding(8.dp),
                style = MaterialTheme.typography.bodySmall
            )

        }

    }



}
