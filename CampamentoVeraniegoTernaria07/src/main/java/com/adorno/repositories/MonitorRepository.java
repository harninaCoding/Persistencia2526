package com.adorno.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adorno.modelo.Monitor;

public interface MonitorRepository extends JpaRepository<Monitor, Long> {

}
