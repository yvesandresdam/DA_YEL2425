package Exercise2;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String phone;
    private List<Company> companiesList = new ArrayList<Company>();

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) throws IllegalArgumentException{
        if(phone == null)
            throw new IllegalArgumentException("El telefono introducido es incorrecto");
        this.phone = phone;
    }

    public List<Company> getCompanies(){
        return companiesList;
    }

    public void addCompany(Company company) throws IllegalArgumentException{
        if(company == null)
            throw new IllegalArgumentException("La empresa introducida es incorrecta");
        companiesList.add(company);
    }
}
