package com.ecommerce.catalogservice.service;

import com.ecommerce.catalogservice.jpa.CatalogEntity;

public interface CatalogService {
    Iterable<CatalogEntity> getAllCatalogs();
}
