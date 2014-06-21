package com.thoughtworks.com.mapper;

import com.thoughtworks.com.domain.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {
    @Select("SELECT * FROM products WHERE id = #{id}")
    Product find(@Param("id") int id);

    @Select("SELECT product.id as productId, product.name as productName, price.id as priceId, price.price as price, price.effectDate as effectDate FROM products product left join prices price on product.id=price.productId")
    List<ProductWithPrice> all(ProductHandler handler);
}
