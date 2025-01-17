import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class GreetingViewModel : ViewModel() {

    // 用來儲存問候語的 StateFlow
    private val _greetingMessage = MutableStateFlow("Hello, World!")
    val greetingMessage: StateFlow<String> = _greetingMessage

    fun updateGreeting(newGreeting: String) {
        _greetingMessage.value = newGreeting
    }
}
