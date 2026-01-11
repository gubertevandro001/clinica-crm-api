package com.gpa.clinica.crm.domain.util;

import java.util.UUID;

public final class IdGenerator {

    public static String generateId(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
