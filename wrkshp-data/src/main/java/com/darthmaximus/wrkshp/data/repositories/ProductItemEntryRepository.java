package com.darthmaximus.wrkshp.data.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.darthmaximus.wrkshp.data.domain.ProductItemsEntries;

@Repository
public interface ProductItemEntryRepository extends PagingAndSortingRepository<ProductItemsEntries, Long>, JpaSpecificationExecutor<ProductItemsEntries> {
}
