package com.ticket.transport.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "detail")
    private String detail;

    @Column(name = "rating_score")
    private int ratingScore;

    @Column(name = "status")
    private String status;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "booking_id", referencedColumnName = "booking_id")
    private Booking booking;

    @JsonBackReference
    @OneToMany(mappedBy = "backFeedback", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<FeedBack> replies;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reply", referencedColumnName = "feedback_id")
    private FeedBack backFeedback;

    //Dùng BackReference cho trường account để tránh lặp vô hạn
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", referencedColumnName = "account_id")
    private Account account;
}
