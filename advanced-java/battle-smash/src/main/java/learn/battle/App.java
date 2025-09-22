package learn.battle;

import learn.battle.environment.Battle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("battle-config.xml");
        Battle battle = context.getBean(Battle.class);
        battle.run();


        /*
        REFLECT QUESTIONS:

        1.  How did changing the scope from singleton to prototype affect the battle?
                It changed the app so that a new fighter would have a new instance rather than it referencing itself
                which means if Mario is attacked, both Mario objects will get hit. With the scope=prototype
                they have their own objects so they are hit separately.

        2.  What was easy or difficult about configuring this battle?
                It was easy making the new locations and characters because I didn't have to do a lot of boilerplate
                with creating new objects and setting them up. It was still a little difficult remembering when
                I needed the id and making sure it was in the correct location

        3.  How did using Spring DI help you create unique configurations with minimal changes?
                I was able to simply input the values without changing the code itself. For things such as the
                announcer I was able to choose one of the announcer classes and it handled the rest of the work for me.


         */
    }
}
