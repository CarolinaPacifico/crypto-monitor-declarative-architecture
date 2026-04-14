package com.github.carolinapacifico

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.github.carolinapacifico.ui.theme.CryptomonitorTheme
import com.github.carolinapacifico.ui.theme.screens.CryptoMonitorScreen
import com.github.carolinapacifico.viewmodel.CryptoViewModel
import androidx.compose.material3.Surface
import androidx.activity.viewModels

/**
 * Ponto de entrada principal do aplicativo.
 *
 * Responsável por inicializar o tema visual, configurar o modo edge-to-edge
 * (tela cheia sem bordas do sistema) e entregar o controle da interface ao
 * Jetpack Compose por meio da função [CryptoMonitorScreen].
 *
 * O [CryptoViewModel] é obtido via delegação `by viewModels()`, garantindo que
 * a instância sobreviva a rotações de tela e outras recriações de Activity.
 */


class MainActivity : ComponentActivity() {
    private val viewModel: CryptoViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptomonitorTheme {
                    Surface(modifier = Modifier.fillMaxSize()) {
                        CryptoMonitorScreen(viewModel = viewModel)
                    }
                }
            }
        }
    }
