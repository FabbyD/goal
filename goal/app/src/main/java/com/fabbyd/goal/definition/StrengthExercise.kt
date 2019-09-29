package com.fabbyd.goal.definition

import java.time.Duration

class StrengthExercise (val load: Float,
                        val repetitions: Int,
                        val sets: Int,
                        val tempo: Tempo,
                        val rest: Duration) : Exercise