package com.example.jewelryWeb.models.Entity;

import lombok.*;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name = "collection")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Collection {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long collectionId;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String image;
    
    private String banner;

    private String avatar;


    private Boolean isActive;

    @ManyToMany
    @JoinTable(
        name = "product_collection",
        joinColumns = @JoinColumn(name = "collection_id"),
        inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products;
}