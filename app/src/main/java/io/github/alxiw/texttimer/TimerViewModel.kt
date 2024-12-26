package io.github.alxiw.texttimer

import android.os.CountDownTimer
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

private const val MAX_TIMER_COUNT_MILLIS = 1_000_000L
private const val TIMER_COUNT_DOWN_INTERVAL_MILLIS = 1_000L

class TimerViewModel : ViewModel() {

    private val maxTimerCount = MAX_TIMER_COUNT_MILLIS / TIMER_COUNT_DOWN_INTERVAL_MILLIS

    private var timerCount by mutableLongStateOf(0L)

    private val timerStateMutable = mutableStateOf(TimerState(0L, State.Stop))
    val timerState = derivedStateOf { timerStateMutable.value }

    private val timer = object: CountDownTimer(
        MAX_TIMER_COUNT_MILLIS,
        TIMER_COUNT_DOWN_INTERVAL_MILLIS
    ) {
        override fun onFinish() {
            super.cancel()
            timerStateMutable.value = TimerState(timerCount, State.Stop)
        }

        override fun onTick(millisUntilFinished: Long) {
            if (timerCount >= maxTimerCount) {
                onFinish()
            } else {
                timerCount++
                timerStateMutable.value = TimerState(timerCount, State.Run)
            }
        }
    }

    fun startTimer() {
        timer.start()
    }

    fun stopTimer() {
        timer.cancel()
        timerStateMutable.value = TimerState(timerCount, State.Stop)
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }
}

data class TimerState(val count: Long, val state: State)

sealed interface State {
    data object Run : State
    data object Stop : State
}
