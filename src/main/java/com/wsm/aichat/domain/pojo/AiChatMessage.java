package com.wsm.aichat.domain.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AiChatMessage {

    private Long messageId;

    private String role;

    private String context;
}
