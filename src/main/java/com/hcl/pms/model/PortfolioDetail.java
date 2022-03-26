package com.hcl.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity(name = "portfolio_details")
public class PortfolioDetail extends BaseEntity{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="portfolio_id")
    private Long portfolioId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_ref_no")
    private OrderDetail orderDetail;

    @Column(name="credit")
    private Double credit;

    @Column(name="debit")
    private Double debit;

    @Column(name="running_balance")
    private Double runningBalance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="asset_id")
    private AssetDetail assetDetail;
    
}
