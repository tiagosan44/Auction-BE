package com.tiagosan44.auction.web.rest.errors;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class FieldErrorVM implements Serializable {

    private static final long serialVersionUID = 1L;

    String objectName;

    String field;

    String message;
}
