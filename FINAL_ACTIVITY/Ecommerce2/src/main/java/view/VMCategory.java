package view;

import model.Category;

import java.util.List;

class documentatingVMCategory {
    public void documentatinglistAllCategory(List<Category> listResult, ModelType modelType) {
        if (modelType == ModelType.MODEL1) {
            for (Category category : listResult) {
                //DISPLAYS:
                //---------
                //'Category id: @category_ID - Category name: @category_NAME'
            }
        } else if (modelType == ModelType.MODEL2) {
            for (Category category : listResult) {
                //DISPLAYS:
                //---------
                //'Category id: @category_ID'
            }
        } else if (modelType == ModelType.MODEL3) {
            for (Category category : listResult) {
                //DISPLAYS:
                //---------
                //'Category name: @category_NAME'
            }
        }
    }
}

public class VMCategory extends ViewModel {
    public void listAllCategory(List<Category> listResult, ModelType modelType) {
        if (modelType == ModelType.MODEL1) {
            for (Category category : listResult) {
                System.out.printf("Category id: %d - Category name: %s%n", category.getId(), category.getCategoryName());
            }
        } else if (modelType == ModelType.MODEL2) {
            for (Category category : listResult) {
                System.out.printf("Category id: %d%n", category.getId());
            }
        } else if (modelType == ModelType.MODEL3) {
            for (Category category : listResult) {
                System.out.printf("Category name: %s%n", category.getCategoryName());
            }
        }
        UI.printingBlankLine();
    }
}
