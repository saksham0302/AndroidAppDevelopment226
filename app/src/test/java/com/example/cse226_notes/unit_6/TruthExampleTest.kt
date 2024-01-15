package com.example.cse226_notes.unit_6

import com.google.common.truth.Truth.assertThat
import org.junit.Test

class TruthExampleTest {

    @Test
    fun `fun empty returns false`() {

        val result = TruthExample.validRegistrationInput(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `username and correctly repeated password returns true`() {

        val result = TruthExample.validRegistrationInput(
            "Rahul",
            "123",
            "123"
        )
        assertThat(result).isTrue()
    }

    @Test
    fun `incorrect confirm password return false`() {

        val result = TruthExample.validRegistrationInput(
            "Rahul",
            "123",
            "1234"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `less than two digit password return false`() {

        val result = TruthExample.validRegistrationInput(
            "Rahul",
            "abcd1",
            "abcd1"
        )
        assertThat(result).isFalse()
    }
}