package com.darthmaximus.wrkshp.data.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.darthmaximus.wrkshp.data.domain.Customers;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customers, Long>, JpaSpecificationExecutor<Customers> {
}
