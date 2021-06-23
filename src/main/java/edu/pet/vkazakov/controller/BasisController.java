package edu.pet.vkazakov.controller;

import edu.pet.vkazakov.entity.Basis;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/basis")
@PreAuthorize("hasRole('ADMIN') or hasRole('ACCOUNTANT')")
public class BasisController {

	@RequestMapping("/list")
	public List<String> map(Basis basis) {
		List<String> result = new ArrayList<>();
		for (Basis b : Basis.values()) {
			result.add(b.name());
		}
		return result;
	}
}
