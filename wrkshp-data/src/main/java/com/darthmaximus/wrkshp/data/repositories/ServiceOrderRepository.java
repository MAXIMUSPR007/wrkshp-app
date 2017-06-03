package com.darthmaximus.wrkshp.data.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.darthmaximus.wrkshp.data.domain.ServiceOrders;

@Repository
public interface ServiceOrderRepository extends PagingAndSortingRepository<ServiceOrders, Long>, JpaSpecificationExecutor<ServiceOrders> {
}
