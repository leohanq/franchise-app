package com.leohanq.franchise.dataprovider.persistence;

public interface ProductMaxStockProjection {

    Long getProductId();

    String getProductName();

    Integer getStock();

    Long getLocationId();

    String getLocationName();
}
