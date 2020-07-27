package com.github.tivonse.checkoutsystem.mod.sbo.controller;

import com.github.tivonse.checkoutsystem.mod.sbo.model.Product;
import com.github.tivonse.checkoutsystem.mod.sbo.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    private Product mockProduct;
    private static UUID uuid;
    private static final String mockProductJson =
            "{\"unitPrice\":3300,\"description\":\"GoPro HERO8 Black\"," +
            "\"bundled\":true,\"bundles\":[{\"product_id\":null,\"quantity\":1,\"name\":\"buy 1 get 1 free\"}]," +
            "\"discounted\":true,\"discounts\":[{\"product_id\":null,\"name\":\"20 percent off\",\"rate\":0.8,\"valid\":true}]}";

    @BeforeEach
    public void init() {
        mockProduct = new Product();
        uuid = UUID.randomUUID();

        mockProduct.setId(uuid);
        mockProduct.setUnitPrice(BigDecimal.valueOf(3300));
        mockProduct.setDescription("GoPro HERO8 Black");
        mockProduct.setDiscounted(true);
        mockProduct.setDiscounts(null);
        mockProduct.setBundled(true);
        mockProduct.setBundles(null);
    }

    @Test
    public void createProduct() throws Exception {
        when(productService.createProduct(any(Product.class))).thenReturn(mockProduct);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/api/v1/sbo/products/create")
                .accept(MediaType.APPLICATION_JSON)
                .content(mockProductJson)
                .characterEncoding("utf-8")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
        assertEquals("http://localhost/api/v1/sbo/products/create" + "/" + uuid.toString(),
                response.getHeader(HttpHeaders.LOCATION));

    }

}
