package com.cs2340.binarybros.buzztracker.Models;
import com.google.common.truth.Truth.assertThat;
import org.junit.Test;

public class ValidEmailTest {
    @Test
    public void emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertThat(EmailValidator.isValidEmail("name@email.com")).isTrue();
    }
}
