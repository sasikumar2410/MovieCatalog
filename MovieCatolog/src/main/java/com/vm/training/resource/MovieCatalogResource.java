package com.vm.training.resource;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vm.training.model.CatalogItems;


@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	
	@RequestMapping("/{userId}")
	public List<CatalogItems> getCatalog(@PathVariable("userId") String userId) {
		return Arrays.asList(
				new CatalogItems("firstmovie", "first movie desc", 1),
				new CatalogItems("secondmovie", "second movie desc", 2)

				);

	}

}
