package com.pp.CruiseLogSpring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pp.CruiseLogSpring.domain.Cruise;

public interface CruiseRepository extends JpaRepository<Cruise, Long>{

}
