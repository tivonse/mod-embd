package com.github.tivonse.checkoutsystem.mod.sbo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tivonse.checkoutsystem.mod.sbo.model.Product;
import com.github.tivonse.checkoutsystem.mod.sbo.service.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.math.BigDecimal;
import java.util.UUID;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
    private Product mockUpdatedProduct;
    private UUID uuid;

    @Before
    public void init() {
        mockProduct = new Product();
        mockUpdatedProduct = new Product();
        uuid = UUID.randomUUID();

        mockProduct.setId(uuid);
        mockProduct.setUnitPrice(BigDecimal.valueOf(2680));
        mockProduct.setDescription("GoPro HERO5 Silver");
        mockProduct.setDiscounted(true);
        mockProduct.setDiscounts(null);
        mockProduct.setBundled(true);
        mockProduct.setBundles(null);

        mockUpdatedProduct.setId(UUID.fromString("cc6ef721-0aba-4014-a285-3a8af375d9ef"));
        mockUpdatedProduct.setUnitPrice(BigDecimal.valueOf(3300));
        mockUpdatedProduct.setDescription("GoPro HERO8 Black");
    }

    @Test
    public void createOneProduct() throws Exception {
        when(productService.save(Mockito.any(Product.class))).thenReturn(mockProduct);

        ObjectMapper objectMapper = new ObjectMapper();
        String mockProductAsJson = objectMapper.writeValueAsString(mockProduct);

        ResultActions result = mockMvc.perform(post("/api/v1/sbo/products")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(mockProductAsJson)
        );

        result.andExpect(status().isAccepted())
                .andExpect(jsonPath("$.description").value("GoPro HERO5 Silver"))
                .andExpect(jsonPath("$.unitPrice").value(BigDecimal.valueOf(2680)));

    }

    @Test
    public void updateProductMeta() throws Exception {
        when(productService.updateById(Mockito.any(Product.class))).thenReturn(mockUpdatedProduct);

        ObjectMapper objectMapper = new ObjectMapper();
        String mockUpdatedProductAsJson = objectMapper.writeValueAsString(mockUpdatedProduct);

        ResultActions result = mockMvc.perform(put("/api/v1/sbo/products")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
                .content(mockUpdatedProductAsJson)
        );

        result.andExpect(status().isAccepted())
                .andExpect(jsonPath("$.description").value("GoPro HERO8 Black"))
                .andExpect(jsonPath("$.unitPrice").value(BigDecimal.valueOf(3300)));
    }

    @Test
    public void deleteProduct() throws Exception {
        doReturn(HttpStatus.ACCEPTED).when(productService).deleteById(Mockito.anyString());

        ResultActions result = mockMvc.perform(delete("/api/v1/sbo/products" + "/" + uuid.toString())
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8")
        );

        result.andExpect(status().isAccepted()).andReturn();
    }

}
