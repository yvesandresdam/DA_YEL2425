package Exercise2;

import java.time.LocalDate;
public class Person {

    protected String name;
    protected LocalDate birthday;

    public String getName(){
        return name;
    }

    public void setName(String name) throws IllegalArgumentException{
        if(name == null)
            throw new IllegalArgumentException("El nombre introducido es incorrecto");
        this.name = name;
    }

    public LocalDate getBirthday(){
        return birthday;
    }
    public void setBirthday(LocalDate birthday) throws IllegalArgumentException{
        LocalDate currentDate = LocalDate.now();
        if(birthday.isBefore(currentDate))
            this.birthday = birthday;
        else
            throw new IllegalArgumentException("La fecha introducida es incorrecta");
    }
}
