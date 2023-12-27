package com.khyzhun.kravatka.core.base.common.uidata

import com.khyzhun.kravatka.core.base.common.events.Progress

data class ProgressData<P : Progress>(
    val progress: P? = null
)
