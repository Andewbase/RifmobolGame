package com.example.rifmobol2.screen.single.dialog

import androidx.annotation.StringRes

data class SingleDialogState(
    @StringRes val text: Int? = null,
    val idNext: Int? = null,
    val idReplay: Int? = null,
    val answer: Boolean = false
)