package springbook2test.learningtest.spring.pojo;

import org.junit.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanNameReference;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.support.StaticApplicationContext;
import springbook2.learningtest.spring.pojo.Hello;
import springbook2.learningtest.spring.pojo.StringPrinter;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertThat;
/**
 * Created by adaeng on 27/03/2019.
 * 스프링의 설정 메타정보는 BeanDefinition 인터페이스로 표현되는 순수한 추상 정보이다
 * 스프링 애플리케이션이란 POJO클래스의 설정 메타정보를 이용해 IoC 컨테이너가 만들어주는 오브젝트의 조합이라 볼수 있다
 * IoC 컴테이너가 관리하는 빈은 오브젝트 단위지 클래스 단위가 아니다!(이유 빈마다 설정값을 다르게 하여 여러군데에 사용하기 위해)
 */
public class IoCTest {

    @Test
    public void simpleStaticApplicationContextTest(){
//        Hello target = new Hello();
        StaticApplicationContext ac = new StaticApplicationContext(); //IoC 컨테이너 생성 생성과 동시에 컨테이너로 동작한다.
        ac.registerPrototype("hello1", Hello.class);

        Hello hello = ac.getBean("hello1",Hello.class);
        assertThat(hello,is(notNullValue()) );

        BeanDefinition helloDef = new RootBeanDefinition(Hello.class);
        helloDef.getPropertyValues().addPropertyValue("name", "Spring");
        ac.registerBeanDefinition("hello2", helloDef);

        Hello hello1 = ac.getBean("hello2", Hello.class);

        assertThat(hello, is(not(hello1)));
        assertThat(ac.getBeanFactory().getBeanDefinitionCount(),is(2));
    }

    @Test
    public void registerBeanWithDependency(){
        StaticApplicationContext ac = new StaticApplicationContext();

        ac.registerBeanDefinition("printer", new RootBeanDefinition(StringPrinter.class));

        BeanDefinition helloef = new RootBeanDefinition(Hello.class); //빈 메타정보를 담은 오브젝트를 만드는 과정 <bean id="~~" class ="~~"과 같다>
        helloef.getPropertyValues().addPropertyValue("name","Spring");//<propertie name="" value과정
        helloef.getPropertyValues()
                .addPropertyValue("printer",
                        new RuntimeBeanReference("printer"));// <propertie ret과정과 같다>

        ac.registerBeanDefinition("hello",helloef);//메타 빈 정보 등록

        Hello hello = ac.getBean("hello", Hello.class);
        hello.print();

        assertThat(ac.getBean("printer").toString(),is("Hello Spring"));
    }

    


}
