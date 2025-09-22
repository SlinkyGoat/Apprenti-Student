package learn.spaceflight;

import learn.spaceflight.personnel.Astronaut;
import learn.spaceflight.spacecraft.InterstellarTransport;
import learn.spaceflight.spacecraft.MoonHopper;
import learn.spaceflight.spacecraft.Probe;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        // Spring code here...
        ApplicationContext container =
            new ClassPathXmlApplicationContext("dependency-configuration.xml");

//        Astronaut captain = container.getBean("captain", Astronaut.class);
//        Astronaut crew = container.getBean("crew", Astronaut.class);
//        System.out.println("Captain: " + captain);
//        System.out.println("Crew: " + crew);

//        MoonHopper hopper = container.getBean("moonHopper", MoonHopper.class);
//        System.out.println(hopper);

//        InterstellarTransport transport = container.getBean(InterstellarTransport.class);
//        System.out.println(transport);

        Probe one = container.getBean(Probe.class);
        Probe two = container.getBean(Probe.class);

        one.addDistance(1000);
        two.addDistance(4312);
        System.out.println("One: " + one);
        System.out.println("Two: " + two);
    }
}
