package ZAD_20_DniTygodnia;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MyModel extends AbstractListModel {

    List<String> stringList;
    LocalDate today;
    LocalDate firstDay;
    LocalDate firstDayNextMonth;
    LocalDate moveDate;
    int nowMonthInt;
    int nowYear;
    int nowDay;
    int id;

    MyModel(){
        stringList = new ArrayList<>();
        today = LocalDate.now();

        //TESTS
//        today = today.plusMonths(1); //31 DNI - LIPIEC 2018
//        today = today.minusMonths(4); //28 DNI - LUTY 2018
//        today = today.minusMonths(4).minusYears(2); //29 DNI - LUTY 2016

        nowYear = today.getYear();
        nowMonthInt = today.getMonthValue();
        nowDay = today.getDayOfMonth();

        firstDay = today.minusDays(nowDay-1);
        firstDayNextMonth = firstDay.plusMonths(1);
        moveDate = firstDay;

        createElements();
    }

    public void createElements(){
        while(moveDate.isBefore(firstDayNextMonth)){
            stringList.add(moveDate.getDayOfMonth()+" - "+moveDate.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("PL")));
            moveDate = moveDate.plusDays(1);
        }
    }

    @Override
    public int getSize() {
        return stringList.size();
    }

    @Override
    public Object getElementAt(int index) {
        return stringList.get(index);
    }

    public String getTittle(){
        return nowMonthInt+"."+nowYear;
    }

}
