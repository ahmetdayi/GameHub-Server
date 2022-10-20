package com.software.gameHub.dto;

import lombok.Data;

@Data
public class CreateCommentRequest {

    private String comment;

    private int customerId;

    private int gameId;

}
