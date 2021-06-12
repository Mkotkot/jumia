package com.jumia.eg.forms;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class CustomerForm implements Serializable {
    private String country = "ALL";
}
