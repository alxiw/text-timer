/* While this template provides a good starting point for using Wear Compose, you can always
 * take a look at https://github.com/android/wear-os-samples/tree/main/ComposeStarter to find the
 * most up to date changes to the libraries and their usages.
 */

package io.github.alxiw.texttimer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import androidx.wear.compose.material.Button
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Text
import androidx.wear.tooling.preview.devices.WearDevices
import io.github.alxiw.texttimer.theme.TextTimerTheme
import io.github.alxiw.texttimer.tools.CountTextFormatter


class TimerActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        setTheme(android.R.style.Theme_DeviceDefault)
        setContent {
            WearApp()
        }
    }
}

@Composable
fun WearApp(viewModel: TimerViewModel = viewModel()) {
    val res = LocalContext.current.resources
    val countTextFormatter = CountTextFormatter(res)
    TextTimerTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = countTextFormatter
                        .formatCountToText(viewModel.timerState.value.count.toInt())
                        .trim(),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 0.dp, top = 0.dp, end = 0.dp, bottom = 4.dp),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.primary
                )
                Button(onClick = {
                    when (viewModel.timerState.value.state) {
                        State.Run -> viewModel.stopTimer()
                        State.Stop -> viewModel.startTimer()
                    }
                }) {
                    Text(text = when (viewModel.timerState.value.state) {
                        State.Run -> res.getString(R.string.stop)
                        State.Stop -> res.getString(R.string.start)
                    })
                }
            }
        }
    }
}

@Preview(device = WearDevices.SMALL_ROUND, showSystemUi = true)
@Composable
fun DefaultPreview() {
    WearApp()
}

@Composable
private fun viewModel(): TimerViewModel {
    val context = LocalContext.current
    val viewModel = ViewModelProvider(context as ViewModelStoreOwner)[TimerViewModel::class.java]
    return viewModel
}
