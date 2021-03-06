package generators;

import enums.WorkWeekDayEnum;
import generators.animalFactories.WildAnimalFactory;
import models.Planner;
import models.TimeSlot;


import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;


public class WorkWeekPlanner {

    private static final SecureRandom random = new SecureRandom();



    public List<String> workDaysList = new ArrayList<>();
    public WorkWeekDayEnum[] workWeekDayEnums = WorkWeekDayEnum.values();







  /*  public void printPlanner(){
        WildAnimalFactory wildAnimalFactory = new WildAnimalFactory();


        System.out.println("╔" + "════════════" + "╦" + "════════════════════════════════════════════════════════" + "╦" + "════════════════════════════════════════════════════════" + "╗");
        System.out.println("╠" + "════════════" + "╣" + "                         " + getWorkDaysList().get(0) + "                         " + "║" + "                        " + getWorkDaysList().get(1) + "                         " + "║");
        System.out.println("╠" + "════════════" + "╬" + "════════════════════" + "╦" + "═══════════════════" + "╦"+"═══════════════" + "╬" + "════════════════════" + "╦" + "═══════════════════" + "╦" + "═══════════════" + "╣");
        System.out.println("║" + "    Time    " + "║" + "   " + doctorsList.get(0).getNameSurname() + "      " + "║" + "    " + doctorsList.get(1).getNameSurname() + "    " + "║" + "  " + doctorsList.get(2).getNameSurname() + "  " + "║"
                + "   " + doctorsList.get(0).getNameSurname() + "      " + "║" + "    " + doctorsList.get(1).getNameSurname() + "    " + "║" + "   " + doctorsList.get(2).getNameSurname() + " "+ "║");
        System.out.println("╠" + "════════════" + "╬" + "════════════════════" + "╩" + "═══════════════════" + "╩" + "═══════════════" + "╩" + "════════════════════" + "╩" + "═══════════════════" + "╩" + "═══════════════" + "╣");
        for(int i =0; i<17; i++){
            if(i==0 || i%2==0){

                System.out.println("║" + " " + getTimeSlotList().get(i).getSlotName() + " " + "║" + " " + wildAnimalFactory.createAnimal().getAnimal() + " " + "║" + wildAnimalFactory.createAnimal().getAnimal() + "║" + wildAnimalFactory.createAnimal().getAnimal() + "║" + wildAnimalFactory.createAnimal().getAnimal() + "║" + wildAnimalFactory.createAnimal().getAnimal() + "║" + wildAnimalFactory.createAnimal().getAnimal() + "║");
            } else{
                System.out.println("╠" + "════════════" +  "╬" + "═════════════════════════════════════════════════════════════════════════════════════════════════════════════════" + "╣");
            }
        }
        System.out.println("╚" + "════════════" + "╩" + "═════════════════════════════════════════════════════════════════════════════════════════════════════════════════" + "╝" );
    }

   */

}

