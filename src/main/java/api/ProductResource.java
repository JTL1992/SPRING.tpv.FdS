package api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import wrappers.ProductFilterWrapper;
import wrappers.ProductsOutFilterWrapper;

@RestController
@RequestMapping(Uris.VERSION + "/products")
public class ProductResource {
    
    @RequestMapping(method = RequestMethod.POST)
    public List<ProductsOutFilterWrapper> getProductsByFilterMock(@RequestBody ProductFilterWrapper product){
        List<ProductsOutFilterWrapper> productosSalidaMock= new ArrayList<ProductsOutFilterWrapper> ();
        ProductsOutFilterWrapper productoMock= new ProductsOutFilterWrapper();
        productoMock.setId(0);
        productoMock.setReference("referenceMock");
        productoMock.setDescription("descriptionMock");
        productosSalidaMock.add(productoMock);
        return productosSalidaMock;
    }
}