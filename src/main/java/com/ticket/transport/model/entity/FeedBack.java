package com.ticket.transport.model.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
@Entity
@Table(name = "feedback")
public class FeedBack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_id")
    private Long id;

    @Column(name = "create_time", nullable = false)
    private Date createTime;

    @Column(name = "detail", nullable = false)
    private String detail;

    @Column(name = "rating_score")
    private int ratingScore;

    @Column(name = "status", nullable = true)
    private String status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id")
    private Booking booking;

    @OneToMany(mappedBy = "backFeedback", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<FeedBack> replies;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply", referencedColumnName = "feedback_id")
    private FeedBack backFeedback;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private Account account;
}
