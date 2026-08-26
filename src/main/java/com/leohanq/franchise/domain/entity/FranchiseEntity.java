package com.leohanq.franchise.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "franchise")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FranchiseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String taxId;

    @OneToMany(mappedBy = "franchise")
    private List<LocationEntity> locations;
}
