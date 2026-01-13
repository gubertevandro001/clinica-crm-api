package com.gpa.clinica.crm.domain.util;

import com.gpa.clinica.crm.domain.exception.ExtracaoTextoException;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public final class TextExtractor {

    public static String extract(MultipartFile file) {
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8))) {

            return reader.lines().collect(Collectors.joining("\n"));

        } catch (IOException e) {
            throw new ExtracaoTextoException(e);
        }
    }
}
