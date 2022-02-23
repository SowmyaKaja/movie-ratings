package io.javabrains.moviecatalogeservice.Resource;

import io.javabrains.moviecatalogeservice.models.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;


@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

@RequestMapping("/{userID}")
    public List<CatalogItem> getCatalog(@PathVariable("userID") String userID) {
        return Collections.singletonList(
                new CatalogItem("Aarya", "very good", "5")
        );
    }
}
