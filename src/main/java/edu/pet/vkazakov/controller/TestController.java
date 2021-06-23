package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    ContractService contractService;

}
