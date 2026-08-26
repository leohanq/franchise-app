package com.leohanq.franchise.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "location")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private FranchiseEntity franchise;

    @OneToMany(mappedBy = "location")
    private List<ProductEntity> products;
}
