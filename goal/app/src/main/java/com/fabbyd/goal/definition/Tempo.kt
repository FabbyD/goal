package com.fabbyd.goal.definition

class Tempo(val eccentric: Int,
            val isometric: Int,
            val concentric: Int) {
    override fun toString(): String {
        return "$eccentric-$isometric-$concentric"
    }
}