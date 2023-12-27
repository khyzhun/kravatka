package com.khyzhun.kravatka.core.base.common.events

import com.khyzhun.kravatka.core.base.common.uidata.ProgressData

data class EventState<P : Progress, D : Dialog>(
    val progress: ProgressData<P>? = null,
    val dialog: D? = null
)

interface Progress
interface Dialog
interface Message
interface Callback

interface UiEvent
