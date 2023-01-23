package com.montojo.userservice.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {


    private Long id;
    @NotNull
    private String username;

    private String amount;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDTO userDTO = (UserDTO) o;

        return getUsername().equals(userDTO.getUsername());
    }

    @Override
    public int hashCode() {
        return getUsername().hashCode();
    }
}
