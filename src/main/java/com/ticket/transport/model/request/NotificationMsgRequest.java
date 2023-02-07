package com.ticket.transport.model.request;

import com.ticket.transport.utils.Trimble;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Builder(toBuilder = true)
public class NotificationMsgRequest implements Trimble {
    private Integer accountId;
    private String title;
    private String body;
    private String url;
    private String image;
    private String type;
}
