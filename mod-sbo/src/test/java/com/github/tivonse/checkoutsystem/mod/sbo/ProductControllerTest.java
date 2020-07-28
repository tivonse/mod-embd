package com.github.tivonse.checkoutsystem.mod.sbo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tivonse.checkoutsystem.mod.sbo.model.Product;
import com.github.tivonse.checkoutsystem.mod.sbo.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    private Product mockProduct;

    @Before
    public void init() {
        mockProduct = new Product();
        mockProduct.setUnitPrice(BigDecimal.valueOf(3300));
        mockProduct.setDescription("GoPro HERO8 Black");
        mockProduct.setDiscounted(true);
        mockProduct.setDiscounts(null);
        mockProduct.setBundled(true);
        mockProduct.setBundles(null);
    }

    @Test
    public void createOneProduct() throws Exception {
        when(productService.save(Mockito.any(Product.class))).thenReturn(mockProduct);

        ObjectMapper objectMapper = new ObjectMapper();
        String mockProductAsJson = objectMapper.writeValueAsString(mockProduct);

        ResultActions result = mockMvc.perform(post("/api/v1/sbo/products/create")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(mockProductAsJson)
        );

        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.description").value("GoPro HERO8 Black"))
                .andExpect(jsonPath("$.unitPrice").value(BigDecimal.valueOf(3300)));

    }

    @Test
    public void updateProductMeta() {

    }

    @Test
    public void deleteProduct() {

    }

}
