package com.tiagosan44.auction.web.rest.vm;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

/**
 * View Model object for storing the user's key and password.
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KeyAndPasswordVM {

    String key;

    String newPassword;
}
