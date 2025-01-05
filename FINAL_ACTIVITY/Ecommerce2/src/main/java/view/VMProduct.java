package view;

import model.Product;
import java.util.List;

class documentatingVMProduct {
    public void documentatinglistAllCategory(List<Product> listResult, ModelType modelType) {
        if (modelType == ModelType.MODEL1) {
            for (Product product : listResult) {
                //DISPLAYS:
                //---------
                //'Product id: @product_ID - Product name: @product_NAME - Product description: @product_description'
            }
        } else if (modelType == ModelType.MODEL2) {
            for (Product product : listResult) {
                //DISPLAYS:
                //---------
                //'Product id: @product_ID'
            }
        } else if (modelType == ModelType.MODEL3) {
            for (Product product : listResult) {
                //DISPLAYS:
                //---------
                //'Product name: @product_NAME'
            }
        }
    }
}
public class VMProduct extends ViewModel {
    public void listAllProduct(List<Product> listResult, ModelType modelType) {
        if (modelType == ModelType.MODEL1) {
            for (Product product : listResult) {
                System.out.printf("Product id: %d - Product name: %s - Product description: %s%n", product.getId(), product.getProductName(), product.getDescription());
            }
        } else if (modelType == ModelType.MODEL2) {
            for (Product product : listResult) {
                System.out.printf("Product id: %d%n", product.getId());
            }
        } else if (modelType == ModelType.MODEL3) {
            for (Product product : listResult) {
                System.out.printf("Product name: %s%n", product.getProductName());
            }
        }
        UI.printingBlankLine();
    }
}

